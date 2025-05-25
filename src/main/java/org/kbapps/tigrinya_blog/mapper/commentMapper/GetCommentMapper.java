package org.kbapps.tigrinya_blog.mapper.commentMapper;

import org.kbapps.tigrinya_blog.dto.commentDto.GetCommentDto;
import org.kbapps.tigrinya_blog.model.Comment;
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
