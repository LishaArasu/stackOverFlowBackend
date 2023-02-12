package com.queries.stackoverflowbackend.helper;

import com.queries.stackoverflowbackend.entity.Comments;

public interface CommentsHelper {
    Comments countLikeOrDislikes(boolean feedback, Comments commentDetails);
}
