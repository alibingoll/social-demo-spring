package com.project.socialDemo.controllers;

import com.project.socialDemo.abstracts.IPostService;
import com.project.socialDemo.abstracts.IUserService;
import com.project.socialDemo.dto.PostDto;
import com.project.socialDemo.entities.Post;
import com.project.socialDemo.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final IPostService postService;


    @GetMapping
    @Transactional
    public List<PostDto> getAllPosts(@RequestParam Optional<Long> userId){
        List<PostDto> posts = this.postService.getAllPosts(userId);
        return posts;
    }

    @PostMapping
    public PostDto createPost(@RequestBody PostDto postDto){
        PostDto newPost = this.postService.createPost(postDto);
        return postDto;
    }

    @GetMapping("/{postId}")
    public PostDto getOnePost(@PathVariable Long postId){
         return this.postService.getOnePostById(postId);
    }

    @PutMapping
    public PostDto updateOnePost(@RequestBody PostDto postDto) {
        return this.postService.updateOnePost(postDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteOnePostById(@PathVariable Long postId){
        this.postService.deleteOnePostById(postId);
    }
}
