package com.project.socialDemo.services;

import com.project.socialDemo.abstracts.ICommentService;

import com.project.socialDemo.abstracts.IPostService;
import com.project.socialDemo.abstracts.IUserService;
import com.project.socialDemo.dto.CommentDto;

import com.project.socialDemo.dto.PostDto;
import com.project.socialDemo.entities.Comment;
import com.project.socialDemo.entities.Post;
import com.project.socialDemo.entities.User;
import com.project.socialDemo.repos.CommentRepository;
import com.project.socialDemo.repos.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final IUserService userService;
    private final IPostService postService;

    @Override
    public List<CommentDto> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        List<Comment> comments;
        if(userId.isPresent() && postId.isPresent()){
            comments = commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
        }else if(userId.isPresent()){
            comments = commentRepository.findByUserId(userId.get());
        }else if(postId.isPresent()){
            comments = commentRepository.findByPostId(postId.get());
        }else{
            comments = commentRepository.findAll();
        }
        return comments.stream().map(c->new CommentDto(c)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getOneCommentById(Long id) {
        Comment comment = this.commentRepository.findById(id).orElse(null);
        if (comment != null) {
            CommentDto commentDto = new CommentDto(comment);
            return commentDto;
        }
        return null;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        User user = this.userService.getOneUserById(commentDto.getUserId());
        PostDto postDto = this.postService.getOnePostById(commentDto.getPostId());
        if (user != null && postDto != null) {
            Post post = this.postRepository.findById(postDto.getId()).orElse(null);
            Comment comment = new Comment();
            comment.setUser(user);
            comment.setPost(post);
            comment.setText(commentDto.getText());
            this.commentRepository.save(comment);
            commentDto.setId(comment.getId());
            return commentDto;
        }
        return null;
    }

    @Override
    public CommentDto updateOneComment(CommentDto commentDto) {
        Comment comment = this.commentRepository.findById(commentDto.getId()).orElse(null);
        if(comment!=null){
            comment.setText(commentDto.getText());
            this.commentRepository.save(comment);
            return commentDto;
        }
        return null;
    }

    @Override
    public void deleteOneCommentById(Long id) {
        this.commentRepository.deleteById(id);
    }
}
