package com.restaurant.restaurantappserver.web;

import com.restaurant.restaurantappserver.domain.ApplicationUser;
import com.restaurant.restaurantappserver.services.UserService;
import com.restaurant.restaurantappserver.services.ValidationErrorService;
import com.restaurant.restaurantappserver.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final ValidationErrorService validationErrorService;
    private final UserService userService;
    private final UserValidator userValidator;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody ApplicationUser user, BindingResult result){

        userValidator.validate(user,result);

        ResponseEntity<?> errorMap = validationErrorService.validationMap(result);
        if(errorMap != null) return errorMap;

        ApplicationUser newUser = userService.saveUser(user);

        return new ResponseEntity<ApplicationUser>(newUser, HttpStatus.CREATED);
    }
}
