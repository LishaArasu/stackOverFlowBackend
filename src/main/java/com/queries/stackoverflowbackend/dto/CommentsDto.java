package com.queries.stackoverflowbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto implements Comparable<CommentsDto> {
    private Long id;
    private String topic;
    private String description;
    private Long numberOfLikes;
    private Long numberOfDislikes;

    @Override
    public int compareTo(CommentsDto o) {
        long l = o.getNumberOfLikes() - o.getNumberOfDislikes();
        return (int) (l - (this.numberOfLikes - this.numberOfDislikes));
    }
}
