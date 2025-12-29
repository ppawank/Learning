package com.blogapp.controller;

import com.blogapp.model.Blog;
import com.blogapp.service.BlogService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/blogs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BlogController {

    private final BlogService blogService;

    @PostMapping
    public ResponseEntity<Blog> createBlog(@Valid @RequestBody Blog blog) {
        Blog createdBlog = blogService.createBlog(blog);
        return new ResponseEntity<>(createdBlog, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs(
            @RequestParam(required = false) String sortBy) {
        List<Blog> blogs;

        if ("date".equalsIgnoreCase(sortBy)) {
            blogs = blogService.getBlogsOrderedByDate();
        } else if ("likes".equalsIgnoreCase(sortBy)) {
            blogs = blogService.getBlogsOrderedByLikes();
        } else {
            blogs = blogService.getAllBlogs();
        }

        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        Blog blog = blogService.getBlogById(id);
        return ResponseEntity.ok(blog);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Blog>> getBlogsByCategory(@PathVariable String category) {
        List<Blog> blogs = blogService.getBlogsByCategory(category);
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Blog>> getBlogsByAuthor(@PathVariable Long authorId) {
        List<Blog> blogs = blogService.getBlogsByAuthor(authorId);
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchBlogs(@RequestParam String title) {
        List<Blog> blogs = blogService.searchBlogsByTitle(title);
        return ResponseEntity.ok(blogs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @Valid @RequestBody Blog blog) {
        Blog updatedBlog = blogService.updateBlog(id, blog);
        return ResponseEntity.ok(updatedBlog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }

    // Like/Unlike endpoints
    @PostMapping("/{id}/like")
    public ResponseEntity<Map<String, Object>> likeBlog(
            @PathVariable Long id,
            @RequestParam String userIdentifier) {
        blogService.likeBlog(id, userIdentifier);
        Long likeCount = blogService.getLikeCount(id);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Blog liked successfully");
        response.put("likeCount", likeCount);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}/like")
    public ResponseEntity<Map<String, Object>> unlikeBlog(
            @PathVariable Long id,
            @RequestParam String userIdentifier) {
        blogService.unlikeBlog(id, userIdentifier);
        Long likeCount = blogService.getLikeCount(id);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Blog unliked successfully");
        response.put("likeCount", likeCount);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/like-status")
    public ResponseEntity<Map<String, Object>> getLikeStatus(
            @PathVariable Long id,
            @RequestParam String userIdentifier) {
        boolean hasLiked = blogService.hasUserLiked(id, userIdentifier);
        Long likeCount = blogService.getLikeCount(id);

        Map<String, Object> response = new HashMap<>();
        response.put("hasLiked", hasLiked);
        response.put("likeCount", likeCount);

        return ResponseEntity.ok(response);
    }
}
