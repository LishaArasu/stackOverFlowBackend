package com.queries.stackoverflowbackend.service;

import com.queries.stackoverflowbackend.entity.Comments;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comments getCommentDetails(Long id);

    void addCommentDetails(Comments comment);
    void updateUserFeedback(Long id, boolean feedback);

    Optional<List<Comments>> getCommentsForUser(String keyword);
}
