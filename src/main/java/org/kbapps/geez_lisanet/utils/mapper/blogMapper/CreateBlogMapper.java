package org.kbapps.geez_lisanet.utils.mapper.blogMapper;

import org.kbapps.geez_lisanet.post.blogDto.CreateBlogDto;
import org.kbapps.geez_lisanet.post.BlogPost;
import org.kbapps.geez_lisanet.user.User;
import org.kbapps.geez_lisanet.user.UserService;
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
