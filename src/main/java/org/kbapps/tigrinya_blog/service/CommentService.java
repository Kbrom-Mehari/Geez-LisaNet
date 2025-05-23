package org.kbapps.tigrinya_blog.service;

import lombok.RequiredArgsConstructor;

import org.kbapps.tigrinya_blog.exception.ResourceNotFoundException;
import org.kbapps.tigrinya_blog.model.Comment;
import org.kbapps.tigrinya_blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment createComment(Comment comment) {

        return commentRepository.save(comment);

    }

    public List<Comment> getCommentsByPostId(Long id) {
         return commentRepository.findCommentsByPostId(id);
    }
    public Comment updateComment(Comment comment, Long id) {
        Comment com=commentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Comment with id: "+id+" not found"));

         com.setContent(comment.getContent());
         return commentRepository.save(com);
    }
    public void deleteComment(Long id){
        commentRepository.findById(id)
                .ifPresentOrElse (commentRepository::delete,(()-> {throw new ResourceNotFoundException("Comment with id: "+id+" not found");}));

    }
}
