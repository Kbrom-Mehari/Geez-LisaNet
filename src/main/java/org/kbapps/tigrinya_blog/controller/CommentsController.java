package org.kbapps.tigrinya_blog.controller;

import lombok.RequiredArgsConstructor;
import org.kbapps.tigrinya_blog.model.Comments;
import org.kbapps.tigrinya_blog.service.CommentsService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("comments")
public class CommentsController {
    private final CommentsService commentsService;
    @GetMapping
    public List<Comments> getComments() {
        return commentsService.getComments();
    }
    @PostMapping
    public Comments createComment(@RequestBody Comments comment) {
        return commentsService.createComment(comment);
    }
    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable Long id) {
        commentsService.deleteComment(id);
        return "Comment deleted";
    }
    @PutMapping ("/{id}")
    public String updateComment(@RequestBody Comments comment,@PathVariable Long id) {
        commentsService.updateComment(comment, id);
        return "Comment updated";
    }

}
