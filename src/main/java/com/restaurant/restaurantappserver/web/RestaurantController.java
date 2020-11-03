package com.restaurant.restaurantappserver.web;

import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.services.HeaderService;
import com.restaurant.restaurantappserver.services.RestaurantService;
import com.restaurant.restaurantappserver.services.ValidationErrorService;
import com.restaurant.restaurantappserver.services.ValidationErrorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final ValidationErrorService validationErrorService;
    private final HeaderService headerService;

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

        return new ResponseEntity<>(restaurantFound, headerService.getHeaders(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        List<Restaurant> restaurantList = restaurantService.getAllRestaurants();

        return new ResponseEntity<>(restaurantList, headerService.getHeaders(), HttpStatus.OK);

    }

    @GetMapping("/search/{searchTerm}")
    public ResponseEntity<List<Restaurant>> searchRestaurantName(@PathVariable String searchTerm){
        List<Restaurant> restaurantList = restaurantService.searchByRestaurantName(searchTerm);

        return new ResponseEntity<>(restaurantList, headerService.getHeaders(), HttpStatus.OK);

    }

    @GetMapping("/search/cities")
    public ResponseEntity<List<String>> getRestaurantCities(){
        List<String> cityList = restaurantService.findDistinctRestaurantCities();

        return new ResponseEntity<>(cityList, headerService.getHeaders(), HttpStatus.OK);
    }

    @GetMapping("/search/categories")
    public ResponseEntity<List<String>> getRestaurantCategories(){
        List<String> categoryList = restaurantService.findDistinctRestaurantCategories();

        return new ResponseEntity<>(categoryList, headerService.getHeaders(), HttpStatus.OK);
    }

}
