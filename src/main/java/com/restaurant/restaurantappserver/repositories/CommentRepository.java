package com.restaurant.restaurantappserver.repositories;

import com.restaurant.restaurantappserver.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query("select c from Comment c where c.restaurant.restaurantId = :id")
    List<Comment> findComments(@Param("id") Long id);
}
