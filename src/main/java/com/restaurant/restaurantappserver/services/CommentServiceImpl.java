package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.Comment;
import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.exceptions.NotFoundException;
import com.restaurant.restaurantappserver.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment getById(Long id) {

        Optional<Comment> commentFound = commentRepository.findById(id);
        if(commentFound.isEmpty()) throw new NotFoundException("Comment ID: "+id+" doesn't exist");

        return commentFound.get();
    }

    @Override
    public Comment saveNewComment(Comment comment, Restaurant restaurant) {

        comment.setRestaurant(restaurant);
        Comment savedComment = commentRepository.save(comment);

        return savedComment;
    }
}
