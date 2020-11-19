package com.restaurant.restaurantappserver.services;

import com.restaurant.restaurantappserver.domain.ApplicationUser;
import com.restaurant.restaurantappserver.domain.Comment;
import com.restaurant.restaurantappserver.domain.Restaurant;
import com.restaurant.restaurantappserver.exceptions.NotFoundException;
import com.restaurant.restaurantappserver.repositories.CommentRepository;
import com.restaurant.restaurantappserver.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Override
    public Comment getById(Long id) {

        Optional<Comment> commentFound = commentRepository.findById(id);
        if(commentFound.isEmpty()) throw new NotFoundException("Comment ID: "+id+" doesn't exist");

        return commentFound.get();
    }

    @Override
    public List<Comment> getAllComments(Long restaurantId) {
        List<Comment> commentList = commentRepository.findComments(restaurantId);

        return commentList;
    }

    @Override
    public Comment saveNewComment(Comment comment, Restaurant restaurant, String username) {
        ApplicationUser user = userRepository.findByUsername(username);
        comment.setUser(user);
        comment.setCommentWriter(user.getFullName());
        comment.setRestaurant(restaurant);
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        comment.setCommentDate(ft.format(date));

        restaurant.setTimesRated(restaurant.getTimesRated()+1);
        restaurant.setTotalRating(restaurant.getTotalRating()+(comment.getCommentScore()*10));
        Double tempDouble = ((double)restaurant.getTotalRating()/ restaurant.getTimesRated())/10;
        Double finalRestRating = BigDecimal.valueOf(tempDouble).setScale(1,RoundingMode.HALF_UP).doubleValue();
        restaurant.setRestaurantRating(finalRestRating);

        Comment savedComment = commentRepository.save(comment);

        return savedComment;
    }
}
