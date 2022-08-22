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

//    @PostMapping
//    public CommentDto createComment(@RequestBody CommentDto commentDto) {
//        CommentDto newPost = this.commentService.createComment(commentDto);
//        return commentDto;
//    }
//
//    @GetMapping("/{commentId}")
//    public CommentDto getOneCommentById(@PathVariable Long commentId) {
//        return this.commentService.getOneCommentById(commentId);
//    }
//
//    @PutMapping
//    public CommentDto updateOneComment(@RequestBody CommentDto commentDto) {
//        return this.commentService.updateOneComment(commentDto);
//    }
//
//    @DeleteMapping("/{commentId}")
//    public void deleteOneCommentById(@PathVariable Long commentId) {
//        this.commentService.deleteOneCommentById(commentId);
//    }
}
