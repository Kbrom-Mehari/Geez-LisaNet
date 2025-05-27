package org.kbapps.tigrinya_blog.service;

import lombok.RequiredArgsConstructor;

import org.kbapps.tigrinya_blog.dto.commentDto.CreateCommentDto;
import org.kbapps.tigrinya_blog.dto.commentDto.GetCommentDto;
import org.kbapps.tigrinya_blog.dto.commentDto.UpdateCommentDto;
import org.kbapps.tigrinya_blog.exception.ResourceNotFoundException;
import org.kbapps.tigrinya_blog.mapper.commentMapper.CreateCommentMapper;
import org.kbapps.tigrinya_blog.mapper.commentMapper.GetCommentMapper;
import org.kbapps.tigrinya_blog.model.Comment;
import org.kbapps.tigrinya_blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CreateCommentMapper createCommentMapper;
    private final GetCommentMapper getCommentMapper;
    private final UserService userService;
    private final BlogService blogService;

    public GetCommentDto createComment(CreateCommentDto createCommentDto) {
        Comment comment= createCommentMapper.toEntity(createCommentDto,userService,blogService);
        return getCommentMapper.toDto(commentRepository.save(comment));
    }

    public List<GetCommentDto> getCommentsByPostId(Long id) {
         return getCommentMapper.toDtoList(commentRepository.findCommentsByPostId(id));
    }
    public GetCommentDto updateComment(UpdateCommentDto updateCommentDto, Long id) {
        Comment comment=commentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Comment with id: "+id+" not found"));

         comment.setContent(updateCommentDto.getContent());
         return getCommentMapper.toDto( commentRepository.save(comment));
    }
    public Comment deleteComment(Long id){
       Comment comment= commentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Comment with id: "+id+" not found"));
                commentRepository.delete(comment);
         return comment;
    }
}
