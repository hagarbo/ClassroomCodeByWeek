package edu.hagarbo.xmlfiles;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "Producto")
@XmlType(propOrder = { "id", "nombre", "marca", "precioSalida", "fechaCaducidad" })
public class Producto {

    private String id;
    private String nombre;
    private String marca;
    private String precioSalida;
    private LocalDate fechaCaducidad;

    public Producto() {

    }

    public Producto(String id, String nombre, String marca, String precioSalida) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precioSalida = precioSalida;
    }

    @XmlElement(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "Marca")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @XmlElement(name = "Precio")
    public String getPrecioSalida() {
        return precioSalida;
    }

    public void setPrecioSalida(String precioSalida) {
        this.precioSalida = precioSalida;
    }

    @XmlElement(name = "Caducidad")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", precioSalida=" + precioSalida
                + "]\n";
    }

}
