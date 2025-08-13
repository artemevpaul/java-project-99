# Task Manager API

Task Manager API is a learning-focused REST service for managing tasks: create, read, update, and delete tasks with statuses, assignees, and labels. The project showcases a typical Spring stack and patterns for building CRUD applications with validation, security, and auto-generated API documentation.

Key features:
- CRUD for tasks, statuses, and labels
- Powerful task filtering by assignee, status, and labels
- Validation via DTOs and Jakarta Validation
- Authentication with JWT (Resource Server)
- OpenAPI/Swagger UI auto-generated documentation
- Embedded H2 database for local development

## Install and Run

Clone the repository and enter the project directory:
_git clone [https://github.com/artemevpaul/java-project-99.git]_

## Build and start the application:

`bash ./gradlew clean` `build ./gradlew bootRun`

## Useful endpoints after start:

- Swagger UI: http://localhost:8080/swagger-ui/index.html
- OpenAPI spec: http://localhost:8080/v3/api-docs


### Hexlet tests and linter status:

[![Actions Status](https://github.com/artemevpaul/java-project-99/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/artemevpaul/java-project-99/actions)

[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=artemevpaul_java-project-99&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=artemevpaul_java-project-99)

[![Java CI](https://github.com/artemevpaul/java-project-99/actions/workflows/Main.yml/badge.svg)](https://github.com/artemevpaul/java-project-99/actions/workflows/Main.yml)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=artemevpaul_java-project-99&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=artemevpaul_java-project-99)

### Deployed on Render:

https://java-project-99-4x55.onrender.com/