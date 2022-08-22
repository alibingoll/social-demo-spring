package com.project.socialDemo.abstracts;

import com.project.socialDemo.dto.PostDto;
import com.project.socialDemo.entities.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<Post> getAllPosts(Optional<Long> userId);
    PostDto getOnePostById(Long id);
    PostDto createPost(PostDto postDto);
    PostDto updateOnePost(PostDto postDto);
    void deleteOnePostById(Long id);
}
