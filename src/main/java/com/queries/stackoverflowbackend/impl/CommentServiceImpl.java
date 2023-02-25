package com.queries.stackoverflowbackend.impl;

import com.queries.stackoverflowbackend.dto.CommentsDto;
import com.queries.stackoverflowbackend.dto.CommentsMapper;
import com.queries.stackoverflowbackend.entity.Comments;
import com.queries.stackoverflowbackend.exceptions.ResourceNotfoundException;
import com.queries.stackoverflowbackend.helper.CommentsHelper;
import com.queries.stackoverflowbackend.repository.CommentRepository;
import com.queries.stackoverflowbackend.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepo;

    @Autowired
    CommentsHelper commentsHelper;

    private final CommentsMapper commentsMapper;

    public CommentServiceImpl(CommentRepository commentRepo, CommentsHelper commentsHelper, CommentsMapper commentsMapper) {
        this.commentRepo = commentRepo;
        this.commentsHelper = commentsHelper;
        this.commentsMapper = commentsMapper;
    }


    @Override
    public CommentsDto getCommentDetails(Long id) {
        Comments commentsById = commentRepo.findCommentsById(id);
        if (commentsById == null) {
            log.error("Comment details not found for the comment id : {}", id);
            throw new ResourceNotfoundException("Comment not found for id {" + id + "}");
        }
        return commentsMapper.modelToDto(commentsById);
    }

    @Override
    public Comments addCommentDetails(Comments comment) {
        commentRepo.save(comment);
        return comment;
    }

    @Override
    public Comments updateUserFeedback(Long id, boolean feedback) {
        CommentsDto commentDetails = getCommentDetails(id);
        if (commentDetails == null) {
            log.error("Comment details not found for the comment id : {}", id);
            throw new ResourceNotfoundException("Comment not found for id {" + id + "}");
        }
        Comments comments = commentsHelper.countLikeOrDislikes(feedback, commentDetails);
        commentRepo.save(comments);
        return comments;
    }

    @Override
    public Optional<List<CommentsDto>> getCommentsForUser(String keyword) {
        Optional<List<Comments>> commentList = commentRepo.findByDescriptionContainsOrTopicContainsAllIgnoreCase(keyword, keyword);
        List<CommentsDto> dtoList = new ArrayList<>();
        if (commentList.get().isEmpty()) {
            log.error("No results for the search  : {}", keyword);
            throw new ResourceNotfoundException("No results for the search {" + keyword + "}");
        }
        if (commentList.isPresent()) {
            List<Comments> comments = commentList.get();
            for (Comments comment :
                    comments) {
                CommentsDto commentsDto = commentsMapper.modelToDto(comment);
                dtoList.add(commentsDto);
            }
            Collections.sort(dtoList);
            return Optional.of(dtoList);
        }
        return null;
    }

}
