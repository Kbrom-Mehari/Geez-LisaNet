package org.kbapps.geez_lisanet.utils.mapper.commentMapper;

import org.kbapps.geez_lisanet.comment.commentDto.GetCommentDto;
import org.kbapps.geez_lisanet.comment.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetCommentMapper {
    @Mapping(source="author.id",target="authorId")
    @Mapping(source="post.id",target="postId")
    GetCommentDto toDto (Comment comment);
    List<GetCommentDto> toDtoList(List<Comment> comments);
}
