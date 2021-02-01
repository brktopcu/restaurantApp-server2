package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.domain.RestaurantPicture;

import java.util.List;

public interface RestaurantPictureService {
    RestaurantPicture saveRestaurantPicture(byte[] restaurantPicture, Restaurant restaurant);
    List<String> getAllPicturesByRestaurantId(Long restaurantId);
}
