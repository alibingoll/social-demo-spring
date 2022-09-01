package com.project.socialDemo.controllers;

import com.project.socialDemo.abstracts.ICommentService;
import com.project.socialDemo.abstracts.ILikeService;
import com.project.socialDemo.dto.CommentDto;
import com.project.socialDemo.dto.LikeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {

    private final ILikeService likeService;


    @GetMapping
    @Transactional
    public List<LikeDto> getAllLikes(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        List<LikeDto> likes = this.likeService.getAllLikes(userId, postId);
        return likes;
    }

    @PostMapping
    public LikeDto createLike(@RequestBody LikeDto likeDto) {
        LikeDto like = this.likeService.createLike(likeDto);
        return likeDto;
    }

    @GetMapping("/{likeId}")
    public LikeDto getOneLikeById(@PathVariable Long likeId) {
        return this.likeService.getOneLikeById(likeId);
    }



    @DeleteMapping("/{commentId}")
    public void deleteOneLikeById(@PathVariable Long commentId) {
        this.likeService.deleteOneLikeById(commentId);
    }
}
