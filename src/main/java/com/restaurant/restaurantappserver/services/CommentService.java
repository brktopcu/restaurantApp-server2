package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Comment;
import com.restaurant.restaurantappserver.domain.Restaurant;

import java.util.List;

public interface CommentService {

    Comment getById(Long id);

    List<Comment> getAllComments(Long restaurantId);

    Comment saveNewComment(Comment comment, Restaurant restaurant, String username);
}
