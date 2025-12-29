import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

const api = axios.create({
    baseURL: API_BASE_URL,
    headers: {
        'Content-Type': 'application/json',
    },
});

// Blog API
export const blogAPI = {
    getAll: (sortBy = null) => {
        const params = sortBy ? { sortBy } : {};
        return api.get('/blogs', { params });
    },
    getById: (id) => api.get(`/blogs/${id}`),
    create: (blog) => api.post('/blogs', blog),
    update: (id, blog) => api.put(`/blogs/${id}`, blog),
    delete: (id) => api.delete(`/blogs/${id}`),
    getByCategory: (category) => api.get(`/blogs/category/${category}`),
    getByAuthor: (authorId) => api.get(`/blogs/author/${authorId}`),
    search: (title) => api.get('/blogs/search', { params: { title } }),
    like: (id, userIdentifier) =>
        api.post(`/blogs/${id}/like`, null, { params: { userIdentifier } }),
    unlike: (id, userIdentifier) =>
        api.delete(`/blogs/${id}/like`, { params: { userIdentifier } }),
    getLikeStatus: (id, userIdentifier) =>
        api.get(`/blogs/${id}/like-status`, { params: { userIdentifier } }),
};

// Author API
export const authorAPI = {
    getAll: () => api.get('/authors'),
    getById: (id) => api.get(`/authors/${id}`),
    create: (author) => api.post('/authors', author),
    update: (id, author) => api.put(`/authors/${id}`, author),
    delete: (id) => api.delete(`/authors/${id}`),
};

// Comment API
export const commentAPI = {
    getByBlogId: (blogId) => api.get(`/blogs/${blogId}/comments`),
    create: (blogId, comment) => api.post(`/blogs/${blogId}/comments`, comment),
    delete: (blogId, commentId) => api.delete(`/blogs/${blogId}/comments/${commentId}`),
};

export default api;
