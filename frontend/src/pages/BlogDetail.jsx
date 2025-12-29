import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { blogAPI, commentAPI } from '../services/api';
import { formatDate, getUserIdentifier, showToast } from '../utils/helpers';
import './BlogDetail.css';

const BlogDetail = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [blog, setBlog] = useState(null);
    const [comments, setComments] = useState([]);
    const [loading, setLoading] = useState(true);
    const [userHasLiked, setUserHasLiked] = useState(false);
    const [likeCount, setLikeCount] = useState(0);
    const [newComment, setNewComment] = useState({
        content: '',
        commenterName: '',
        commenterEmail: ''
    });

    const userIdentifier = getUserIdentifier();

    useEffect(() => {
        fetchBlog();
        fetchComments();
        checkLikeStatus();
    }, [id]);

    const fetchBlog = async () => {
        try {
            const response = await blogAPI.getById(id);
            setBlog(response.data);
            setLikeCount(response.data.likeCount || 0);
            setLoading(false);
        } catch (error) {
            console.error('Error fetching blog:', error);
            showToast('Failed to load blog', 'error');
            setLoading(false);
        }
    };

    const fetchComments = async () => {
        try {
            const response = await commentAPI.getByBlogId(id);
            setComments(response.data);
        } catch (error) {
            console.error('Error fetching comments:', error);
        }
    };

    const checkLikeStatus = async () => {
        try {
            const response = await blogAPI.getLikeStatus(id, userIdentifier);
            setUserHasLiked(response.data.hasLiked);
            setLikeCount(response.data.likeCount);
        } catch (error) {
            console.error('Error checking like status:', error);
        }
    };

    const handleLike = async () => {
        try {
            if (userHasLiked) {
                await blogAPI.unlike(id, userIdentifier);
                setUserHasLiked(false);
                setLikeCount(prev => prev - 1);
                showToast('Blog unliked');
            } else {
                await blogAPI.like(id, userIdentifier);
                setUserHasLiked(true);
                setLikeCount(prev => prev + 1);
                showToast('Blog liked!');
            }
        } catch (error) {
            console.error('Error toggling like:', error);
            showToast('Failed to update like', 'error');
        }
    };

    const handleCommentSubmit = async (e) => {
        e.preventDefault();
        if (!newComment.content || !newComment.commenterName || !newComment.commenterEmail) {
            showToast('Please fill all fields', 'warning');
            return;
        }

        try {
            await commentAPI.create(id, newComment);
            setNewComment({ content: '', commenterName: '', commenterEmail: '' });
            fetchComments();
            showToast('Comment added successfully!');
        } catch (error) {
            console.error('Error adding comment:', error);
            showToast('Failed to add comment', 'error');
        }
    };

    const handleDelete = async () => {
        if (!window.confirm('Are you sure you want to delete this blog?')) return;

        try {
            await blogAPI.delete(id);
            showToast('Blog deleted successfully');
            navigate('/');
        } catch (error) {
            console.error('Error deleting blog:', error);
            showToast('Failed to delete blog', 'error');
        }
    };

    if (loading) {
        return (
            <div className="loading">
                <div className="spinner"></div>
            </div>
        );
    }

    if (!blog) {
        return <div className="container mt-2 text-center">Blog not found</div>;
    }

    return (
        <div className="blog-detail-page">
            <div className="container">
                <div className="blog-detail-header">
                    <button onClick={() => navigate('/')} className="btn btn-secondary btn-sm">
                        ← Back to Blogs
                    </button>
                    <button onClick={handleDelete} className="btn btn-danger btn-sm">
                        🗑️ Delete
                    </button>
                </div>

                <article className="blog-detail card">
                    <div className="blog-meta">
                        <span className="badge">{blog.category || 'General'}</span>
                        <span className="text-muted">{formatDate(blog.createdAt)}</span>
                    </div>

                    <h1 className="blog-detail-title">{blog.title}</h1>

                    <div className="blog-author-info">
                        <span className="author-avatar">👤</span>
                        <div>
                            <div className="author-name">{blog.author?.name || 'Anonymous'}</div>
                            <div className="author-email text-muted">{blog.author?.email}</div>
                        </div>
                    </div>

                    <div className="blog-content">
                        {blog.content}
                    </div>

                    <div className="blog-actions">
                        <button
                            className={`like-button ${userHasLiked ? 'liked' : ''}`}
                            onClick={handleLike}
                        >
                            {userHasLiked ? '❤️' : '🤍'} {likeCount} {likeCount === 1 ? 'Like' : 'Likes'}
                        </button>
                    </div>
                </article>

                <section className="comments-section">
                    <h2>Comments ({comments.length})</h2>

                    <form onSubmit={handleCommentSubmit} className="comment-form card">
                        <h3>Add a Comment</h3>
                        <div className="form-group">
                            <input
                                type="text"
                                className="form-input"
                                placeholder="Your Name"
                                value={newComment.commenterName}
                                onChange={(e) => setNewComment({ ...newComment, commenterName: e.target.value })}
                            />
                        </div>
                        <div className="form-group">
                            <input
                                type="email"
                                className="form-input"
                                placeholder="Your Email"
                                value={newComment.commenterEmail}
                                onChange={(e) => setNewComment({ ...newComment, commenterEmail: e.target.value })}
                            />
                        </div>
                        <div className="form-group">
                            <textarea
                                className="form-textarea"
                                placeholder="Write your comment..."
                                value={newComment.content}
                                onChange={(e) => setNewComment({ ...newComment, content: e.target.value })}
                            />
                        </div>
                        <button type="submit" className="btn btn-primary">Post Comment</button>
                    </form>

                    <div className="comments-list">
                        {comments.map(comment => (
                            <div key={comment.id} className="comment card">
                                <div className="comment-header">
                                    <div className="comment-author">
                                        <span className="author-avatar">💬</span>
                                        <div>
                                            <div className="author-name">{comment.commenterName}</div>
                                            <div className="comment-date text-muted">{formatDate(comment.createdAt)}</div>
                                        </div>
                                    </div>
                                </div>
                                <p className="comment-content">{comment.content}</p>
                            </div>
                        ))}
                        {comments.length === 0 && (
                            <p className="text-center text-muted">No comments yet. Be the first to comment!</p>
                        )}
                    </div>
                </section>
            </div>
        </div>
    );
};

export default BlogDetail;
