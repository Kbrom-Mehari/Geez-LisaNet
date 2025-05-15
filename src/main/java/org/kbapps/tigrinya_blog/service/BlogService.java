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
    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogRepository.save(blogPost);
    }

    public List<BlogPost> getBlogPosts() {
        return blogRepository.findAll();
    }
    public BlogPost getBlogPostById(Long id) {
         return blogRepository.findById(id)
                 .orElseThrow(()->new ResourceNotFoundException("Blog with Id: "+id+" Not Found"));
    }
    public String deleteBlogPostById(Long id) {
        blogRepository.findById(id)
                .ifPresentOrElse(blogRepository::delete,()-> {
                    throw new ResourceNotFoundException("Blog with Id: "+id+" Not Found");});
        return "Blog with Id: "+id+" Deleted";
    }
    public BlogPost updateBlogPost(BlogPost blogPost, Long id) {
          BlogPost blog=blogRepository.findById(id)
                  .orElseThrow(()->new ResourceNotFoundException("Blog with Id: "+id+" Not Found"));
          blog.setTitle(blogPost.getTitle());
          blog.setBody(blogPost.getBody());
          blog.setSummary(blogPost.getSummary());
          return blogRepository.save(blog);
    }

}
