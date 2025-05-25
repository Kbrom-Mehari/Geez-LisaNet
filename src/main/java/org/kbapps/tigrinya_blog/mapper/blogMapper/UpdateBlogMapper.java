package org.kbapps.tigrinya_blog.mapper.blogMapper;

import org.kbapps.tigrinya_blog.dto.blogDto.UpdateBlogDto;
import org.kbapps.tigrinya_blog.model.BlogPost;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateBlogMapper {
    BlogPost toEntity(UpdateBlogDto updateBlogDto);
}
