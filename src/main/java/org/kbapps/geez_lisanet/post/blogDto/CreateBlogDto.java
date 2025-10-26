package org.kbapps.geez_lisanet.post.blogDto;

import lombok.Data;

@Data
public class CreateBlogDto {
    private String title;
    private String description;
    private String body;
    private String summary;
    private Long authorId;
}
