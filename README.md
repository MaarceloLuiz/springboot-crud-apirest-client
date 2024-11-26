# Clients CRUD - Spring Boot

## Objective
Develop a RESTful API with full CRUD operations for managing clients.

## Features
- Paginated client list
- Search clients by ID
- Add new clients
- Update existing clients
- Delete clients
- Exception handling for:
  - Resource not found (404)
  - Validation errors (422)

## Domain Model
- **Client**: Contains fields for `id`, `name`, `CPF`, `income`, `birthDate`, and `children`.

![image](https://github.com/user-attachments/assets/563a27c8-0a57-47cb-8a04-fa9be3938a1c)

## Tech && Frameworks
- **Spring Boot**: Framework for building the REST API.
- **JPA/Hibernate**: ORM for database management.
- **H2 Database**: In-memory database for testing.
- **Postman**: For testing the API endpoints.
- **Maven**: Build automation.

## How to Run
### Prerequisites
- Java 8 or higher
- Maven

### Steps
#### 1. Clone the repository:
```bash
git clone https://github.com/MaarceloLuiz/springboot-crud-apirest-client.git
cd springboot-crud-apirest-client
```
#### 2. Build the project using Maven and run the Application:
```bash
mvn clean install
mvn spring-boot:run
```
#### 3. Open Postman (or any API testing tool).
#### 4. Use the following base URL to access the API endpoints:
```bash
http://localhost:8080
```
#### 5. The available endpoints include:
- GET /clients - Retrieve a paginated list of clients.
  - You can use query parameters such as page, size, and sort to control the pagination:
  - **page**: Page number (starting from 0).
  - **size**: Number of results per page.
  - **sort**: Sorting field (e.g., name).
- For example: to retrieve the second page of clients with 10 results per page, sorted by name:
```bash
http://localhost:8080/clients?page=1&size=10&sort=name
```
- GET /clients/{id} - Retrieve client details by ID.
- POST /clients - Add a new client (requires a JSON body).
- PUT /clients/{id} - Update an existing client by ID.
- DELETE /clients/{id} - Delete a client by ID.

#### For example, you can test the GET /clients endpoint in Postman by sending a request to:
```bash
http://localhost:8080/clients
```

#### 6. To stop the application run the following command in the terminal:
```bash
mvn spring-boot:stop
```

## Author
Marcelo Luiz Guimarães Pereira

<a href="https://www.linkedin.com/in/marcelo-luiz-guimar%C3%A3es-pereira-613933269/"><img src="https://img.shields.io/badge/linkedin%20-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn"/></a>

---
