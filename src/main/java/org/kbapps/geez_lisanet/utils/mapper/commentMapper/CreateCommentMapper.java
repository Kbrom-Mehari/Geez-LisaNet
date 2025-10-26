package org.kbapps.geez_lisanet.utils.mapper.commentMapper;

import org.kbapps.geez_lisanet.comment.commentDto.CreateCommentDto;
import org.kbapps.geez_lisanet.post.BlogPost;
import org.kbapps.geez_lisanet.comment.Comment;
import org.kbapps.geez_lisanet.user.User;
import org.kbapps.geez_lisanet.post.BlogService;
import org.kbapps.geez_lisanet.user.UserService;
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
