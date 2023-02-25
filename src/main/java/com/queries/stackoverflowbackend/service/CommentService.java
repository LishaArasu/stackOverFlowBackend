package com.queries.stackoverflowbackend.service;

import com.queries.stackoverflowbackend.dto.CommentsDto;
import com.queries.stackoverflowbackend.entity.Comments;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    CommentsDto getCommentDetails(Long id);

    Comments addCommentDetails(Comments comment);

    Comments updateUserFeedback(Long id, boolean feedback);

    Optional<List<CommentsDto>> getCommentsForUser(String keyword);
}
