# BlogApp - Full-Stack Blogging Portal

A modern, full-stack blogging application built with Spring Boot and React.

## Quick Start

### Backend (Spring Boot)
```bash
cd d:\Study\BlogApp
mvn spring-boot:run
```
Runs on http://localhost:8080

### Frontend (React)
```bash
cd d:\Study\BlogApp\frontend
npm install
npm run dev
```
Runs on http://localhost:3000

## Prerequisites

- Java 16
- Maven 3.6+
- PostgreSQL 12+
- Node.js 14+ and npm

## Database Setup

```sql
CREATE DATABASE blogapp;
```

Update credentials in `src/main/resources/application.properties` if needed.

## Features

- ✅ Create, read, update, delete blogs
- ✅ Author management
- ✅ Comments on blogs
- ✅ Like/upvote functionality
- ✅ Search and filter
- ✅ Modern, responsive UI
- ✅ Dark theme with glassmorphism

## Documentation

- [Backend README](README.md) - Spring Boot API documentation
- [Frontend README](frontend/README.md) - React app documentation
- [Walkthrough](walkthrough.md) - Complete feature walkthrough
- [Quick Start](QUICKSTART.md) - Quick setup guide

## Project Structure

```
BlogApp/
├── src/                    # Spring Boot backend
│   ├── main/java/
│   └── main/resources/
├── frontend/               # React frontend
│   └── src/
├── pom.xml                # Maven config
└── README.md              # This file
```

## Tech Stack

**Backend**: Spring Boot 2.7.18, PostgreSQL, JPA/Hibernate, Maven
**Frontend**: React 18, Vite 4, React Router, Axios

## License

MIT
