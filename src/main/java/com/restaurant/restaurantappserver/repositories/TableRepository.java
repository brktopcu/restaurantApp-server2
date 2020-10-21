package com.restaurant.restaurantappserver.repositories;

import com.restaurant.restaurantappserver.domain.Rtable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Rtable, Long> {
}
