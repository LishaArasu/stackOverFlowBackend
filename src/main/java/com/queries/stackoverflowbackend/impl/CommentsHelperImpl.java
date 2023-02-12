package com.queries.stackoverflowbackend.impl;

import com.queries.stackoverflowbackend.entity.Comments;
import com.queries.stackoverflowbackend.helper.CommentsHelper;
import org.springframework.stereotype.Service;

@Service
public class CommentsHelperImpl implements CommentsHelper {
    @Override
    public Comments countLikeOrDislikes(boolean feedback, Comments commentDetails) {
        if (feedback == true) {
            if (commentDetails.getNumberOfLikes() == null) {
                commentDetails.setNumberOfLikes(0L);
            }
            long incrementedValue = commentDetails.getNumberOfLikes() + 1L;
            commentDetails.setNumberOfLikes(incrementedValue);
            return commentDetails;
        } else {
            if (commentDetails.getNumberOfDislikes() == null) {
                commentDetails.setNumberOfDislikes(0L);
            }
            long incrementedValue = commentDetails.getNumberOfDislikes() + 1L;
            commentDetails.setNumberOfDislikes(incrementedValue);
            return commentDetails;
        }
    }
}
