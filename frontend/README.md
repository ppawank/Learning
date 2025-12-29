# Frontend

This directory contains the React frontend for BlogApp.

## Setup

1. Install dependencies:
```bash
npm install
```

2. Start development server:
```bash
npm run dev
```

The app will run on http://localhost:3000

## Build for Production

```bash
npm run build
```

## Features

- Modern React with Vite
- React Router for navigation
- Axios for API calls
- Responsive design
- Dark theme with glassmorphism
- Blog CRUD operations
- Comments system
- Like/upvote functionality
- Search and filtering

## Project Structure

```
frontend/
├── src/
│   ├── components/      # Reusable components
│   ├── pages/          # Page components
│   ├── services/       # API services
│   ├── utils/          # Utility functions
│   ├── App.jsx         # Main app component
│   ├── main.jsx        # Entry point
│   └── index.css       # Global styles
├── index.html          # HTML template
├── vite.config.js      # Vite configuration
└── package.json        # Dependencies
```
