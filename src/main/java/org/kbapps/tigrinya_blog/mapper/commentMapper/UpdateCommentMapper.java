package org.kbapps.tigrinya_blog.mapper.commentMapper;

import org.kbapps.tigrinya_blog.dto.commentDto.UpdateCommentDto;
import org.kbapps.tigrinya_blog.model.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateCommentMapper {
    Comment toEntity(UpdateCommentDto updateCommentDto);
}
