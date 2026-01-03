# Inventory Management System (CLI-Based)

A Java-based Command Line Inventory Management System that performs full CRUD operations on products with MySQL database integration using JDBC.  
The system follows a DAO-based layered architecture, ensures transactional consistency, and supports real-world inventory operations.

## Features

- Add new products to inventory
- View complete inventory list
- Update existing product details (name, price, quantity)
- Delete products from inventory
- Record product sales with transaction management
- Automatic stock updates after sales
- Input validation and stock availability checks
- Persistent data storage using MySQL

## Tech Stack

- Language: Java
- Database: MySQL
- Database Access: JDBC
- Architecture: DAO (Data Access Object)
- Interface: Command Line Interface (CLI)

## Project Structure

```
inventory-management-system/
│
├── src/
│   ├── dao/
│   │   ├── ProductDAO.java
│   │   └── SalesDAO.java
│   │
│   ├── model/
│   │   └── Product.java
│   │
│   ├── util/
│   │   └── DBConnection.java
│   │
│   └── InventorySystem.java
│
└── README.md 
```
## Database Schema

### Products Table
```
CREATE TABLE products (
product_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
price DOUBLE NOT NULL,
quantity INT NOT NULL
); 
```

### Sales Table
```
CREATE TABLE sales (
sale_id INT PRIMARY KEY AUTO_INCREMENT,
product_id INT,
quantity INT,
sale_date DATE,
FOREIGN KEY (product_id) REFERENCES products(product_id)
);
```
## CRUD Operations Mapping

| Operation   | Description |
|------------|-------------|
| Create     | Add new product |
| Read       | View inventory / get product by ID |
| Update     | Update product details or stock |
| Delete     | Remove product |
| Transaction| Record sale and update stock atomically |

## How to Run the Project

### Prerequisites

- Java JDK 8 or higher
- MySQL Server
- IntelliJ IDEA (recommended)

### Steps

1. Clone the repository  
   git clone <your-github-repository-link>

2. Open the project in IntelliJ IDEA

3. Create the database  
   CREATE DATABASE erp_inventory;

4. Run the SQL schema provided above

5. Update database credentials in  
   src/util/DBConnection.java

6. Mark src as Sources Root in IntelliJ

7. Run InventorySystem.java

## Sample CLI Menu

1. Add Product
2. View Inventory
3. Update Product
4. Delete Product
5. Record Sale
6. Exit

## Key Concepts Demonstrated

- JDBC connectivity
- PreparedStatements
- DAO-based architecture
- Object-Oriented Programming (OOP)
- Transaction management (commit & rollback)
- Input validation and business logic separation

## Future Improvements

- User authentication and roles
- Low-stock alerts
- Inventory reports export
- Migration to Spring Boot REST API

## Author

Ajay Kumar  
GitHub: https://github.com/iamajaykr06  
LinkedIn: https://www.linkedin.com/in/iamajaykr

## License

This project is licensed under the MIT License.
