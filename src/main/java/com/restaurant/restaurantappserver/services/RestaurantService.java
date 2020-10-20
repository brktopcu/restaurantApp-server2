package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.exceptions.RestaurantNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface RestaurantService {

    Restaurant getById(Long restaurantId);

    Restaurant saveNewRestaurant(Restaurant restaurant);
}
