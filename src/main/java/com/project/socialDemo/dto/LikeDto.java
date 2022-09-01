package com.project.socialDemo.dto;

import com.project.socialDemo.entities.Like;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeDto {
    private Long id;
    private Long userId;
    private Long postId;

    public LikeDto(Like like){
        this.userId = like.getUser().getId();
        this.postId = like.getPost().getId();
        this.id = like.getId();
    }
}
