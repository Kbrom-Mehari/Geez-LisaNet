package org.kbapps.tigrinya_blog.dto.blogDto;

import lombok.Data;

@Data
public class CreateBlogDto {
    private String title;
    private String description;
    private String body;
    private String summary;
    private Long authorId;
}
