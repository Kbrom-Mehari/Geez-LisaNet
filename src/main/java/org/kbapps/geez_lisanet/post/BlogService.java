package org.kbapps.geez_lisanet.post;

import lombok.RequiredArgsConstructor;
import org.kbapps.geez_lisanet.post.blogDto.CreateBlogDto;
import org.kbapps.geez_lisanet.post.blogDto.GetBlogDto;
import org.kbapps.geez_lisanet.post.blogDto.UpdateBlogDto;
import org.kbapps.geez_lisanet.exception.ResourceNotFoundException;
import org.kbapps.geez_lisanet.utils.mapper.blogMapper.CreateBlogMapper;
import org.kbapps.geez_lisanet.utils.mapper.blogMapper.GetBlogMapper;
import org.kbapps.geez_lisanet.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final GetBlogMapper getBlogMapper;
    private final CreateBlogMapper createBlogMapper;
    private final UserService userService;

    public GetBlogDto createBlogPost(CreateBlogDto createBlogDto) { // using DTO
        BlogPost blog=createBlogMapper.toEntity(createBlogDto,userService);
        return getBlogMapper.toDto(blogRepository.save(blog));
    }

    public List<GetBlogDto> getBlogPosts() {
        return getBlogMapper.toDtoList(blogRepository.findAll());
    }

    public GetBlogDto getBlogPostById(Long id) {
         BlogPost blog= blogRepository.findById(id)
                 .orElseThrow(()->new ResourceNotFoundException("Blog with Id: "+id+" Not Found"));
         return getBlogMapper.toDto(blog);
    }
    public void deleteBlogPostById(Long id) {
      blogRepository.findById(id).ifPresentOrElse(blogRepository::
                                     delete,()->{throw new ResourceNotFoundException("Blog with Id: "+id+" Not Found");});
    }

    public GetBlogDto updateBlogPost(UpdateBlogDto updateBlogDto, Long id) {
        BlogPost blog=blogRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Blog with Id: "+id+" Not Found"));
        if(updateBlogDto.getTitle()!=null){
            blog.setTitle(updateBlogDto.getTitle());
        }
        if(updateBlogDto.getDescription()!=null){
            blog.setDescription(updateBlogDto.getDescription());
        }
        if(updateBlogDto.getBody()!=null){
            blog.setBody(updateBlogDto.getBody());
        }
        if(updateBlogDto.getSummary()!=null){
            blog.setSummary(updateBlogDto.getSummary());
        }
        return getBlogMapper.toDto(blogRepository.save(blog));
    }

    public BlogPost findBlogById(Long id) {    //for Mappers only
        return blogRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Blog with Id: "+id+" Not Found"));
    }

}
