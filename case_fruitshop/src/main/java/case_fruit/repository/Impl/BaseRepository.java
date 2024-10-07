package case_fruit.repository.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/case_module3";
    private static final String USER = "root";
    private static final String PASSWORD = "codegym";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
        return connection;
    }
}