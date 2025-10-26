package org.kbapps.geez_lisanet.utils.mapper.blogMapper;

import org.kbapps.geez_lisanet.post.blogDto.GetBlogDto;
import org.kbapps.geez_lisanet.post.BlogPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetBlogMapper {
    @Mapping(source="author.id",target="authorId")
    GetBlogDto toDto(BlogPost blogPost);
    List<GetBlogDto> toDtoList(List<BlogPost> blogPosts);
}
