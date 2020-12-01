package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant getById(Long restaurantId);

    List<Restaurant> getAllRestaurants();

    Restaurant saveNewRestaurant(Restaurant restaurant);

    Restaurant saveRestaurantThumbnail(Long restaurantId, byte[] thumbnail);

    List<Restaurant> searchByRestaurantName(String search);

    List<String> findDistinctRestaurantCities();

    List<String> findDistinctRestaurantCategories();
}
