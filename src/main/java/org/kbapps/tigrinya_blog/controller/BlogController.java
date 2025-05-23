package org.kbapps.tigrinya_blog.controller;

import lombok.RequiredArgsConstructor;
import org.kbapps.tigrinya_blog.model.BlogPost;
import org.kbapps.tigrinya_blog.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(("/blogs"))
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

@GetMapping
    public List<BlogPost> getAllBlogPosts(){
       return blogService.getBlogPosts();
}
@GetMapping("/{id}")
public BlogPost getBlogPostById(@PathVariable Long id){
    return blogService.getBlogPostById(id);
}
@PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost){
    return blogService.createBlogPost(blogPost);

}
@PatchMapping("/{id}")
    public BlogPost updateBlogPost(@RequestBody BlogPost blogPost, @PathVariable Long id){
      return blogService.updateBlogPost(blogPost,id);
}
@DeleteMapping("/{id}")
    public String deleteBlogPost(@PathVariable Long id){
    blogService.deleteBlogPostById(id);
    return "Blog Post Deleted";
}
}
