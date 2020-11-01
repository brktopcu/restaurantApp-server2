package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant getById(Long restaurantId);

    List<Restaurant> getAllRestaurants();

    Restaurant saveNewRestaurant(Restaurant restaurant);

    List<Restaurant> searchByRestaurantName(String search);
}
