package com.queries.stackoverflowbackend.repository;

import com.queries.stackoverflowbackend.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {

    public Comments findCommentsById(Long id);

    public Optional<List<Comments>> findByDescriptionContainsOrTopicContainsAllIgnoreCase(String description, String topic);
}
