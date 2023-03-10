package com.queries.stackoverflowbackend.web;

import com.queries.stackoverflowbackend.dto.CommentsDto;
import com.queries.stackoverflowbackend.entity.Comments;
import com.queries.stackoverflowbackend.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentsController {

    @Autowired
    CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/by-id")
    public ResponseEntity<CommentsDto> getCommentDetails(@RequestParam Long commentId) {
        log.info("End point to fetch comment details by id");
        CommentsDto commentDetails = commentService.getCommentDetails(commentId);
        return new ResponseEntity<>(commentDetails, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Comments> addCommentDetails(@RequestBody Comments comment) {
        log.info("End point to add comment details");
        Comments comments = commentService.addCommentDetails(comment);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/feedback")
    public ResponseEntity<Comments> updateUserFeedback(@RequestParam Long commentId, boolean feedback) {
        log.info("End point to update user feedback");
        Comments comments = commentService.updateUserFeedback(commentId, feedback);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/keyword")
    public ResponseEntity<Optional<List<CommentsDto>>> getCommentsForUser(@RequestParam String keyword) {
        log.info("End point to retrieve comment details");
        Optional<List<CommentsDto>> commentsList = commentService.getCommentsForUser(keyword);
        return new ResponseEntity<>(commentsList, HttpStatus.OK);
    }

}
