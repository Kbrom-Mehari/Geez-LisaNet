package org.kbapps.geez_lisanet.comment.commentDto;

import lombok.Data;

@Data
public class CreateCommentDto {
    private Long authorId;
    private String content;
    private Long postId;
}
