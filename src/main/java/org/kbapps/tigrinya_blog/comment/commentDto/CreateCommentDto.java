package org.kbapps.tigrinya_blog.comment.commentDto;

import lombok.Data;

@Data
public class CreateCommentDto {
    private Long authorId;
    private String content;
    private Long postId;
}
