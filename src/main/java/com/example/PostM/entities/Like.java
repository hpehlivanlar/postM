package com.example.PostM.entities;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="postlike")
@Data
public class Like {
    @Id
    Long id;
    Long postId;
    Long userId;
    
}
