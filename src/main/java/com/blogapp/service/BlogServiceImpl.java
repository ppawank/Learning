package com.blogapp.service;

import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.model.Author;
import com.blogapp.model.Blog;
import com.blogapp.model.Comment;
import com.blogapp.model.Like;
import com.blogapp.repository.AuthorRepository;
import com.blogapp.repository.BlogRepository;
import com.blogapp.repository.CommentRepository;
import com.blogapp.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final AuthorRepository authorRepository;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;

    // ==================== Blog Operations ====================

    @Override
    public Blog createBlog(Blog blog) {
        // Verify author exists
        if (blog.getAuthor() != null && blog.getAuthor().getId() != null) {
            Author author = authorRepository.findById(blog.getAuthor().getId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Author not found with id: " + blog.getAuthor().getId()));
            blog.setAuthor(author);
        }
        return blogRepository.save(blog);
    }

    @Override
    @Transactional(readOnly = true)
    public Blog getBlogById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Blog> getBlogsByCategory(String category) {
        return blogRepository.findByCategory(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Blog> getBlogsByAuthor(Long authorId) {
        return blogRepository.findByAuthorId(authorId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Blog> searchBlogsByTitle(String title) {
        return blogRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Blog> getBlogsOrderedByDate() {
        return blogRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Blog> getBlogsOrderedByLikes() {
        return blogRepository.findAllByOrderByLikeCountDesc();
    }

    @Override
    public Blog updateBlog(Long id, Blog blogDetails) {
        Blog blog = getBlogById(id);

        blog.setTitle(blogDetails.getTitle());
        blog.setContent(blogDetails.getContent());
        blog.setCategory(blogDetails.getCategory());

        return blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Long id) {
        Blog blog = getBlogById(id);
        blogRepository.delete(blog);
    }

    // ==================== Author Operations ====================

    @Override
    public Author createAuthor(Author author) {
        if (authorRepository.existsByEmail(author.getEmail())) {
            throw new IllegalArgumentException("Author with email " + author.getEmail() + " already exists");
        }
        return authorRepository.save(author);
    }

    @Override
    @Transactional(readOnly = true)
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Long id, Author authorDetails) {
        Author author = getAuthorById(id);

        author.setName(authorDetails.getName());
        author.setBio(authorDetails.getBio());

        // Only update email if it's different and not already taken
        if (!author.getEmail().equals(authorDetails.getEmail())) {
            if (authorRepository.existsByEmail(authorDetails.getEmail())) {
                throw new IllegalArgumentException("Email " + authorDetails.getEmail() + " is already taken");
            }
            author.setEmail(authorDetails.getEmail());
        }

        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = getAuthorById(id);
        authorRepository.delete(author);
    }

    // ==================== Comment Operations ====================

    @Override
    public Comment addComment(Long blogId, Comment comment) {
        Blog blog = getBlogById(blogId);
        comment.setBlog(blog);
        return commentRepository.save(comment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> getCommentsByBlogId(Long blogId) {
        // Verify blog exists
        getBlogById(blogId);
        return commentRepository.findByBlogIdOrderByCreatedAtDesc(blogId);
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + commentId));
        commentRepository.delete(comment);
    }

    // ==================== Like Operations ====================

    @Override
    public void likeBlog(Long blogId, String userIdentifier) {
        Blog blog = getBlogById(blogId);

        // Check if user already liked
        if (likeRepository.existsByBlogIdAndUserIdentifier(blogId, userIdentifier)) {
            throw new IllegalArgumentException("User has already liked this blog");
        }

        Like like = new Like();
        like.setBlog(blog);
        like.setUserIdentifier(userIdentifier);
        likeRepository.save(like);

        // Update like count
        blog.setLikeCount(blog.getLikeCount() + 1);
        blogRepository.save(blog);
    }

    @Override
    public void unlikeBlog(Long blogId, String userIdentifier) {
        Blog blog = getBlogById(blogId);

        Like like = likeRepository.findByBlogIdAndUserIdentifier(blogId, userIdentifier)
                .orElseThrow(() -> new ResourceNotFoundException("Like not found for this user and blog"));

        likeRepository.delete(like);

        // Update like count
        blog.setLikeCount(Math.max(0, blog.getLikeCount() - 1));
        blogRepository.save(blog);
    }

    @Override
    @Transactional(readOnly = true)
    public Long getLikeCount(Long blogId) {
        return likeRepository.countByBlogId(blogId);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean hasUserLiked(Long blogId, String userIdentifier) {
        return likeRepository.existsByBlogIdAndUserIdentifier(blogId, userIdentifier);
    }
}
