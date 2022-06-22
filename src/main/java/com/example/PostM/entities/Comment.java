package com.example.PostM.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name="comment")
@Data
public class Comment {

    @Id
    Long id;

    Long postID;
    Long userId;

    @Lob
    @Column(columnDefinition = "text")
    String test;

    /* Post post;

    User user;*/




}
