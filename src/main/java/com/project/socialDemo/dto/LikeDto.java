package com.project.socialDemo.dto;

import com.project.socialDemo.entities.Like;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeDto {
    private Long id;
    private Long user_id;
    private Long post_id;

    public LikeDto(Like like){
        this.user_id = like.getUser().getId();
        this.post_id = like.getPost().getId();
        this.id = like.getId();
    }
}
