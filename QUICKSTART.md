# Quick Start Guide

## Prerequisites
- PostgreSQL installed and running
- Java 16
- Maven 3.6+

## Setup Steps

1. **Create Database**
   ```sql
   CREATE DATABASE blogapp;
   ```

2. **Configure Database** (optional - update if needed)
   Edit `src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=postgres
   spring.datasource.password=postgres
   ```

3. **Run Application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access API**
   - Base URL: http://localhost:8080
   - API Docs: See README.md

## Quick Test

Create an author:
```bash
curl -X POST http://localhost:8080/api/authors \
  -H "Content-Type: application/json" \
  -d '{"name":"Test User","email":"test@example.com","bio":"Blogger"}'
```

Create a blog:
```bash
curl -X POST http://localhost:8080/api/blogs \
  -H "Content-Type: application/json" \
  -d '{"title":"Hello World","content":"My first post","category":"General","author":{"id":1}}'
```

Get all blogs:
```bash
curl http://localhost:8080/api/blogs
```

## API Endpoints Summary

- **Authors**: `/api/authors`
- **Blogs**: `/api/blogs`
- **Comments**: `/api/blogs/{blogId}/comments`
- **Likes**: `/api/blogs/{id}/like?userIdentifier={email}`

See [README.md](file:///d:/Study/BlogApp/README.md) for complete API documentation.
