package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Restaurant;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface RestaurantService {

    Restaurant getById(Long restaurantId) throws ChangeSetPersister.NotFoundException;

    Restaurant saveNewRestaurant(Restaurant restaurant);
}
