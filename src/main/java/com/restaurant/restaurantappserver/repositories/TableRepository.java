package com.restaurant.restaurantappserver.repositories;

import com.restaurant.restaurantappserver.domain.Comment;
import com.restaurant.restaurantappserver.domain.Rtable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<Rtable, Long> {

    @Query("select t from Rtable t where t.restaurant.restaurantId = :id")
    List<Rtable> findTables(@Param("id") Long id);
}
