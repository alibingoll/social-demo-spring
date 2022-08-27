package com.project.socialDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.socialDemo.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    private String title;

    @Lob
    @Column(columnDefinition = "text")
    private String text;

    public Post(PostDto postDto){
        this.text = postDto.getText();
        this.title = postDto.getTitle();
    }
}
