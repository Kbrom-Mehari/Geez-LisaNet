package org.kbapps.geez_lisanet.post;

import lombok.RequiredArgsConstructor;
import org.kbapps.geez_lisanet.post.blogDto.CreateBlogDto;
import org.kbapps.geez_lisanet.post.blogDto.GetBlogDto;
import org.kbapps.geez_lisanet.post.blogDto.UpdateBlogDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(("/blogs"))
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;
@GetMapping
public ResponseEntity<List<GetBlogDto>> getAllBlogPosts(){
     List<GetBlogDto> blogs= blogService.getBlogPosts();
     return ResponseEntity.ok(blogs);
}
@GetMapping("/{id}")
public ResponseEntity<GetBlogDto> getBlogPostById(@PathVariable Long id){
    GetBlogDto blog= blogService.getBlogPostById(id);
    if(blog==null){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(blog);
}
@PostMapping
    public ResponseEntity<GetBlogDto> createBlogPost(@RequestBody CreateBlogDto createBlogDto){
    GetBlogDto blog= blogService.createBlogPost(createBlogDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(blog);  //status: 201 created
}
@PatchMapping("/{id}")
    public ResponseEntity<GetBlogDto> updateBlogPost(@RequestBody UpdateBlogDto updateBlogDto, @PathVariable Long id){
      GetBlogDto updatedBlog= blogService.updateBlogPost(updateBlogDto,id);
      if(updatedBlog==null){
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(updatedBlog);
}
@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id){
    blogService.deleteBlogPostById(id);
    return ResponseEntity.noContent().build();
}
}
