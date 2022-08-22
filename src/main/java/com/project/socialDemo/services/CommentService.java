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

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final IUserService userService;
    private final IPostService postService;

    @Override
    public List<CommentDto> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        List<Comment> comments = commentRepository.findAll();
        List<CommentDto> commentsDtos = new ArrayList<>();
        CommentDto commentDto;
        for (Comment comment : comments) {
            commentDto = new CommentDto();
            commentDto.setId(comment.getId());
            commentDto.setText(comment.getText());
            commentDto.setUser_id(comment.getUser().getId());
            commentDto.setPost_id(comment.getPost().getId());
            commentsDtos.add(commentDto);
        }

        return commentsDtos;
    }

    @Override
    public CommentDto getOneCommentById(Long id) {
        return null;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        User user = this.userService.getOneUserById(commentDto.getUser_id());
        PostDto postDto = this.postService.getOnePostById(commentDto.getPost_id());
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
        return null;
    }

    @Override
    public void deleteOneCommentById(Long id) {

    }
}