-- BlogApp Database Schema
-- This file is optional - Hibernate will auto-create tables if you use spring.jpa.hibernate.ddl-auto=update
-- Use this if you want to manually create the schema

-- Drop tables if they exist (for clean setup)
DROP TABLE IF EXISTS likes CASCADE;
DROP TABLE IF EXISTS comments CASCADE;
DROP TABLE IF EXISTS blogs CASCADE;
DROP TABLE IF EXISTS authors CASCADE;

-- Authors Table
CREATE TABLE authors (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    bio VARCHAR(500)
);

-- Blogs Table
CREATE TABLE blogs (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    category VARCHAR(255),
    like_count INTEGER DEFAULT 0,
    author_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
);

-- Comments Table
CREATE TABLE comments (
    id BIGSERIAL PRIMARY KEY,
    content TEXT NOT NULL,
    commenter_name VARCHAR(255) NOT NULL,
    commenter_email VARCHAR(255) NOT NULL,
    blog_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_blog_comment FOREIGN KEY (blog_id) REFERENCES blogs(id) ON DELETE CASCADE
);

-- Likes Table
CREATE TABLE likes (
    id BIGSERIAL PRIMARY KEY,
    blog_id BIGINT NOT NULL,
    user_identifier VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_blog_like FOREIGN KEY (blog_id) REFERENCES blogs(id) ON DELETE CASCADE,
    CONSTRAINT unique_blog_user UNIQUE (blog_id, user_identifier)
);

-- Create indexes for better query performance
CREATE INDEX idx_blogs_author_id ON blogs(author_id);
CREATE INDEX idx_blogs_category ON blogs(category);
CREATE INDEX idx_blogs_created_at ON blogs(created_at DESC);
CREATE INDEX idx_blogs_like_count ON blogs(like_count DESC);
CREATE INDEX idx_comments_blog_id ON comments(blog_id);
CREATE INDEX idx_likes_blog_id ON likes(blog_id);
