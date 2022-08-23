package com.project.socialDemo.dto;

import com.project.socialDemo.entities.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {

    private Long id;
    private Long user_id;
    private String title;
    private String text;
    private String userName;

    public PostDto(Post post){
        this.id = post.getId();
        this.user_id = post.getUser().getId();
        this.title = post.getTitle();
        this.text = post.getText();
        this.userName = post.getUser().getUserName();
    }
}
