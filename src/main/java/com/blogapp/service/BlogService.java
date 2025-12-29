package com.blogapp.service;

import com.blogapp.model.Author;
import com.blogapp.model.Blog;
import com.blogapp.model.Comment;

import java.util.List;

public interface BlogService {
    // Blog operations
    Blog createBlog(Blog blog);

    Blog getBlogById(Long id);

    List<Blog> getAllBlogs();

    List<Blog> getBlogsByCategory(String category);

    List<Blog> getBlogsByAuthor(Long authorId);

    List<Blog> searchBlogsByTitle(String title);

    List<Blog> getBlogsOrderedByDate();

    List<Blog> getBlogsOrderedByLikes();

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);

    // Author operations
    Author createAuthor(Author author);

    Author getAuthorById(Long id);

    List<Author> getAllAuthors();

    Author updateAuthor(Long id, Author author);

    void deleteAuthor(Long id);

    // Comment operations
    Comment addComment(Long blogId, Comment comment);

    List<Comment> getCommentsByBlogId(Long blogId);

    void deleteComment(Long commentId);

    // Like operations
    void likeBlog(Long blogId, String userIdentifier);

    void unlikeBlog(Long blogId, String userIdentifier);

    Long getLikeCount(Long blogId);

    boolean hasUserLiked(Long blogId, String userIdentifier);
}
