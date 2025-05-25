package org.kbapps.tigrinya_blog.mapper.blogMapper;

import org.kbapps.tigrinya_blog.dto.blogDto.CreateBlogDto;
import org.kbapps.tigrinya_blog.model.BlogPost;
import org.kbapps.tigrinya_blog.model.User;
import org.kbapps.tigrinya_blog.service.UserService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateBlogMapper {
    @Mapping(source="authorId",target="author")
    BlogPost toEntity(CreateBlogDto createBlogDto,@Context UserService userService);

    default User map(Long authorId, @Context UserService userService) {
        return userService.findUserById(authorId);
    }
}
