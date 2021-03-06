package com.restaurant.restaurantappserver.web;

import com.restaurant.restaurantappserver.domain.Comment;
import com.restaurant.restaurantappserver.services.CommentService;
import com.restaurant.restaurantappserver.services.RestaurantService;
import com.restaurant.restaurantappserver.services.ValidationErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
@CrossOrigin
public class CommentController {

    private final CommentService commentService;
    private final RestaurantService restaurantService;
    private final ValidationErrorService validationErrorService;

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getComment(@PathVariable Long commentId){

        Comment commentFound = commentService.getById(commentId);

        return new ResponseEntity<>(commentFound, HttpStatus.OK);
    }

    @GetMapping("/all/{restaurantId}")
    public ResponseEntity<List<Comment>> getAllComments(@PathVariable Long restaurantId){

        List<Comment> comments = commentService.getAllComments(restaurantId);

        return new ResponseEntity<>(comments, HttpStatus.OK);

    }

    @PostMapping("/{restaurantId}")
    public ResponseEntity<?> saveComment(@Valid @RequestBody Comment comment,
                                         BindingResult bindingResult,
                                         @PathVariable Long restaurantId, Principal principal){

        ResponseEntity<?> errorMap = validationErrorService.validationMap(bindingResult);
        if(errorMap!=null) return errorMap;


        Comment savedComment = commentService.saveNewComment(comment, restaurantService.getById(restaurantId),
                principal.getName());

        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }
}
