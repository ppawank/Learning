import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import BlogCard from '../components/BlogCard';
import { blogAPI } from '../services/api';
import { getUserIdentifier, showToast } from '../utils/helpers';
import './Home.css';

const Home = () => {
    const navigate = useNavigate();
    const [blogs, setBlogs] = useState([]);
    const [loading, setLoading] = useState(true);
    const [searchTerm, setSearchTerm] = useState('');
    const [sortBy, setSortBy] = useState('date');
    const [likedBlogs, setLikedBlogs] = useState(new Set());

    const userIdentifier = getUserIdentifier();

    useEffect(() => {
        fetchBlogs();
    }, [sortBy]);

    const fetchBlogs = async () => {
        try {
            setLoading(true);
            const response = await blogAPI.getAll(sortBy);
            setBlogs(response.data);

            // Check like status for all blogs
            const likedSet = new Set();
            for (const blog of response.data) {
                try {
                    const likeStatus = await blogAPI.getLikeStatus(blog.id, userIdentifier);
                    if (likeStatus.data.hasLiked) {
                        likedSet.add(blog.id);
                    }
                } catch (error) {
                    console.error('Error checking like status:', error);
                }
            }
            setLikedBlogs(likedSet);
            setLoading(false);
        } catch (error) {
            console.error('Error fetching blogs:', error);
            showToast('Failed to load blogs', 'error');
            setLoading(false);
        }
    };

    const handleSearch = async () => {
        if (!searchTerm.trim()) {
            fetchBlogs();
            return;
        }

        try {
            setLoading(true);
            const response = await blogAPI.search(searchTerm);
            setBlogs(response.data);
            setLoading(false);
        } catch (error) {
            console.error('Error searching blogs:', error);
            showToast('Search failed', 'error');
            setLoading(false);
        }
    };

    const handleLike = async (blogId) => {
        try {
            await blogAPI.like(blogId, userIdentifier);
            setLikedBlogs(prev => new Set([...prev, blogId]));
            fetchBlogs(); // Refresh to get updated like count
            showToast('Blog liked!');
        } catch (error) {
            console.error('Error liking blog:', error);
            showToast('Failed to like blog', 'error');
        }
    };

    const handleUnlike = async (blogId) => {
        try {
            await blogAPI.unlike(blogId, userIdentifier);
            setLikedBlogs(prev => {
                const newSet = new Set(prev);
                newSet.delete(blogId);
                return newSet;
            });
            fetchBlogs(); // Refresh to get updated like count
            showToast('Blog unliked');
        } catch (error) {
            console.error('Error unliking blog:', error);
            showToast('Failed to unlike blog', 'error');
        }
    };

    return (
        <div className="home-page">
            <section className="hero">
                <div className="container">
                    <h1 className="hero-title">
                        Welcome to <span className="gradient-text">BlogApp</span>
                    </h1>
                    <p className="hero-subtitle">
                        Discover amazing stories, share your thoughts, and connect with writers
                    </p>

                    <div className="search-bar">
                        <input
                            type="text"
                            className="search-input"
                            placeholder="Search blogs..."
                            value={searchTerm}
                            onChange={(e) => setSearchTerm(e.target.value)}
                            onKeyPress={(e) => e.key === 'Enter' && handleSearch()}
                        />
                        <button className="btn btn-primary" onClick={handleSearch}>
                            🔍 Search
                        </button>
                    </div>
                </div>
            </section>

            <section className="blogs-section">
                <div className="container">
                    <div className="section-header">
                        <h2>Latest Blogs</h2>
                        <div className="sort-controls">
                            <label>Sort by:</label>
                            <select
                                className="form-select"
                                value={sortBy}
                                onChange={(e) => setSortBy(e.target.value)}
                            >
                                <option value="date">Latest</option>
                                <option value="likes">Most Liked</option>
                            </select>
                        </div>
                    </div>

                    {loading ? (
                        <div className="loading">
                            <div className="spinner"></div>
                        </div>
                    ) : blogs.length === 0 ? (
                        <div className="empty-state">
                            <h3>No blogs found</h3>
                            <p className="text-muted">Be the first to create a blog post!</p>
                            <button className="btn btn-primary" onClick={() => navigate('/create')}>
                                ✍️ Create Blog
                            </button>
                        </div>
                    ) : (
                        <div className="blogs-grid grid grid-cols-3">
                            {blogs.map(blog => (
                                <BlogCard
                                    key={blog.id}
                                    blog={blog}
                                    onLike={handleLike}
                                    onUnlike={handleUnlike}
                                    userHasLiked={likedBlogs.has(blog.id)}
                                />
                            ))}
                        </div>
                    )}
                </div>
            </section>
        </div>
    );
};

export default Home;
