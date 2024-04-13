# WheelsUN Authentication Service

A simple and secure microservice for managing authentication and authorization in Java Spring Boot applications.

## Features

- RESTful API endpoints
- OAuth2 and JWT for authentication
- Spring Security for role-based access control
- Persistent storage with Spring Data JPA and PostgreSQL

## Built With

- **Spring Web**: To build RESTful applications using Spring MVC.
- **Spring Security**: For secure authentication and access-control.
- **Spring Data JPA**: To persist data in SQL stores using Java Persistence API.
- **´PostgreSQL Driver**: To connect to PostgreSQL databases.

## Quick Start

Clone the repository and navigate into the project directory:

```bash
git clone https://github.com/yourusername/wheelsUN_auth_ms.git
cd wheelsUN_auth_ms


mvn clean install

mvn spring-boot:run


POST /login
Content-Type: application/json

{
  "username": "yourusername",
  "password": "yourpassword"
}
