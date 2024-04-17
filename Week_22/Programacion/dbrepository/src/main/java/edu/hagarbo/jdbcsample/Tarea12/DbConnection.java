package edu.hagarbo.jdbcsample.Tarea12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
    
    private static final String CONN_URL = "jdbc:mariadb://localhost:3306/?user=root&password=";
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null) connection = DriverManager.getConnection(CONN_URL);
        return connection;
    }
}
