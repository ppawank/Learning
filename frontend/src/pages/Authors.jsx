import React, { useState, useEffect } from 'react';
import { authorAPI, blogAPI } from '../services/api';
import { showToast } from '../utils/helpers';
import './Authors.css';

const Authors = () => {
    const [authors, setAuthors] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetchAuthors();
    }, []);

    const fetchAuthors = async () => {
        try {
            const response = await authorAPI.getAll();

            // Fetch blog count for each author
            const authorsWithBlogs = await Promise.all(
                response.data.map(async (author) => {
                    try {
                        const blogsResponse = await blogAPI.getByAuthor(author.id);
                        return { ...author, blogCount: blogsResponse.data.length };
                    } catch (error) {
                        return { ...author, blogCount: 0 };
                    }
                })
            );

            setAuthors(authorsWithBlogs);
            setLoading(false);
        } catch (error) {
            console.error('Error fetching authors:', error);
            showToast('Failed to load authors', 'error');
            setLoading(false);
        }
    };

    if (loading) {
        return (
            <div className="loading">
                <div className="spinner"></div>
            </div>
        );
    }

    return (
        <div className="authors-page">
            <div className="container">
                <div className="page-header">
                    <h1>👥 Our Authors</h1>
                    <p className="text-muted">Meet the talented writers behind our blog posts</p>
                </div>

                {authors.length === 0 ? (
                    <div className="empty-state">
                        <h3>No authors yet</h3>
                        <p className="text-muted">Create your first blog post to add an author!</p>
                    </div>
                ) : (
                    <div className="authors-grid grid grid-cols-3">
                        {authors.map(author => (
                            <div key={author.id} className="author-card card">
                                <div className="author-avatar-large">👤</div>
                                <h3>{author.name}</h3>
                                <p className="author-email text-muted">{author.email}</p>
                                {author.bio && <p className="author-bio">{author.bio}</p>}
                                <div className="author-stats">
                                    <span className="badge">{author.blogCount || 0} {author.blogCount === 1 ? 'Blog' : 'Blogs'}</span>
                                </div>
                            </div>
                        ))}
                    </div>
                )}
            </div>
        </div>
    );
};

export default Authors;
