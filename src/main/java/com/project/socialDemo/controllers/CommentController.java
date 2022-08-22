package com.project.socialDemo.controllers;

import com.project.socialDemo.abstracts.ICommentService;
import com.project.socialDemo.abstracts.IPostService;
import com.project.socialDemo.dto.CommentDto;
import com.project.socialDemo.dto.PostDto;
import com.project.socialDemo.entities.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final ICommentService commentService;


    @GetMapping
    @Transactional
    public List<CommentDto> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        List<CommentDto> comments = this.commentService.getAllComments(userId,postId);
        return comments;
    }

    @PostMapping
    public CommentDto createComment(@RequestBody CommentDto commentDto){
        CommentDto newPost = this.commentService.createComment(commentDto);
        return commentDto;
    }
//
//    @GetMapping("/{postId}")
//    public PostDto getOnePost(@PathVariable Long postId){
//         return this.postService.getOnePostById(postId);
//    }
//
//    @PutMapping
//    public PostDto updateOnePost(@RequestBody PostDto postDto) {
//        return this.postService.updateOnePost(postDto);
//    }
//
//    @DeleteMapping("/{userId}")
//    public void deleteOnePostById(@PathVariable Long postId){
//        this.postService.deleteOnePostById(postId);
//    }
}
