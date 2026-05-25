# 🔗 Full-Stack URL Shortener Platform

[![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](#)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](#)
[![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)](#)
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](#)
[![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)](#)

A scalable, full-stack URL Shortener application built using **Spring Boot (Java 21)** and **React (Vite)**. This system provides secure authentication (JWT & OAuth 2.0), custom link aliases, real-time analytics, and containerized deployment.

Designed with a focus on system scalability, robust security, and maintainable architecture—making it an enterprise-ready solution.

**Live Demo:** [url-shortener-t09o.onrender.com](https://url-shortener-t09o.onrender.com)

---

## ✨ Core Features

* **URL Management:** Convert long URLs into concise, shareable links with support for custom aliases.
* **Robust Security:** Completely custom stateless authentication using **JWT** and **OAuth 2.0** (Google & GitHub) via Spring Security. *Zero reliance on BaaS like Firebase.*
* **Analytics Dashboard:** Track URL usage statistics (total clicks, access history, user-specific performance) rendered via a responsive React UI.
* **Role-Based Access Control (RBAC):** Secure data boundaries ensuring users can only manage and view analytics for their own links.
* **Containerized:** Seamless local development and deployment using **Docker & Docker Compose**.

---

## 🏗️ System Design & Architecture (Interview Ready)

This project was built following microservice-ready principles and a strict separation of concerns. 

### 1. The Shortening Algorithm (Hashing & Base62)
To ensure fast and collision-free URL generation, the system generates a unique identifier for each URL. Using **Base62 encoding** (A-Z, a-z, 0-9), a short string of 7 characters can support over **3.5 trillion** unique URLs ($62^7$), ensuring massive scalability.

### 2. High-Performance Redirection
When a client requests a short URL, the Spring Boot backend intercepts the path variable, queries the database via an indexed column (to ensure $O(1)$ or $O(\log n)$ lookup times), and instantly returns an HTTP `302 Found` redirect to the original URL.

### 3. Authentication Flow (JWT + OAuth2)
* **Login:** User authenticates via standard credentials or an OAuth Provider (Google/GitHub).
* **Token Generation:** The backend authenticates the request and generates a signed JWT payload containing the user's roles and ID.
* **Stateless Session:** The React frontend stores the JWT (securely) and attaches it to the `Authorization: Bearer` header for all subsequent API calls. Spring Security filters intercept and validate these requests statelessly.

### 4. Data Layer & Analytics
Every time a redirection occurs, an asynchronous event is triggered to update the analytics table (incrementing the click counter and recording the timestamp). This prevents the analytics logic from slowing down the actual URL redirection process.

---

## 🛠️ Technology Stack

| Domain | Technologies |
| :--- | :--- |
| **Backend** | Java 21, Spring Boot, Spring Security, Spring OAuth2, JWT |
| **Frontend** | React (Vite), TypeScript/JavaScript (ES6+), Axios, TailwindCSS |
| **DevOps** | Docker, Docker Compose, Git, Maven |

---

## 🚀 Getting Started

Follow these steps to run the application locally.

### Prerequisites
* Java 21+
* Node.js 22+
* Docker & Docker Compose

### Running the Application

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/rahulatoz365-del/Url-shortener.git](https://github.com/rahulatoz365-del/Url-shortener.git)
   cd Url-shortener

```

2. **Run with Docker Compose:**
The easiest way to spin up the entire application (Backend, Frontend, and Database) is via Docker.
```bash
docker-compose up --build

```


3. **Access the application:**
* Frontend (React UI): `http://localhost:5173` (or port specified in compose)
* Backend API: `http://localhost:8080`



---

## 🛡️ Security Considerations

* **Password Hashing:** Passwords are encrypted using Bcrypt before entering the database.
* **Stateless Auth:** System uses JWTs, eliminating the need for server-side session memory.
* **CORS & CSRF:** Strictly configured to only allow authorized cross-origin requests from the React frontend.
