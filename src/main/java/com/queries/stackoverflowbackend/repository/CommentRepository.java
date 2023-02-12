package com.queries.stackoverflowbackend.repository;

import com.queries.stackoverflowbackend.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.basic.BasicListUI;
import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {

    public Comments findCommentsById(Long id);
    public Optional<List<Comments>> findByDescriptionContainsOrTopicContainsAllIgnoreCaseOrderByNumberOfLikesDesc(String description,String topic);
}
