package dao;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SalesDAO {

    public void recordSale(int productId, int qty) throws Exception {

        String insertSale =
                "INSERT INTO sales(product_id, quantity, sale_date) VALUES (?, ?, CURDATE())";

        String updateStock =
                "UPDATE products SET quantity = quantity - ? WHERE product_id = ?";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement ps1 = con.prepareStatement(insertSale);
                 PreparedStatement ps2 = con.prepareStatement(updateStock)) {

                ps1.setInt(1, productId);
                ps1.setInt(2, qty);
                ps1.executeUpdate();

                ps2.setInt(1, qty);
                ps2.setInt(2, productId);
                ps2.executeUpdate();

                con.commit();
            } catch (Exception e) {
                con.rollback();
                throw e;
            }
        }
    }
}
