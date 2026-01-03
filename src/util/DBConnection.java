package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "JDBC:mysql://localhost:3306/erp_inventory";
    private static final String USER = "root";
    private static final String PASS = "Ajay@1906";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
