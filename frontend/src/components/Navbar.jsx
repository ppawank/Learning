import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';

const Navbar = () => {
    return (
        <nav className="navbar">
            <div className="container">
                <div className="navbar-content">
                    <Link to="/" className="navbar-brand">
                        <span className="brand-icon">📝</span>
                        <span className="brand-text">BlogApp</span>
                    </Link>

                    <div className="navbar-links">
                        <Link to="/" className="nav-link">Home</Link>
                        <Link to="/authors" className="nav-link">Authors</Link>
                        <Link to="/create" className="btn btn-primary btn-sm">
                            ✍️ Write Blog
                        </Link>
                    </div>
                </div>
            </div>
        </nav>
    );
};

export default Navbar;
