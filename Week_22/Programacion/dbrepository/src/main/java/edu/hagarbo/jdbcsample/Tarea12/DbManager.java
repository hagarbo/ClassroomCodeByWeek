package edu.hagarbo.jdbcsample.Tarea12;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {

    private static final String DB_NAME = "Almacen";
    private static DbManager INSTANCE = null;
    private Connection Connection = null;
    private Statement statement = null;
    private ProductoRepository productoRepository = null;

    private DbManager() throws SQLException{
        this.Connection = DbConnector.getConnection();
        this.statement = this.Connection.createStatement();

        this.createDatabase();
        this.selectDatabase();

        this.productoRepository = new ProductoRepository();
    }

    public static DbManager getInstance() throws SQLException{
        if (INSTANCE == null)
            INSTANCE = new DbManager();
        return  INSTANCE;
    }

    private void selectDatabase() throws SQLException {
        String query = "USE "+ DB_NAME +";";
        this.statement.execute(query);
    }

    private void createDatabase() throws SQLException {
        String query = "CREATE DATABASE IF NOT EXISTS "+ DB_NAME +";";
        this.statement.execute(query);
    }

    public ProductoRepository getProductoRepository() {
        return productoRepository;
    }
    
}
