package org.kbapps.geez_lisanet.utils.mapper.blogMapper;

import org.kbapps.geez_lisanet.post.blogDto.UpdateBlogDto;
import org.kbapps.geez_lisanet.post.BlogPost;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateBlogMapper {
    BlogPost toEntity(UpdateBlogDto updateBlogDto);
}
