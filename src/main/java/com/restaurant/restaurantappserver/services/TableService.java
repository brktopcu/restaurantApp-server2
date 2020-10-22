package com.restaurant.restaurantappserver.services;


import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.domain.Rtable;

public interface TableService {

    Rtable getById(Long id);

    Rtable saveNewTable(Rtable rtable, Restaurant restaurant);

}
