package com.blogapp.repository;

import com.blogapp.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByCategory(String category);

    List<Blog> findByAuthorId(Long authorId);

    List<Blog> findByTitleContainingIgnoreCase(String title);

    List<Blog> findAllByOrderByCreatedAtDesc();

    List<Blog> findAllByOrderByLikeCountDesc();
}
