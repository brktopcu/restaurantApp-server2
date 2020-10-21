package com.restaurant.restaurantappserver.web;

import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.services.RestaurantService;
import com.restaurant.restaurantappserver.services.ValidationErrorService;
import com.restaurant.restaurantappserver.services.ValidationErrorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final ValidationErrorService validationErrorService;

    @PostMapping
    public ResponseEntity<?> saveNewRestaurant(@Valid @RequestBody Restaurant restaurant, BindingResult result){

        ResponseEntity<?> errorMap = validationErrorService.validationMap(result);
        if(errorMap!=null) return errorMap;

        Restaurant newRestaurant = restaurantService.saveNewRestaurant(restaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);

    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> getRestaurantById(@PathVariable Long restaurantId){
        Restaurant restaurantFound = restaurantService.getById(restaurantId);
        return new ResponseEntity<>(restaurantFound, HttpStatus.OK);
    }

}
