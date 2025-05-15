package org.kbapps.tigrinya_blog.service;

import lombok.RequiredArgsConstructor;
import org.kbapps.tigrinya_blog.exception.ResourceNotFoundException;
import org.kbapps.tigrinya_blog.model.Comments;
import org.kbapps.tigrinya_blog.repository.CommentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsRepository;
    public Comments createComment(Comments comments) {
        return commentsRepository.save(comments);
    }
    public List<Comments> getComments() {
        return commentsRepository.findAll();
    }
    public Comments updateComment(Comments comment,Long id) {
        Comments com=commentsRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Comment with id: "+id+" not found"));
        com.setContent(comment.getContent());
        return commentsRepository.save(comment);
    }
    public String deleteComment(Long id){
        commentsRepository.findById(id)
                .ifPresentOrElse (commentsRepository::delete,(()-> {throw new ResourceNotFoundException("Comment with id: "+id+" not found");}));
        return "Comment with id: "+id+" Deleted";
    }
}
