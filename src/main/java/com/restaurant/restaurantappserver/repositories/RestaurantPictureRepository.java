package com.restaurant.restaurantappserver.repositories;

import com.restaurant.restaurantappserver.domain.RestaurantPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantPictureRepository extends JpaRepository<RestaurantPicture, Long> {
    @Query("select p.restaurantPicture from RestaurantPicture p where p.restaurant.restaurantId = :id")
    List<String> findRestaurantPictures(@Param("id") Long id);
}
