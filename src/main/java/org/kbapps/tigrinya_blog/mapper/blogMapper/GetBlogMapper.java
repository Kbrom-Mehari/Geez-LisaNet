package org.kbapps.tigrinya_blog.mapper.blogMapper;

import org.kbapps.tigrinya_blog.dto.blogDto.GetBlogDto;
import org.kbapps.tigrinya_blog.model.BlogPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetBlogMapper {
    @Mapping(source="author.id",target="authorId")
    GetBlogDto toDto(BlogPost blogPost);
    List<GetBlogDto> toDtoList(List<BlogPost> blogPosts);
}
