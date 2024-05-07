package edu.hagarbo.jdbcsample.Tarea12;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class AbstractRepository {

    private Connection connection = null;
    private Statement statement = null;
    private String entityName = null;
    private String entityPKName = null;

    protected AbstractRepository(String entityName, String PKName) throws SQLException {
        this.connection = DbConnector.getConnection();
        this.statement = this.connection.createStatement();
        this.entityName = entityName;
        this.entityPKName = PKName;
    }

    protected Statement getStatement() {
        return statement;
    }

    public ResultSet findAll() throws SQLException {
        String query = "SELECT * FROM " + this.entityName + ";";
        return this.statement.executeQuery(query);
    }

    public ResultSet findById(int id) throws SQLException {
        String query = "SELECT * FROM " + this.entityName + "WHERE "+ this.entityPKName +" = " + id + ";";
        return this.statement.executeQuery(query);
    }
    
    public boolean remove(int id) throws SQLException {
        String query = "DELETE FROM " + this.entityName + " WHERE "+ this.entityPKName +" = " + id + ";";
        return this.statement.execute(query);
    }

    public abstract int insert(Object entity) throws SQLException;

    public abstract int update(Object entity) throws SQLException;

    
}
