package org.kbapps.tigrinya_blog.dto.blogDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetBlogDto {
    private String title;
    private String summary;
    private String body;
    private String description;
    private Long authorId;
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
