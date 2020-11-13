package com.restaurant.restaurantappserver.services;


import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.domain.Rtable;

import java.util.List;

public interface TableService {

    Rtable getById(Long id);

    List<Rtable> getAllTablesForRestaurant(Long id);

    Rtable saveNewTable(Rtable rtable, Restaurant restaurant);

}
