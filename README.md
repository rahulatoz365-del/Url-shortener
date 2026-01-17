# URL Shortener Platform

A full-stack URL Shortener application built using **Spring Boot** and **React (Vite)**. The system provides secure authentication, OAuth integration, detailed analytics, and containerized deployment. It is designed with scalability, security, and maintainability as core principles.

---

## Overview

This project enables users to shorten long URLs, manage them through a secure dashboard, and analyze usage metrics. Authentication is handled using JWT and OAuth 2.0 (Google and GitHub) without relying on third-party backend services such as Firebase.

---

## Features

### URL Shortening

* Create short URLs from long links
* Support for custom aliases
* Efficient redirection handling
* URL management per authenticated user

### Authentication and Authorization

* JWT-based stateless authentication
* OAuth 2.0 login with:

  * Google
  * GitHub
* Implemented using Spring Security and Spring Security OAuth
* Role-based access control
* Secure token generation and validation

### Analytics Dashboard

* Track URL usage statistics
* Metrics include:

  * Click counts
  * Access history
  * User-specific URL performance
* Dashboard built with React for clear and responsive data visualization

### User Management

* User registration and login
* Unified handling of OAuth and traditional authentication
* Secure access to user-owned URLs and analytics

### Containerization

* Docker-based containerization for backend and frontend
* Environment-specific configuration support
* Simplified local development and deployment

---

## Technology Stack

### Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Security OAuth2
* JWT (JSON Web Tokens)
* RESTful APIs

### Frontend

* React
* Vite
* JavaScript (ES6+)
* Axios for API communication

### Build and Deployment

* Docker
* Docker Compose
* Maven
* Git

---

## Architecture

* The backend exposes REST APIs for authentication, URL management, and analytics
* The frontend consumes these APIs and provides the user interface
* JWT enables stateless session management
* OAuth providers handle third-party authentication securely
* Docker ensures consistent runtime environments

---

## Getting Started

### Prerequisites

* Java 21
* Node.js 22
* Docker and Docker Compose

### Running the Application

```bash
docker-compose up --build
```

This will start both the backend and frontend services.

---

## Security Considerations

* Stateless authentication using JWT
* Secure OAuth 2.0 authorization flow
* Password encryption using industry-standard hashing algorithms
* CORS and CSRF configurations aligned with security best practices
* No dependency on Firebase or similar backend-as-a-service platforms
* Optimize it specifically for **resume and recruiter review**
* Generate a **system design explanation** for interviews
