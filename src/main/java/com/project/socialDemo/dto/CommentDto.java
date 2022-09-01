package com.project.socialDemo.dto;

import com.project.socialDemo.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private Long userId;
    private Long postId;
    private String text;

    private String userName;
    public CommentDto(Comment comment){
        this.userId = comment.getUser().getId();
        this.userName = comment.getUser().getUserName();
        this.postId = comment.getPost().getId();
        this.text = comment.getText();
        this.id = comment.getId();
    }
}
