package com.example.PostM.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="post")
@Data
public class Post {

    @Id
    Long id;


    /*User user;*/

    String title;

    @Lob
    @Column(columnDefinition ="text")
    String text;

    /*Date createDate;*/
}
