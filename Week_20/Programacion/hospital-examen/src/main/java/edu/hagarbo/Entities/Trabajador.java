package edu.hagarbo.Entities;

import java.time.LocalDate;

public class Trabajador extends Persona {

    private LocalDate fechaIncorporacion;
    private AreaSanitaria area;
    private String cargo;
    private double salario;

    public Trabajador() {
        super();
        this.fechaIncorporacion = LocalDate.now();
        this.area = new AreaSanitaria();
        this.cargo = "";
        this.salario = 0.0;
    }

    public Trabajador(String dni, String nombre, int edad, String direccion, LocalDate fechaIncorporacion,
            AreaSanitaria area, String cargo, double salario) {
        super(dni, nombre, edad, direccion);
        this.fechaIncorporacion = fechaIncorporacion;
        this.area = area;
        this.cargo = cargo;
        this.salario = salario;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public AreaSanitaria getArea() {
        return area;
    }

    public void setArea(AreaSanitaria area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public double coste() {
        return (this.salario * 14) * 1.05;
    }

}
