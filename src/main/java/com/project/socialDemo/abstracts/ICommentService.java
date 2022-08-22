package com.project.socialDemo.abstracts;

import com.project.socialDemo.dto.CommentDto;
import com.project.socialDemo.dto.PostDto;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    List<CommentDto> getAllComments(Optional<Long> userId,Optional<Long> postId);
    CommentDto getOneCommentById(Long id);
    CommentDto createComment(CommentDto commentDto);
    CommentDto updateOneComment(CommentDto commentDto);
    void deleteOneCommentById(Long id);
}
