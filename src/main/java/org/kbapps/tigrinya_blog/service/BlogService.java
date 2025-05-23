package org.kbapps.tigrinya_blog.service;

import lombok.RequiredArgsConstructor;
import org.kbapps.tigrinya_blog.exception.ResourceNotFoundException;
import org.kbapps.tigrinya_blog.model.BlogPost;
import org.kbapps.tigrinya_blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogPost createBlogPost(BlogPost blogPost) {     // using DTO
        return  blogRepository.save(blogPost);

    }

    public List<BlogPost> getBlogPosts() {
        return blogRepository.findAll();
    }

    public BlogPost getBlogPostById(Long id) {
         BlogPost blog= blogRepository.findById(id)
                 .orElseThrow(()->new ResourceNotFoundException("Blog with Id: "+id+" Not Found"));
         return blog;
    }
    public void deleteBlogPostById(Long id) {
        blogRepository.findById(id)
                .ifPresentOrElse(blogRepository::delete,()-> {
                    throw new ResourceNotFoundException("Blog with Id: "+id+" Not Found");});

    }

    public BlogPost updateBlogPost(BlogPost blogPost, Long id) {
        BlogPost blog=blogRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Blog with Id: "+id+" Not Found"));
        if(blogPost.getTitle()!=null){
            blog.setTitle(blogPost.getTitle());
        }
        if(blogPost.getDescription()!=null){
            blog.setDescription(blogPost.getDescription());
        }
        if(blogPost.getBody()!=null){
            blog.setBody(blogPost.getBody());
        }
        if(blogPost.getSummary()!=null){
            blog.setSummary(blogPost.getSummary());
        }
        return blogRepository.save(blog);
    }

}
