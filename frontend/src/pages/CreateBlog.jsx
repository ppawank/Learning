import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { blogAPI, authorAPI } from '../services/api';
import { showToast } from '../utils/helpers';
import './CreateBlog.css';

const CreateBlog = () => {
    const navigate = useNavigate();
    const [authors, setAuthors] = useState([]);
    const [showAuthorForm, setShowAuthorForm] = useState(false);
    const [blog, setBlog] = useState({
        title: '',
        content: '',
        category: '',
        author: { id: '' }
    });
    const [newAuthor, setNewAuthor] = useState({
        name: '',
        email: '',
        bio: ''
    });

    useEffect(() => {
        fetchAuthors();
    }, []);

    const fetchAuthors = async () => {
        try {
            const response = await authorAPI.getAll();
            setAuthors(response.data);
        } catch (error) {
            console.error('Error fetching authors:', error);
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!blog.title || !blog.content || !blog.author.id) {
            showToast('Please fill all required fields', 'warning');
            return;
        }

        try {
            await blogAPI.create(blog);
            showToast('Blog created successfully!');
            navigate('/');
        } catch (error) {
            console.error('Error creating blog:', error);
            showToast('Failed to create blog', 'error');
        }
    };

    const handleAuthorSubmit = async (e) => {
        e.preventDefault();

        if (!newAuthor.name || !newAuthor.email) {
            showToast('Name and email are required', 'warning');
            return;
        }

        try {
            const response = await authorAPI.create(newAuthor);
            setAuthors([...authors, response.data]);
            setBlog({ ...blog, author: { id: response.data.id } });
            setNewAuthor({ name: '', email: '', bio: '' });
            setShowAuthorForm(false);
            showToast('Author created successfully!');
        } catch (error) {
            console.error('Error creating author:', error);
            showToast('Failed to create author', 'error');
        }
    };

    return (
        <div className="create-blog-page">
            <div className="container">
                <div className="page-header">
                    <h1>✍️ Create New Blog Post</h1>
                    <button onClick={() => navigate('/')} className="btn btn-secondary">
                        Cancel
                    </button>
                </div>

                <div className="create-blog-content">
                    <form onSubmit={handleSubmit} className="blog-form card">
                        <div className="form-group">
                            <label className="form-label">Title *</label>
                            <input
                                type="text"
                                className="form-input"
                                placeholder="Enter blog title..."
                                value={blog.title}
                                onChange={(e) => setBlog({ ...blog, title: e.target.value })}
                                required
                            />
                        </div>

                        <div className="form-group">
                            <label className="form-label">Category</label>
                            <input
                                type="text"
                                className="form-input"
                                placeholder="e.g., Technology, Lifestyle, Travel"
                                value={blog.category}
                                onChange={(e) => setBlog({ ...blog, category: e.target.value })}
                            />
                        </div>

                        <div className="form-group">
                            <label className="form-label">Author *</label>
                            <div className="author-select-group">
                                <select
                                    className="form-select"
                                    value={blog.author.id}
                                    onChange={(e) => setBlog({ ...blog, author: { id: e.target.value } })}
                                    required
                                >
                                    <option value="">Select an author</option>
                                    {authors.map(author => (
                                        <option key={author.id} value={author.id}>
                                            {author.name} ({author.email})
                                        </option>
                                    ))}
                                </select>
                                <button
                                    type="button"
                                    className="btn btn-secondary btn-sm"
                                    onClick={() => setShowAuthorForm(!showAuthorForm)}
                                >
                                    {showAuthorForm ? 'Cancel' : '+ New Author'}
                                </button>
                            </div>
                        </div>

                        {showAuthorForm && (
                            <div className="author-form card">
                                <h3>Create New Author</h3>
                                <div className="form-group">
                                    <input
                                        type="text"
                                        className="form-input"
                                        placeholder="Author Name *"
                                        value={newAuthor.name}
                                        onChange={(e) => setNewAuthor({ ...newAuthor, name: e.target.value })}
                                    />
                                </div>
                                <div className="form-group">
                                    <input
                                        type="email"
                                        className="form-input"
                                        placeholder="Author Email *"
                                        value={newAuthor.email}
                                        onChange={(e) => setNewAuthor({ ...newAuthor, email: e.target.value })}
                                    />
                                </div>
                                <div className="form-group">
                                    <textarea
                                        className="form-textarea"
                                        placeholder="Author Bio (optional)"
                                        value={newAuthor.bio}
                                        onChange={(e) => setNewAuthor({ ...newAuthor, bio: e.target.value })}
                                        rows="3"
                                    />
                                </div>
                                <button
                                    type="button"
                                    className="btn btn-primary"
                                    onClick={handleAuthorSubmit}
                                >
                                    Create Author
                                </button>
                            </div>
                        )}

                        <div className="form-group">
                            <label className="form-label">Content *</label>
                            <textarea
                                className="form-textarea"
                                placeholder="Write your blog content here..."
                                value={blog.content}
                                onChange={(e) => setBlog({ ...blog, content: e.target.value })}
                                rows="15"
                                required
                            />
                        </div>

                        <div className="form-actions">
                            <button type="submit" className="btn btn-primary btn-lg">
                                📝 Publish Blog
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default CreateBlog;
