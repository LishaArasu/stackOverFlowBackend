package com.queries.stackoverflowbackend.impl;

import com.queries.stackoverflowbackend.entity.Comments;
import com.queries.stackoverflowbackend.helper.CommentsHelper;
import com.queries.stackoverflowbackend.repository.CommentRepository;
import com.queries.stackoverflowbackend.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepo;

    @Autowired
    CommentsHelper commentsHelper;

    @Override
    public Comments getCommentDetails(Long id) {
        return commentRepo.findCommentsById(id);
    }

    @Override
    public void addCommentDetails(Comments comment) {
        commentRepo.save(comment);
    }

    @Override
    public void updateUserFeedback(Long id, boolean feedback) {
        Comments commentDetails = getCommentDetails(id);
        commentsHelper.countLikeOrDislikes(feedback, commentDetails);
        commentRepo.save(commentDetails);
    }

    @Override
    public Optional<List<Comments>> getCommentsForUser(String keyword) {
        Optional<List<Comments>> commentList = commentRepo.findByDescriptionContainsOrTopicContainsAllIgnoreCaseOrderByNumberOfLikesDesc(keyword, keyword);
        if (commentList.isPresent()) {
            return commentList;
        }
        log.error("No Comments Found For the search {}", keyword);
        return null;
    }
}
