# ERP Inventory System

A simple command-line Inventory Management System written in Java that uses MySQL (JDBC) for persistence. This project demonstrates basic product management, stock updates, and recording sales.

> NOTE: This repository contains IntelliJ project files (.idea) and a hard-coded database credential in `src/InventorySystem.java`. Do not use these credentials in production — replace them with secure configuration (environment variables, secrets manager, or a properties file) and remove sensitive data from the repository.

---

## Features

- Add products (name, price, quantity)
- Update product stock
- Record sales (reduces product quantity)
- Print a simple inventory report

---

## Requirements

- Java JDK (project .idea shows JDK `25`; the code uses modern switch syntax — JDK 17+ is recommended)
- MySQL server (or compatible MariaDB)
- MySQL Connector/J (JDBC driver)

---

## Quickstart

1. Clone the repository
   git clone https://github.com/iamajaykr06/Inventory-Management-System-.git

2. Prepare the database

   Create a database named `erp_inventory` and the required tables. Example SQL:

   ```sql
   CREATE DATABASE IF NOT EXISTS erp_inventory;
   USE erp_inventory;

   CREATE TABLE IF NOT EXISTS products (
     product_id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     price DOUBLE NOT NULL,
     quantity INT NOT NULL DEFAULT 0
   );

   CREATE TABLE IF NOT EXISTS sales (
     sale_id INT AUTO_INCREMENT PRIMARY KEY,
     product_id INT NOT NULL,
     quantity INT NOT NULL,
     sale_date DATE NOT NULL,
     FOREIGN KEY (product_id) REFERENCES products(product_id)
   );
   ```

3. Add MySQL Connector/J to the classpath

   - Download the Connector/J (.jar) from: https://dev.mysql.com/downloads/connector/j/
   - Place the jar somewhere accessible (e.g., `lib/mysql-connector-j-<version>.jar`)

4. Configure DB credentials

   By default the code uses the constants in `src/InventorySystem.java`:

   ```java
   static final String URL = "jdbc:mysql://localhost:3306/erp_inventory";
   static final String USER = "root";
   static final String PASS = "Ajay@1906";
   ```

   Replace these with your own credentials or modify the code to read from environment variables or a configuration file.

   Important: Do not commit real credentials. Remove or update any hard-coded secrets.

5. Compile and run

   From the project root:

   - On macOS / Linux:

     ```bash
     javac -cp "lib/mysql-connector-j-<version>.jar" -d out src/InventorySystem.java
     java -cp "out:lib/mysql-connector-j-<version>.jar" InventorySystem
     ```

   - On Windows (PowerShell / CMD):

     ```powershell
     javac -cp "lib\mysql-connector-j-<version>.jar" -d out src\InventorySystem.java
     java -cp "out;lib\mysql-connector-j-<version>.jar" InventorySystem
     ```

   Or open the project in IntelliJ IDEA (the project includes `.idea` files). Make sure to set the project SDK to your installed JDK and add the connector jar as a library or dependency.

---

## Usage

The program runs a simple text menu:

1. Add Product — enter product name, price, and quantity
2. Update Stock — set a new quantity for a product id
3. Record Sale — record a sale (product id + quantity) and decrement product quantity
4. Inventory Report — list products and quantities
5. Exit

---

## Known limitations & suggested improvements

- Credentials are hard-coded. Move to environment variables or a configuration file.
- No input validation — entering invalid IDs, negative quantities, or non-numeric input may throw exceptions.
- No transaction handling — recording a sale and updating stock should be done in a transaction to prevent inconsistencies.
- No check for available stock before recording a sale; negative inventory is currently possible.
- No logging or unit tests.
- Single-user CLI only — no concurrency handling or web UI.

If you want, I can help implement any of the improvements above (transactions, validation, config, or a GUI/web frontend).

---

## Project structure

- src/InventorySystem.java — main application
- .idea/ — IntelliJ project files
- .gitignore — ignored files list

---

## Contributing

Contributions are welcome. Suggested workflow:

- Fork the repo
- Create a feature branch
- Open a pull request with a clear description of changes

If you plan to submit changes that require DB schema changes, include the necessary SQL in the PR description.

---

## License

No license specified. Add a LICENSE file to make this repository open-source under your chosen terms.

---

## Contact

If you'd like help setting this up or want improvements, open an issue or contact the repository owner.
