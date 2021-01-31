package com.restaurant.restaurantappserver.web;


import com.restaurant.restaurantappserver.services.RestaurantService;
import com.restaurant.restaurantappserver.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    private final UserService userService;
    private final RestaurantService restaurantService;

    @DeleteMapping("/delete/restaurant/{restaurantId}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long restaurantId){
        return new ResponseEntity<>(restaurantService.deleteRestaurant(restaurantId), HttpStatus.OK);
    }

    @DeleteMapping("delete/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }
}
