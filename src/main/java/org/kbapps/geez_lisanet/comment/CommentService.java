package org.kbapps.geez_lisanet.comment;

import lombok.RequiredArgsConstructor;

import org.kbapps.geez_lisanet.comment.commentDto.CreateCommentDto;
import org.kbapps.geez_lisanet.comment.commentDto.GetCommentDto;
import org.kbapps.geez_lisanet.comment.commentDto.UpdateCommentDto;
import org.kbapps.geez_lisanet.exception.ResourceNotFoundException;
import org.kbapps.geez_lisanet.utils.mapper.commentMapper.CreateCommentMapper;
import org.kbapps.geez_lisanet.utils.mapper.commentMapper.GetCommentMapper;
import org.kbapps.geez_lisanet.post.BlogService;
import org.kbapps.geez_lisanet.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CreateCommentMapper createCommentMapper;
    private final GetCommentMapper getCommentMapper;
    private final UserService userService;
    private final BlogService blogService;

    public GetCommentDto createComment(CreateCommentDto createCommentDto) {
        Comment comment= createCommentMapper.toEntity(createCommentDto,userService,blogService);
        return getCommentMapper.toDto(commentRepository.save(comment));
    }

    public List<GetCommentDto> getCommentsByPostId(Long id) {
         return getCommentMapper.toDtoList(commentRepository.findCommentsByPostId(id));
    }
    public GetCommentDto updateComment(UpdateCommentDto updateCommentDto, Long id) {
        Comment comment=commentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Comment with id: "+id+" not found"));

         comment.setContent(updateCommentDto.getContent());
         return getCommentMapper.toDto( commentRepository.save(comment));
    }
    public void deleteComment(Long id){
       commentRepository.findById(id)
               .ifPresentOrElse(commentRepository::
                       delete, ()->{throw new ResourceNotFoundException("Comment with id: "+id+" not found");});


    }
}
