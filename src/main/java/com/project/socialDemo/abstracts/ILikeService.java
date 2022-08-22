package com.project.socialDemo.abstracts;

import com.project.socialDemo.dto.LikeDto;

import java.util.List;
import java.util.Optional;

public interface ILikeService {
    List<LikeDto> getAllLikes(Optional<Long> userId, Optional<Long> postId);
    LikeDto getOneLikeById(Long id);
    LikeDto createLike(LikeDto likeDto);
    LikeDto updateOneLike(LikeDto likeDto);
    void deleteOneLikeById(Long id);
}
