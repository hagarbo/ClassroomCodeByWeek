package edu.hagarbo.jdbcsample.Tarea12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DbConnector {

    private static final String CONN_URL = "jdbc:mariadb://localhost:3306/?user=root&password=";
    private static Connection CONNECTION = null;

    private DbConnector()
    {
    }
    
    public static Connection getConnection() throws SQLException
    {
        if (CONNECTION == null) 
            CONNECTION = DriverManager.getConnection(CONN_URL);

        return CONNECTION;
    }

}
