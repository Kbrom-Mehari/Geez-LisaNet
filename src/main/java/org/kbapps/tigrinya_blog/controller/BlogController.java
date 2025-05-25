package org.kbapps.tigrinya_blog.controller;

import lombok.RequiredArgsConstructor;
import org.kbapps.tigrinya_blog.dto.blogDto.CreateBlogDto;
import org.kbapps.tigrinya_blog.dto.blogDto.GetBlogDto;
import org.kbapps.tigrinya_blog.dto.blogDto.UpdateBlogDto;
import org.kbapps.tigrinya_blog.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(("/blogs"))
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

@GetMapping
    public List<GetBlogDto> getAllBlogPosts(){
       return blogService.getBlogPosts();
}
@GetMapping("/{id}")
public GetBlogDto getBlogPostById(@PathVariable Long id){
    return blogService.getBlogPostById(id);
}
@PostMapping
    public GetBlogDto createBlogPost(@RequestBody CreateBlogDto createBlogDto){
    return blogService.createBlogPost(createBlogDto);

}
@PatchMapping("/{id}")
    public GetBlogDto updateBlogPost(@RequestBody UpdateBlogDto updateBlogDto, @PathVariable Long id){
      return blogService.updateBlogPost(updateBlogDto,id);
}
@DeleteMapping("/{id}")
    public String deleteBlogPost(@PathVariable Long id){
    blogService.deleteBlogPostById(id);
    return "Blog Post Deleted";
}
}
