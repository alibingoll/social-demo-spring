package com.project.socialDemo.services;

import com.project.socialDemo.abstracts.IPostService;
import com.project.socialDemo.abstracts.IUserService;
import com.project.socialDemo.dto.PostDto;
import com.project.socialDemo.entities.Post;
import com.project.socialDemo.entities.User;
import com.project.socialDemo.repos.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final PostRepository postRepository;
    private final IUserService userService;

    @Override
    public List<Post> getAllPosts(Optional<Long> userId) {
        if(userId.isPresent())
            return this.postRepository.findByUserId(userId.get());
        return postRepository.findAll();
    }

    @Override
    public PostDto getOnePostById(Long id) {
        Post post = this.postRepository.findById(id).orElse(null);
        if(post!=null){
            PostDto postDto = new PostDto();
            postDto.setTitle(post.getTitle());
            postDto.setText(post.getText());
            postDto.setUserName(post.getUser().getUserName());
            return postDto;
        }
        return null;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        User user = this.userService.findById(postDto.getUser_id());
        if(user!=null){
            Post newPost = new Post();
            newPost.setText(postDto.getText());
            newPost.setTitle(postDto.getTitle());
            newPost.setUser(user);
            this.postRepository.save(newPost);
            return postDto;
        }
        return null;
    }

    @Override
    public PostDto updateOnePost(PostDto postDto) {
        Post post = this.postRepository.findById(postDto.getId()).orElse(null);
        if(post!=null){
            post.setText(postDto.getText());
            post.setTitle(postDto.getTitle());
            this.postRepository.save(post);
            return postDto;
        }
        return null;
    }

    @Override
    public void deleteOnePostById(Long id) {
        this.postRepository.deleteById(id);
    }
}
