package com.blogapp.repository;

import com.blogapp.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByBlogIdAndUserIdentifier(Long blogId, String userIdentifier);

    Long countByBlogId(Long blogId);

    boolean existsByBlogIdAndUserIdentifier(Long blogId, String userIdentifier);
}
