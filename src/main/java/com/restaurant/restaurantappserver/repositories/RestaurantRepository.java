package com.restaurant.restaurantappserver.repositories;

import com.restaurant.restaurantappserver.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    List<Restaurant> findByRestaurantNameContaining(String search);

    @Query("select distinct x.restaurantCity from Restaurant x")
    List<String> findDistinctRestaurants();

    @Query("select distinct x.restaurantCategory from Restaurant x")
    List<String> findDistinctCategories();
}
