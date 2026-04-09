# Rp-Ecommerce (Backend API)

![Java](https://img.shields.io/badge/Java-17%2B-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green) ![Status](https://img.shields.io/badge/Status-In%20Development-blue)

A robust, scalable E-commerce backend application built with **Java Spring Boot**. This project demonstrates a production-ready **RESTful API** architecture with a focus on security, clean code, and maintainability.

> **Note:** This project is part of my portfolio to showcase my backend development skills for full-stack engineering roles.

---

## 🛠 Tech Stack

- **Core Framework**: Java, Spring Boot
- **Security**: Spring Security, JWT (JSON Web Tokens)
- **Database**: Spring Data JPA, Hibernate (SQL)
- **Payment Gateway**: Stripe SDK Integration
- **Build Tool**: Maven
- **Architecture**: Layered Architecture (Controller-Service-Repository)

---

## 📂 Project Structure & Architecture

The application follows a strict separation of concerns to ensure scalability. Below is the breakdown of the codebase:

| Package         | Purpose                                                                 |
|------------------|-------------------------------------------------------------------------|
| `config`         | Configuration files for Security, CORS, and Stripe API integration.    |
| `controller`     | REST controllers handling HTTP requests and mapping endpoints.         |
| `service`        | Business logic layer containing the core rules of the application.     |
| `repository`     | Data access layer (DAO) using Spring Data JPA interfaces.              |
| `model`          | Database entities representing the SQL tables.                        |
| `payload`        | **DTOs (Data Transfer Objects)** to decouple internal schema from API. |
| `exception`      | Global exception handling for consistent API error responses.          |

---

## 🚀 Key Features

- **Payment Integration**: Secure payment processing using Stripe API (Test mode supported).
- **User Authentication**: Secure registration and login flow using **BCrypt** password hashing and **JWT** generation/validation.
- **Role-Based Access Control (RBAC)**: Middleware to protect admin-only endpoints.
- **Global Error Handling**: Centralized exception handling to return meaningful JSON errors.
- **DTO Pattern**: Usage of Request/Response objects to validate input data before it reaches the database.

---

## 🚧 Roadmap (Upcoming Features)

- [ ] Order Management System (Place, Cancel, Track orders).
- [ ] Search and Filter functionality for Products.
- [ ] Docker support for containerized deployment.
- [ ] Unit and Integration testing with JUnit 5 and Mockito.
- [ ] Deployment to cloud platforms (AWS, Azure, or Heroku).

---
```markdown
## 🔧 Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/rpal18/Rp-ecommerce.git
   cd Rp-ecommerce
   ```

2. **Configure the Database**:
   Update `src/main/resources/application.properties` with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

3. **Configure Stripe API Keys**:
   Obtain your Stripe API keys from the [Stripe Dashboard](https://dashboard.stripe.com/) and add them to `application.properties`:
   ```properties
   stripe.api.key=sk_test_your_secret_key
   stripe.publishable.key=pk_test_your_publishable_key
   ```

4. **Build and Run the Application**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Test the APIs**:
   Use Postman or any API client to test the endpoints. Example:
   - `POST /api/payments/create` to create a payment intent.

---



### Environment Variables

The application requires the following environment variables to be set:

| Variable Name      | Purpose                                   | Expected Value       | Example Value          | Scope                  |
|--------------------|-------------------------------------------|----------------------|------------------------|------------------------|
| `DB_USERNAME`      | Database username for PostgreSQL         | String               | `example_user`         | Development, Production |
| `DB_PASSWORD`      | Database password for PostgreSQL         | String               | `example_password`     | Development, Production |
| `JWT_SECRETKEY`    | Secret key for JWT token generation      | String (Alphanumeric) | `your_secret_key`      | All                    |
| `STRIPE_SK`        | Stripe secret key for payment processing | String (Starts with `sk_`) | `sk_test_12345` | Development            |
| `STRIPE_PK`        | Stripe publishable key for frontend      | String (Starts with `pk_`) | `pk_test_12345` | Development            |

> **Note**: Ensure sensitive variables like `DB_PASSWORD`, `JWT_SECRETKEY`, and `STRIPE_SK` are kept secure and not exposed in version control.

To set these variables:
- On Windows (Command Prompt): `set VARIABLE_NAME=value`
- On Linux/Mac: `export VARIABLE_NAME=value`

📬 **Contact**

**Rohit Pal**  
*Aspiring Software Engineer*
- **Email**: [palrohitpr03@gmail.com](mailto:your-email@example.com)
- **LinkedIn**: [https://www.linkedin.com/in/rohit-pal-a41a6229a/](https://linkedin.com/in/your-profile)
- **GitHub**: [https://github.com/rpal18/](https://github.com/rpal18)

---



⭐ **Feel free to star this repository if you find it helpful!**
```

