package org.kbapps.geez_lisanet.post.blogDto;

import lombok.Data;

@Data
public class UpdateBlogDto {
    private String title;
    private String description;
    private String body;
    private String summary;

}
