import React from 'react';
import { Link } from 'react-router-dom';
import { formatRelativeTime, truncateText } from '../utils/helpers';
import './BlogCard.css';

const BlogCard = ({ blog, onLike, onUnlike, userHasLiked }) => {
    const handleLikeClick = (e) => {
        e.preventDefault();
        if (userHasLiked) {
            onUnlike(blog.id);
        } else {
            onLike(blog.id);
        }
    };

    return (
        <Link to={`/blog/${blog.id}`} className="blog-card card">
            <div className="blog-card-header">
                <span className="blog-category badge">{blog.category || 'General'}</span>
                <span className="blog-date text-muted">{formatRelativeTime(blog.createdAt)}</span>
            </div>

            <h3 className="blog-title">{blog.title}</h3>
            <p className="blog-excerpt text-muted">{truncateText(blog.content, 120)}</p>

            <div className="blog-card-footer">
                <div className="blog-author">
                    <span className="author-avatar">👤</span>
                    <span className="author-name">{blog.author?.name || 'Anonymous'}</span>
                </div>

                <div className="blog-stats">
                    <button
                        className={`like-btn ${userHasLiked ? 'liked' : ''}`}
                        onClick={handleLikeClick}
                    >
                        {userHasLiked ? '❤️' : '🤍'} {blog.likeCount || 0}
                    </button>
                </div>
            </div>
        </Link>
    );
};

export default BlogCard;
