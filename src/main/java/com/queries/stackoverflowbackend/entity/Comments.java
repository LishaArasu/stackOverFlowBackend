package com.queries.stackoverflowbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    String topic;
    String description;
    @Column(name = "likes")
    Long numberOfLikes;
    @Column(name = "dislikes")
    Long numberOfDislikes;
}
