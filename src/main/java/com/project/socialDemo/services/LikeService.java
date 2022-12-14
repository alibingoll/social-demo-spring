package com.project.socialDemo.services;

import com.project.socialDemo.abstracts.ILikeService;

import com.project.socialDemo.dto.CommentDto;
import com.project.socialDemo.dto.LikeDto;

import com.project.socialDemo.entities.Comment;
import com.project.socialDemo.entities.Like;
import com.project.socialDemo.entities.Post;
import com.project.socialDemo.entities.User;
import com.project.socialDemo.repos.LikeRepository;
import com.project.socialDemo.repos.PostRepository;
import com.project.socialDemo.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LikeService implements ILikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public List<LikeDto> getAllLikes(Optional<Long> userId, Optional<Long> postId) {
        List<Like> likes;
        if(userId.isPresent() && postId.isPresent()){
            likes = this.likeRepository.findByUserIdAndPostId(userId.get(),postId.get());
        }else if(userId.isPresent()){
            likes = this.likeRepository.findByUserId(userId.get());
        }else if(postId.isPresent()){
            likes = this.likeRepository.findByPostId(postId.get());
        }else{
            likes = this.likeRepository.findAll();
        }
        if(likes.size() != 0){
            return likes.stream().map(like->new LikeDto(like)).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public LikeDto getOneLikeById(Long id) {
        Like like = this.likeRepository.findById(id).orElse(null);
        if(like!=null){
            LikeDto likeDto = new LikeDto(like);
            return likeDto;
        }
        return null;
    }

    @Override
    public LikeDto createLike(LikeDto likeDto) {
        User user = this.userRepository.findById(likeDto.getUserId()).orElse(null);
        Post post = this.postRepository.findById(likeDto.getPostId()).orElse(null);
        if(user!=null && post !=null){
            Like like=new Like();
            like.setUser(user);
            like.setPost(post);
            this.likeRepository.save(like);
            return likeDto;
        }

        return null;
    }

    @Override
    public void deleteOneLikeById(Long id) {
        this.likeRepository.deleteById(id);
    }
}
