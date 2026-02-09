# Rp-Ecommerce (Backend API)

![Java](https://img.shields.io/badge/Java-17%2B-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green) ![Status](https://img.shields.io/badge/Status-In%20Development-blue)

A robust, scalable E-commerce backend application built with **Java Spring Boot**. This project demonstrates a production-ready **RESTful API** architecture with a focus on security, clean code, and maintainability.

> **Note:** This project is currently under active development as part of my portfolio for full-stack engineering roles.

## 🛠 Tech Stack

* **Core Framework:** Java, Spring Boot
* **Security:** Spring Security, JWT (JSON Web Tokens)
* **Database:** Spring Data JPA, Hibernate (SQL)
* **Build Tool:** Maven
* **Architecture:** Layered Architecture (Controller-Service-Repository)

## 📂 Project Structure & Architecture

The application follows a strict separation of concerns to ensure scalability. Here is the breakdown of the codebase based on the `src/main/java` directory:

| Package | Purpose |
| :--- | :--- |
| `config` | Configuration classes for Security, CORS, and Swagger/OpenAPI. |
| `controller` | REST controllers handling HTTP requests and mapping endpoints. |
| `service` | Business logic layer containing the core rules of the application. |
| `repository` | Data access layer (DAO) using Spring Data JPA interfaces. |
| `model` | Database entities representing the SQL tables. |
| `payload` | **DTOs (Data Transfer Objects)** to decouple the internal database schema from client responses. |
| `security.jwt` | Custom filters and utilities for handling **Stateless Authentication**. |
| `exception` | Global exception handling (`@ControllerAdvice`) for consistent API error responses. |
| `bootstrap` | Initial data seeding and startup logic. |

## 🚀 Key Features (Implemented)

* **User Authentication:** Secure registration and login flow using **BCrypt** password hashing and **JWT** generation/validation.
* **Role-Based Access Control (RBAC):** Middleware to protect admin-only endpoints.
* **Global Error Handling:** Centralized exception handling to return meaningful JSON errors (e.g., `404 Resource Not Found`, `400 Bad Request`) instead of stack traces.
* **DTO Pattern:** Usage of Request/Response objects to validate input data before it reaches the database.

## 🚧 Roadmap (Upcoming Features)

* [ ] Integration of Payment Gateway (Stripe/PayPal).
* [ ] Order Management System (Place, Cancel, Track orders).
* [ ] Search and Filter functionality for Products.
* [ ] Docker support for containerized deployment.
* [ ] Unit and Integration testing with JUnit 5 and Mockito.

## 🔧 Getting Started

1.  **Clone the repository**
    ```bash
    git clone [https://github.com/rpal18/Rp-ecommerce.git](https://github.com/rpal18/Rp-ecommerce.git)
    cd Rp-ecommerce
    ```

2.  **Configure the Database**
    Update `src/main/resources/application.properties` with your database credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
    spring.datasource.username=root
    spring.datasource.password=your_password
    ```

3.  **Run the Application**
    ```bash
    ./mvnw spring-boot:run
    ```

## 📬 Contact

**Rohit Pal** *Aspiring Software Engineer*
