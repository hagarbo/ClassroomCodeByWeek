package edu.hagarbo.jdbcsample.Tarea12;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class AbstractRepository {

    private Connection connection = null;
    private Statement statement = null;
    private String entityName = null;

    public AbstractRepository(String entityName) throws SQLException {
        this.connection = DbConnector.getConnection();
        this.statement = this.connection.createStatement();
        this.entityName = entityName;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public ResultSet findAll() throws SQLException {
        String query = "SELECT * FROM " + this.entityName + ";";
        return this.statement.executeQuery(query);
    }

    public ResultSet findById(int id) throws SQLException {
        String query = "SELECT * FROM " + this.entityName + "WHERE id = " + id + ";";
        return this.statement.executeQuery(query);
    }
    
    public boolean remove(int id) throws SQLException {
        String query = "DELETE FROM " + this.entityName + " WHERE id = " + id + ";";
        System.out.println(query);
        return this.statement.execute(query);
    }

    public abstract int insert(Object entity) throws SQLException;

    public abstract int update(Object entity) throws SQLException;

    
}
