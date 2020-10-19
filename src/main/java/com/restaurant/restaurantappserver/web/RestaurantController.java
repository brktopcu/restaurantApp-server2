package com.restaurant.restaurantappserver.web;

import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.repositories.RestaurantRepository;
import com.restaurant.restaurantappserver.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<?> saveNewRestaurant(@RequestBody Restaurant restaurant){

        restaurantService.saveNewRestaurant(restaurant);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> getRestaurantById(@PathVariable Long restaurantId) throws ChangeSetPersister.NotFoundException {
        Restaurant restaurantFound = restaurantService.getById(restaurantId);
        return new ResponseEntity<>(restaurantFound, HttpStatus.OK);
    }

}
