package com.blogapp.controller;

import com.blogapp.model.Comment;
import com.blogapp.service.BlogService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs/{blogId}/comments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CommentController {

    private final BlogService blogService;

    @PostMapping
    public ResponseEntity<Comment> addComment(
            @PathVariable Long blogId,
            @Valid @RequestBody Comment comment) {
        Comment createdComment = blogService.addComment(blogId, comment);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getCommentsByBlogId(@PathVariable Long blogId) {
        List<Comment> comments = blogService.getCommentsByBlogId(blogId);
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        blogService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
