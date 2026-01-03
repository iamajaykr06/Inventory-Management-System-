// Copyright (c) 2026 iamajaykr06
// Licensed under the MIT License. See LICENSE in the project root for license information.
import dao.ProductDAO;
import dao.SalesDAO;
import model.Product;

import java.util.Scanner;

public class InventorySystem {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ProductDAO productDAO = new ProductDAO();
        SalesDAO salesDAO = new SalesDAO();

        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. View Inventory");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Record Sale");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();

                    productDAO.addProduct(new Product(name, price, qty));
                }

                case 2 -> {
                    for (Product p : productDAO.getAllProducts()) {
                        System.out.println(
                                p.getId() + " | " +
                                        p.getName() + " | " +
                                        p.getPrice() + " | " +
                                        p.getQuantity()
                        );
                    }
                }

                case 3 -> {
                    System.out.print("Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    String name = sc.nextLine();
                    System.out.print("New Price: ");
                    double price = sc.nextDouble();
                    System.out.print("New Quantity: ");
                    int qty = sc.nextInt();

                    productDAO.updateProduct(new Product(id, name, price, qty));
                }

                case 4 -> {
                    System.out.print("Product ID to delete: ");
                    int id = sc.nextInt();
                    productDAO.deleteProduct(id);
                }

                case 5 -> {
                    System.out.print("Product ID: ");
                    int id = sc.nextInt();
                    System.out.print("Quantity Sold: ");
                    int qty = sc.nextInt();

                    if (productDAO.hasSufficientStock(id, qty)) {
                        salesDAO.recordSale(id, qty);
                    } else {
                        System.out.println("Insufficient stock.");
                    }
                }

                case 6 -> System.exit(0);
            }
        }
    }
}
