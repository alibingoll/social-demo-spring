package com.project.socialDemo.dto;

import lombok.Data;

@Data
public class PostDto {

    private Long id;
    private Long user_id;
    private String title;
    private String text;
    private String userName;
}
