package edu.hagarbo.jdbcsample.Tarea12;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.hagarbo.jdbcsample.Producto;

public class ProductoRepository extends AbstractRepository{

    private static final String ENTITY_CREATION_QUERY = "CREATE TABLE IF NOT EXISTS PRODUCTOS"
                                                        + "(id INT(3) unsigned zerofill not null auto_increment,"
                                                        + "nombreProducto VARCHAR(30) not null,"
                                                        + "precio float not null,"
                                                        + "Primary Key (id))"
                                                        + "ENGINE INNODB;";
    private static final String ENTITY_TABLE_NAME = "Productos";
    private static final String ENTITY_PK_NAME = "id";

    public ProductoRepository() throws SQLException {
        super(ENTITY_TABLE_NAME,ENTITY_PK_NAME);
        this.createTable();
    }

    private void createTable() throws SQLException {
        this.getStatement().execute(ENTITY_CREATION_QUERY);
    }

    @Override
    public int insert(Object entity) throws SQLException {
        Producto producto = (Producto) entity;
        String query = "INSERT INTO " + ENTITY_TABLE_NAME + " (nombreProducto, precio) VALUES('" + producto.getNombre() + "'," + producto.getPrecio() + ")";
        return this.getStatement().executeUpdate(query);
    }

    @Override
    public int update(Object entity) throws SQLException {
        Producto producto = (Producto) entity;
        String query = "UPDATE " + ENTITY_TABLE_NAME + " set nombreProducto='" + producto.getNombre() + "', precio=" + producto.getPrecio() +" where id = '" + producto.getId() + "';";
        return this.getStatement().executeUpdate(query);
    }

    public ResultSet findProductByName(String name) throws SQLException {
        String query = "SELECT * FROM " + ENTITY_TABLE_NAME + " WHERE nombreProducto = '" + name + "';";
        return this.getStatement().executeQuery(query);
    }
    
}
