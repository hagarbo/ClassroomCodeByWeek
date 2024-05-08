package edu.hagarbo.jdbcsample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import edu.hagarbo.jdbcsample.Tarea12.DbManager;

public class App 
{
    static Scanner sc = new Scanner(System.in);
    static DbManager dbManager = null;
    public static void main( String[] args )
    {
        int op = 0;

        try {
            dbManager = DbManager.getInstance();
        } catch (SQLException e) {
            System.out.println("Error en la conexion a BD");
        }
        do {
            System.out.println("**** MENU ****\n"
                    + "[1] Insertar Producto\n"
                    + "[2] Listar Productos\n"
                    + "[3] Modificar Producto\n"
                    + "[4] Eliminar Producto\n"
                    + "[5] Exit\n");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    insertar();
                    break;

                case 2:
                    listar();
                    break;
                case 3:
                    modificar();
                    break;
                case 4:
                    eliminar();
                    break;
            }

        } while (op != 5);
    }

    private static void insertar() {
        System.out.println("Dame nombre de producto");
        String nombre = sc.nextLine();
        System.out.println("Dame precio del producto");
        float precio = sc.nextFloat();
        sc = new Scanner(System.in);
        Producto producto = new Producto(nombre, precio);
        try {
            dbManager.getProductoRepository().insert(producto);
        } catch (SQLException e) {
            System.err.println("Se ha producido un error al insertar");
        }
    }

    public static void listar() {
        int cont = 0;

        try {
            ResultSet result = dbManager.getProductoRepository().findAll();

            while (result.next()) {
                cont++;
                System.out.println("Producto " + cont + ": ");
                System.out.println("ID: " + result.getInt("id"));
                System.out.println("Nombre: " + result.getString("nombreProducto"));
                System.out.println("Precio: " + result.getFloat("precio"));
                System.out.println("-----------------------------------------\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void modificar() {

        System.out.println("Dame nombre del producto a modificar");
        String busqueda = sc.nextLine();
        ResultSet res = buscarProducto(busqueda);
        if (res != null) {
            System.out.println("Introduzca nuevo nombre de producto:");
            String nombre = sc.nextLine();
            System.out.println("Introduzca nuevo precio de producto:");
            float precio = sc.nextFloat();
            sc = new Scanner(System.in);
            try {
                Producto producto = new Producto(nombre,precio);
                producto.setId(res.getInt("id"));
                dbManager.getProductoRepository().update(producto);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El producto no se encuentra en la base de datos");
        }
    }

    public static void eliminar() {
        System.out.println("Dame nombre del producto a eliminar");
        String nombre = sc.nextLine();
        ResultSet res = buscarProducto(nombre);
        if (res != null) {
            try {
                dbManager.getProductoRepository().remove(res.getInt("id"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El producto no se encuentra en la base de datos");
        }

    }

    public static ResultSet buscarProducto(String nomProd) {

        try {
            ResultSet result = dbManager.getProductoRepository().findProductByName(nomProd);

            if (result.next()) {
                System.out.println("Los datos del producto buscado son: ");

                System.out.println(" ID Producto: " + result.getInt("id"));
                System.out.println(" Nombre: " + result.getString("nombreProducto"));
                System.out.println(" Precio: " + result.getFloat("precio"));
                System.out.println("-----------------------------------------");

                return result;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
}
