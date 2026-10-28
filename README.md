# Task Management API

A lightweight REST API to manage tasks, built with Java 17, Spring Boot, and PostgreSQL.

I built this project to practice standard backend patterns: layered architecture, request validation, centralized error handling, and running a database locally using Docker.

## Tech Stack

- **Java 17**
- **Spring Boot 3** (Spring Web, Spring Data JPA, Validation)
- **PostgreSQL**
- **Docker Compose**
- **Maven**

## Features

- Full CRUD on tasks (create, read, update, delete).
- Input validation: checks that titles aren't empty and due dates are in the future (`@Valid`, `@NotBlank`, `@FutureOrPresent`).
- Strict task states (`TODO`, `IN_PROGRESS`, `DONE`) and priorities (`LOW`, `MEDIUM`, `HIGH`) using enums.
- Automatic creation timestamps (`@CreationTimestamp`).
- Custom exception handling (`@RestControllerAdvice`) returning readable JSON errors for 400 and 404 responses.
- Quick local setup with Docker Compose.

## Project Structure

```text
src/main/java/org/example/taskmanagement/
├── controller/        # TaskController (REST endpoints)
├── services/          # TaskService (business logic)
├── repository/        # TaskRepository (Spring Data JPA)
├── modele/            # Task entity
├── Enum/              # Priority & Status enums
└── exception/         # Custom exceptions & GlobalExceptionHandler
