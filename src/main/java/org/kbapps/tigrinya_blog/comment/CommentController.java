package org.kbapps.tigrinya_blog.comment;

import lombok.RequiredArgsConstructor;
import org.kbapps.tigrinya_blog.comment.commentDto.CreateCommentDto;
import org.kbapps.tigrinya_blog.comment.commentDto.GetCommentDto;
import org.kbapps.tigrinya_blog.comment.commentDto.UpdateCommentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("comments")
public class CommentController {
    private final CommentService commentService;
    @GetMapping("/{id}")
    public ResponseEntity<List<GetCommentDto>> getCommentsByPostId(@PathVariable Long id) {         //using DTO
        List<GetCommentDto> comments=commentService.getCommentsByPostId(id);
        if(comments.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comments);
    }
    @PostMapping
    public ResponseEntity<GetCommentDto> createComment(@RequestBody CreateCommentDto createCommentDto) {   //using DTO
        GetCommentDto comment=commentService.createComment(createCommentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping ("/{id}")                                            //using DTO
    public GetCommentDto updateComment(@RequestBody UpdateCommentDto updateCommentDto, @PathVariable Long id) {
        return commentService.updateComment(updateCommentDto, id);
    }

}
