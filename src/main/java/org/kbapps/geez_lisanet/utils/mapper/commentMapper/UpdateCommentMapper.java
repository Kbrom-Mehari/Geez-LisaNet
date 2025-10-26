package org.kbapps.geez_lisanet.utils.mapper.commentMapper;

import org.kbapps.geez_lisanet.comment.commentDto.UpdateCommentDto;
import org.kbapps.geez_lisanet.comment.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateCommentMapper {
    Comment toEntity(UpdateCommentDto updateCommentDto);
}
