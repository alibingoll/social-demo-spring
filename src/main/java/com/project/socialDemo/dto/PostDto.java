package com.project.socialDemo.dto;

import com.project.socialDemo.entities.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PostDto {

    private Long id;
    private Long userId;
    private String title;
    private String text;
    private String userName;
    private List<LikeDto> postLikes;

    public PostDto(Post post,List<LikeDto> likes){
        this.id = post.getId();
        this.userId = post.getUser().getId();
        this.title = post.getTitle();
        this.text = post.getText();
        this.userName = post.getUser().getUserName();
        this.postLikes = likes;
    }
}
