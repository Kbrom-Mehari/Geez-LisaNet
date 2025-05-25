package org.kbapps.tigrinya_blog.controller;

import lombok.RequiredArgsConstructor;
import org.kbapps.tigrinya_blog.dto.commentDto.CreateCommentDto;
import org.kbapps.tigrinya_blog.dto.commentDto.GetCommentDto;
import org.kbapps.tigrinya_blog.dto.commentDto.UpdateCommentDto;
import org.kbapps.tigrinya_blog.model.Comment;
import org.kbapps.tigrinya_blog.service.CommentService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("comments")
public class CommentController {
    private final CommentService commentService;
    @GetMapping("/{id}")
    public List<GetCommentDto> getCommentsByPostId(@PathVariable Long id) {         //using DTO
        return commentService.getCommentsByPostId(id);
    }
    @PostMapping
    public GetCommentDto createComment(@RequestBody CreateCommentDto createCommentDto) {   //using DTO
        return commentService.createComment(createCommentDto);
    }
    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable Long id) {                //DTO not needed
        commentService.deleteComment(id);
        return "Comment deleted";
    }
    @PutMapping ("/{id}")                                            //using DTO
    public GetCommentDto updateComment(@RequestBody UpdateCommentDto updateCommentDto, @PathVariable Long id) {
        return commentService.updateComment(updateCommentDto, id);
    }

}
