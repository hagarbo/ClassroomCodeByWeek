package edu.hagarbo.xmlfiles;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Almacen")
@XmlType(propOrder = { "CIF", "nombre", "ubicacion", "productos" })
public class Almacen {

    private String nombre;
    private String CIF;
    private String ubicacion;
    private List<Producto> productos;

    public Almacen() {
        this.productos = new ArrayList<>();
    }

    public Almacen(String nombre, String cIF, String ubicacion) {
        this.nombre = nombre;
        CIF = cIF;
        this.ubicacion = ubicacion;
        this.productos = new ArrayList<>();
    }

    @XmlElement(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String cIF) {
        CIF = cIF;
    }

    @XmlElement(name = "Direccion")
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @XmlElementWrapper(name = "Productos")
    @XmlElement(name = "Producto")
    public List<Producto> getProductos() {
        return productos;
    }

    public void addProduct(Producto producto) {
        this.productos.add(producto);
    }

    @Override
    public String toString() {
        StringBuilder salida = new StringBuilder();
        salida.append("Almacen [nombre=" + nombre + ", CIF=" + CIF + ", ubicacion=" + ubicacion + "]\n");
        this.productos.forEach(producto -> salida.append(producto.toString()));
        return salida.toString();
    }
}
