package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Restaurant;

import java.util.List;
import java.util.Set;

public interface RestaurantService {

    Restaurant getById(Long restaurantId);

    List<Restaurant> getAllRestaurants();

    Restaurant saveNewRestaurant(Restaurant restaurant);

    Restaurant saveRestaurantAsFavourite(Long restaurantId, String username);

    Set<Restaurant> getFavouriteRestaurants(String username);

    String deleteFavourite(Long restaurantId, String username);

    List<Restaurant> searchByRestaurantName(String search);

    List<String> findDistinctRestaurantCities();

    List<String> findDistinctRestaurantCategories();
}
