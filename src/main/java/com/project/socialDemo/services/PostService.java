package com.project.socialDemo.services;

import com.project.socialDemo.abstracts.IPostService;
import com.project.socialDemo.abstracts.IUserService;
import com.project.socialDemo.dto.PostDto;
import com.project.socialDemo.entities.Post;
import com.project.socialDemo.entities.User;
import com.project.socialDemo.repos.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final PostRepository postRepository;
    private final IUserService userService;

    @Override
    public List<PostDto> getAllPosts(Optional<Long> userId) {
        List <Post> posts;
        if(userId.isPresent()){
            posts = this.postRepository.findByUserId(userId.get());
        }else{
            posts = postRepository.findAll();
        }
        if (posts.size() > 0) {
            return posts.stream().map(p-> new PostDto(p)).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public PostDto getOnePostById(Long id) {
        Post post = this.postRepository.findById(id).orElse(null);
        if(post!=null){
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setText(post.getText());
            postDto.setUserName(post.getUser().getUserName());
            return postDto;
        }
        return null;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        User user = this.userService.getOneUserById(postDto.getUserId());
        if(user!=null){
            Post post = new Post(postDto);
            post.setUser(user);
            this.postRepository.save(post);
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
