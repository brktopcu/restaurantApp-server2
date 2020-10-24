package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Comment;
import com.restaurant.restaurantappserver.domain.Restaurant;

public interface CommentService {

    Comment getById(Long id);

    Comment saveNewComment(Comment comment, Restaurant restaurant);
}
