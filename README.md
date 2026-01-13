# Inventory Management System (Java)
## Project Overview

This is a Core Java–based Inventory Management System that demonstrates how to manage products and sales using a layered architecture and JDBC for database interaction.

The project focuses on:

* Clean separation of concerns (DAO, Model, Utility)
* Database-driven operations using JDBC
* Real-world inventory and sales logic
* Maintainable and readable Java project structure

This is not a web application. It is a console-based Java application.

## Tech Stack
* **Java (JDK 8+)**
* **MySQL**
* **JDBC (MySQL Connector/J)**
* **IDE:** IntelliJ IDEA / Eclipse (any Java IDE)

## Project Structure
```
Inventory-Management-System/
│
├── src/
│   ├── dao/
│   │   ├── ProductDAO.java      # Product database operations
│   │   └── SalesDAO.java        # Sales & inventory update logic
│   │
│   ├── model/
│   │   └── Product.java         # Product entity / model
│   │
│   ├── util/
│   │   └── DBConnection.java    # JDBC database connection utility
│   │
│   └── InventorySystem.java     # Main application entry point
│
├── .gitignore
├── LICENSE
└── README.md
```

## Setup Instructions
### 1️. Clone the repository
```
git clone https://github.com/iamajaykr06/Inventory-Management-System-.git
cd Inventory-Management-System-
```

### 2. Database Setup (MySQL)

Create database:

```
CREATE DATABASE inventory_db;
```
Create product table:
```
CREATE TABLE products (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
quantity INT NOT NULL,
price DOUBLE NOT NULL
);
```
Create sales table:

```
CREATE TABLE sales (
id INT AUTO_INCREMENT PRIMARY KEY,
product_id INT NOT NULL,
quantity_sold INT NOT NULL,
sale_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (product_id) REFERENCES products(id)
);
```
## Dependencies

This project uses JDBC for database connectivity.

**Required:**

* MySQL Connector/J (JDBC Driver)

**Important Note**
This project does not use Maven or Gradle.
The JDBC driver must be manually added to the project classpath via your IDE.

## Run the Application
1. Open the project in your Java IDE
2. Ensure MySQL is running
3. Update database credentials in:
```
src/util/DBConnection.java
```
4. Run:
```
InventorySystem.java
```

## Features Implemented
* Add products to inventory
* View available products
* Update product quantity after sales
* Record sales transactions
* JDBC-based database interaction
* Clean DAO pattern usage

## Learning Outcomes
* JDBC connection handling
* DAO design pattern
* SQL integration with Java
* Inventory & sales logic
* Clean Java project structuring

## Notes
* This is a Core Java learning project
* No frameworks are used
* Dependency management is manual by design

### Author
Ajay Kumar
