package edu.hagarbo.jdbcsample.Tarea12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenericRepository {
    
    private final String CONN_URL = "jdbc:mariadb://localhost:3306/?user=root&password=";
    private Connection connection = null;
    private Statement statement = null;

    public GenericRepository() throws SQLException {
        this.connection = DriverManager.getConnection(CONN_URL);
        this.statement = this.connection.createStatement();
    }

    public void selectDatabase(String dbName) throws SQLException {
        String query = "USE "+dbName+";";
        this.statement.execute(query);
    }

    public void createDatabase(String dbName) throws SQLException {
        String query = "CREATE DATABASE IF NOT EXISTS "+dbName+";";
        this.statement.execute(query);

    }

    public void createEntity(String creationQuery) throws SQLException {
        this.statement.execute(creationQuery);
    }

    public ResultSet findAll(String entity) throws SQLException {
        String query = "SELECT * FROM " + entity + ";";
        return this.statement.executeQuery(query);
    }

    public ResultSet findById(String entity, int id) throws SQLException {
        String query = "SELECT * FROM " + entity + "WHERE id = " + id + ";";
        return this.statement.executeQuery(query);
    }
    
    public boolean deleteById(String entity, int id) throws SQLException {
        String query = "DELETE FROM " + entity + " WHERE id = " + id + ";";
        return this.statement.execute(query);
    }

    public int insert(String insertQuery) throws SQLException {
        return this.statement.executeUpdate(insertQuery);
    }

    public int update(String updateQuery) throws SQLException {
        return this.statement.executeUpdate(updateQuery);
    }

    public ResultSet customQuery(String query) throws SQLException {
        
    }
    
}
