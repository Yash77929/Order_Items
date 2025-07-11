# 🛒 Order Items Management API

[![Java](https://img.shields.io/badge/Java-17-blue?logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Build](https://img.shields.io/badge/Build-Passing-brightgreen)]()
[![License](https://img.shields.io/badge/license-MIT-blue.svg)]()

This is a Spring Boot REST API for managing **Orders** and their associated **Order Items** in an e-commerce system.  
It allows clients to **create, update, delete, and fetch** orders along with their line items.

---

## 📦 Features

- ➕ Add a new order with items
- 🔁 Update an existing order by ID
- ❌ Delete an order by ID
- 📋 View all orders

---

## 🧱 Tech Stack

- Java 17
- Spring Boot 3+
- Spring Web
- Spring Data JPA
- H2 / PostgreSQL / MySQL
- Lombok

---

## 🔗 API Endpoints

| Method | Endpoint               | Description             |
|--------|------------------------|-------------------------|
| `POST` | `/api/orders`          | Add a new order         |
| `PUT`  | `/api/orders/{id}`     | Update order by ID      |
| `DELETE` | `/api/orders/{id}`   | Delete order by ID      |
| `GET`  | `/api/orders`          | Get all orders          |

---

## 📤 Example Requests

### ✅ Add New Order

**POST** `/api/orders`

```json
{
  "customerName": "John Doe",
  "items": [
    {
      "productName": "Laptop",
      "quantity": 1,
      "price": 799.99
    },
    {
      "productName": "Mouse",
      "quantity": 2,
      "price": 19.99
    }
  ]
}
