package edu.hagarbo.Entities;

import java.time.LocalDate;

public class Registro {

    private LocalDate fechaIngreso;
    private LocalDate fechaAlta;
    private AreaSanitaria area;

    public Registro() {
        this.fechaIngreso = LocalDate.now();
        this.fechaAlta = null;
        this.area = null;
    }

    public Registro(LocalDate fechaIngreso, LocalDate fechaAlta, AreaSanitaria area) {
        this.fechaIngreso = fechaIngreso;
        this.fechaAlta = fechaAlta;
        this.area = area;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public AreaSanitaria getArea() {
        return area;
    }

    public void setArea(AreaSanitaria area) {
        this.area = area;
    }

}
