# Shop Backend

## Overview
This project is a **backend application** for an internet shop built using **Spring Boot**. It utilizes a **PostgreSQL database**, managed and configured automatically using **Docker**, ensuring seamless setup and integration. The backend includes functionality for managing users, products, orders, and quantities.

## Features

### Order Management
- Retrieve user orders based on email.
- Place and buy orders.
- Add and delete products from orders.

### Product Management
- Create and update product details.
- Retrieve all products.
- Delete specific products by their ID.

### User Management
- Create, update, and retrieve users.
- User login with email and password.
- Change user passwords.

---

## Key Technologies

- **Spring Boot**: Framework for building the application.
- **PostgreSQL**: Database for storing application data.
- **Docker**: Used to containerize the PostgreSQL database.
- **REST API**: Exposes endpoints for interaction with the backend.

---

## Setup

### Prerequisites

- Docker
- Java 21

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/Andruszkiewicz-Artur/InternetShop.git
   cd InternetShop
   
2. Start the PostgreSQL database using Docker:
   ```bash
   docker-compose up
The Docker configuration automatically sets up the database for the application.

3. Run the backend:
   ```bash
   ./mvnw spring-boot:run
   
4. Access the API using the base URL: http://localhost:8080/api.

## Endpoints

Order API
- GET /api/order: Retrieve orders by email.
- POST /api/order/buy: Buy an order by ID.
- POST /api/order/product: Add a product to an order.
- DELETE /api/order/product: Delete a product from an order by ID.
  
Product API
- POST /api/product: Create or update a product.
- GET /api/product: Retrieve all products.
- DELETE /api/product: Delete a product by its ID.
  
User API
- POST /api/user: Create a new user.
- GET /api/user: Retrieve all users.
- GET /api/user/login: Log in a user using email and password.
- PUT /api/user/changePassword: Change a user’s password.
- PUT /api/user: Update user details.

## Contribution

Feel free to contribute to the project by:
- Creating new features or fixing bugs.
- Improving performance or refactoring the codebase.
- Submitting pull requests.

## License

This project is licensed under the MIT License.

For any questions, open an issue or contact the repository owner. 😊





















































