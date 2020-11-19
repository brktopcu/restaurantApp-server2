package com.restaurant.restaurantappserver.web;

import com.restaurant.restaurantappserver.domain.ApplicationUser;
import com.restaurant.restaurantappserver.payload.JWTLoginSuccessResponse;
import com.restaurant.restaurantappserver.payload.LoginRequest;
import com.restaurant.restaurantappserver.security.JwtTokenProvider;
import com.restaurant.restaurantappserver.services.UserService;
import com.restaurant.restaurantappserver.services.ValidationErrorService;
import com.restaurant.restaurantappserver.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.restaurant.restaurantappserver.security.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final ValidationErrorService validationErrorService;
    private final UserService userService;
    private final UserValidator userValidator;
    private final JwtTokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = validationErrorService.validationMap(result);
        if(errorMap != null) return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);

        return new ResponseEntity<>(new JWTLoginSuccessResponse(true, jwt), HttpStatus.OK);
    }

    @PostMapping("/register")
    @CrossOrigin
    public ResponseEntity<?> registerUser(@Valid @RequestBody ApplicationUser user, BindingResult result){

        userValidator.validate(user,result);

        ResponseEntity<?> errorMap = validationErrorService.validationMap(result);
        if(errorMap != null) return errorMap;

        ApplicationUser newUser = userService.saveUser(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
