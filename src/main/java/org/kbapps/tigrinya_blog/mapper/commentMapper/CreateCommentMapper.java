package org.kbapps.tigrinya_blog.mapper.commentMapper;

import org.kbapps.tigrinya_blog.dto.commentDto.CreateCommentDto;
import org.kbapps.tigrinya_blog.model.BlogPost;
import org.kbapps.tigrinya_blog.model.Comment;
import org.kbapps.tigrinya_blog.model.User;
import org.kbapps.tigrinya_blog.service.BlogService;
import org.kbapps.tigrinya_blog.service.UserService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateCommentMapper {
    @Mapping(source = "authorId",target="author")
    @Mapping(source="postId",target="post")
    Comment toEntity(CreateCommentDto createCommentDto,
                     @Context UserService userService
                     ,@Context BlogService blogService);

    default User map(Long authorId, @Context UserService userService) {
        return userService.findUserById(authorId);
    }
    default BlogPost map(Long postId, @Context BlogService blogService) {
        return blogService.findBlogById(postId);
    }
}
