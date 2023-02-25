package com.queries.stackoverflowbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String topic;
    private String description;
    @Column(name = "likes")
    private Long numberOfLikes;
    @Column(name = "dislikes")
    private Long numberOfDislikes;
}
