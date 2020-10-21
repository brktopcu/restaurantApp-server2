package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Restaurant;

public interface RestaurantService {

    Restaurant getById(Long restaurantId);

    Restaurant saveNewRestaurant(Restaurant restaurant);
}
