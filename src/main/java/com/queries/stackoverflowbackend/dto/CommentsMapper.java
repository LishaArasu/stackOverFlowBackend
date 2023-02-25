package com.queries.stackoverflowbackend.dto;

import com.queries.stackoverflowbackend.entity.Comments;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentsMapper {

    CommentsDto modelToDto(Comments comments);

    Comments dtoToModel(CommentsDto commentsDto);

}
