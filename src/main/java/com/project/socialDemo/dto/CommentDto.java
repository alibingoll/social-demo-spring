package com.project.socialDemo.dto;

import com.project.socialDemo.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private Long user_id;
    private Long post_id;
    private String text;

    public CommentDto(Comment comment){
        this.user_id = comment.getUser().getId();
        this.post_id = comment.getPost().getId();
        this.text = comment.getText();
        this.id = comment.getId();
    }
}
