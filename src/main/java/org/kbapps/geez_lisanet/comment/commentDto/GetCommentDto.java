package org.kbapps.geez_lisanet.comment.commentDto;

import lombok.Data;

@Data
public class GetCommentDto {
    private Long commentId;
    private String content;
    private Long authorId;
    private Long postId;
}
