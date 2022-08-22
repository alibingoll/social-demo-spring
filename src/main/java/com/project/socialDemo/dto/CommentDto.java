package com.project.socialDemo.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private Long user_id;
    private Long post_id;
    private String text;

}
