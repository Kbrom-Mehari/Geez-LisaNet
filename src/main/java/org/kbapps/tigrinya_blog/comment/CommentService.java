package org.kbapps.tigrinya_blog.comment;

import lombok.RequiredArgsConstructor;

import org.kbapps.tigrinya_blog.comment.commentDto.CreateCommentDto;
import org.kbapps.tigrinya_blog.comment.commentDto.GetCommentDto;
import org.kbapps.tigrinya_blog.comment.commentDto.UpdateCommentDto;
import org.kbapps.tigrinya_blog.exception.ResourceNotFoundException;
import org.kbapps.tigrinya_blog.mapper.commentMapper.CreateCommentMapper;
import org.kbapps.tigrinya_blog.mapper.commentMapper.GetCommentMapper;
import org.kbapps.tigrinya_blog.post.BlogService;
import org.kbapps.tigrinya_blog.user.UserService;
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
