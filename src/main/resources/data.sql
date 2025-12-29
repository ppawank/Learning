-- Sample Authors
INSERT INTO authors (name, email, bio) VALUES 
('John Doe', 'john.doe@example.com', 'Tech enthusiast and software developer'),
('Jane Smith', 'jane.smith@example.com', 'Writer and blogger passionate about technology'),
('Mike Johnson', 'mike.johnson@example.com', 'Full-stack developer and open-source contributor');

-- Sample Blogs
INSERT INTO blogs (title, content, author_id, category, like_count, created_at, updated_at) VALUES 
('Getting Started with Spring Boot', 'Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications...', 1, 'Technology', 15, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Understanding REST APIs', 'REST (Representational State Transfer) is an architectural style for designing networked applications...', 2, 'Technology', 23, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('PostgreSQL Best Practices', 'PostgreSQL is a powerful, open source object-relational database system...', 3, 'Database', 18, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Java 17 New Features', 'Java 17 is a Long-Term Support (LTS) release with many exciting features...', 1, 'Programming', 31, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample Comments
INSERT INTO comments (content, commenter_name, commenter_email, blog_id, created_at) VALUES 
('Great article! Very helpful for beginners.', 'Alice Brown', 'alice@example.com', 1, CURRENT_TIMESTAMP),
('Thanks for sharing this information.', 'Bob Wilson', 'bob@example.com', 1, CURRENT_TIMESTAMP),
('Well explained! Looking forward to more posts.', 'Carol Davis', 'carol@example.com', 2, CURRENT_TIMESTAMP);

-- Sample Likes
INSERT INTO likes (blog_id, user_identifier, created_at) VALUES 
(1, 'user1@example.com', CURRENT_TIMESTAMP),
(1, 'user2@example.com', CURRENT_TIMESTAMP),
(2, 'user1@example.com', CURRENT_TIMESTAMP),
(3, 'user3@example.com', CURRENT_TIMESTAMP);
