package com.restaurant.restaurantappserver.web;

import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.services.RestaurantService;
import com.restaurant.restaurantappserver.services.ValidationErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/restaurant")
@CrossOrigin
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

    @PostMapping("/thumbnail/{restaurantId}")
    public ResponseEntity<?> saveRestaurantThumbnail(@RequestParam("imageFile") MultipartFile imageFile,
                                                     @PathVariable Long restaurantId) throws IOException {

        Restaurant restaurant = restaurantService.saveRestaurantThumbnail(restaurantId, imageFile.getBytes());

        return new ResponseEntity<>(restaurant,HttpStatus.OK);
    }


    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> getRestaurantById(@PathVariable Long restaurantId){
        Restaurant restaurantFound = restaurantService.getById(restaurantId);

        return new ResponseEntity<>(restaurantFound, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        List<Restaurant> restaurantList = restaurantService.getAllRestaurants();

        return new ResponseEntity<>(restaurantList, HttpStatus.OK);

    }

    @GetMapping("/search/{searchTerm}")
    public ResponseEntity<List<Restaurant>> searchRestaurantName(@PathVariable String searchTerm){
        List<Restaurant> restaurantList = restaurantService.searchByRestaurantName(searchTerm);

        return new ResponseEntity<>(restaurantList, HttpStatus.OK);

    }

    @GetMapping("/search/cities")
    public ResponseEntity<List<String>> getRestaurantCities(){
        List<String> cityList = restaurantService.findDistinctRestaurantCities();

        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }

    @GetMapping("/search/categories")
    public ResponseEntity<List<String>> getRestaurantCategories(){
        List<String> categoryList = restaurantService.findDistinctRestaurantCategories();

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("/favourite/{restaurantId}")
    public ResponseEntity<Restaurant> addRestaurantAsFavourite(@PathVariable Long restaurantId, Principal principal){
        Restaurant restaurant = restaurantService.saveRestaurantAsFavourite(restaurantId, principal.getName());

        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @GetMapping("/favourite")
    public ResponseEntity<Set<Restaurant>> getFavouriteRestaurants(Principal principal){
        Set<Restaurant> favouriteRestaurants = restaurantService.getFavouriteRestaurants(principal.getName());

        return new ResponseEntity<>(favouriteRestaurants, HttpStatus.OK);
    }

    @DeleteMapping("/favourite/delete/{restaurantId}")
    public ResponseEntity<String> deleteFromFavourites(@PathVariable Long restaurantId, Principal principal){
        String msg = restaurantService.deleteFavourite(restaurantId, principal.getName());

        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
