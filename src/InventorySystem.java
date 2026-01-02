// Copyright (c) 2026 iamajaykr06
// Licensed under the MIT License. See LICENSE in the project root for license information.
import java.sql.*;
import java.util.Scanner;

public class InventorySystem {

    static final String URL = "jdbc:mysql://localhost:3306/erp_inventory";
    static final String USER = "root";
    static final String PASS = "Ajay@1906";

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Add Product");
                System.out.println("2. Update Stock");
                System.out.println("3. Record Sale");
                System.out.println("4. Inventory Report");
                System.out.println("5. Exit");
                System.out.print("Choose: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addProduct(con, sc);
                    case 2 -> updateStock(con, sc);
                    case 3 -> recordSale(con, sc);
                    case 4 -> inventoryReport(con);
                    case 5 -> System.exit(0);
                    default -> System.out.println("Invalid choice");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addProduct(Connection con, Scanner sc) throws Exception {
        System.out.print("Product Name: ");
        String name = sc.next();
        System.out.print("Price: ");
        double price = Double.parseDouble(sc.next());
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(sc.next());

        String sql = "INSERT INTO products(name, price, quantity) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setDouble(2, price);
        ps.setInt(3, qty);
        ps.executeUpdate();

        System.out.println("Product added.");
    }

    static void updateStock(Connection con, Scanner sc) throws Exception {
        System.out.print("Product ID: ");
        int id = sc.nextInt();
        System.out.print("New Quantity: ");
        int qty = sc.nextInt();

        String sql = "UPDATE products SET quantity=? WHERE product_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, qty);
        ps.setInt(2, id);
        ps.executeUpdate();

        System.out.println("Stock updated.");
    }

    static void recordSale(Connection con, Scanner sc) throws Exception {
        System.out.print("Product ID: ");
        int pid = sc.nextInt();
        System.out.print("Quantity Sold: ");
        int qty = sc.nextInt();

        String saleSQL =
                "INSERT INTO sales(product_id, quantity, sale_date) VALUES (?, ?, CURDATE())";
        PreparedStatement ps = con.prepareStatement(saleSQL);
        ps.setInt(1, pid);
        ps.setInt(2, qty);
        ps.executeUpdate();

        String updateStock =
                "UPDATE products SET quantity = quantity - ? WHERE product_id = ?";
        PreparedStatement ps2 = con.prepareStatement(updateStock);
        ps2.setInt(1, qty);
        ps2.setInt(2, pid);
        ps2.executeUpdate();

        System.out.println("Sale recorded.");
    }

    static void inventoryReport(Connection con) throws Exception {
        String sql = "SELECT product_id, name, quantity FROM products";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\nInventory Report:");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("product_id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getInt("quantity")
            );
        }
    }
}
