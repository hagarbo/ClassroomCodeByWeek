package edu.hagarbo.Entities;

import java.time.LocalDate;

import edu.hagarbo.Enums.TipoJornada;

public class Profesor extends Miembro {

    private TipoJornada tipoJornada = TipoJornada.COMPLETA;
    private double sueldo = 0.0;
    private String especialidad = "";

    public Profesor() {
        super();
    }

    public Profesor(String dni, String nombre, int edad, String direccion, LocalDate fechaIncorporacion,
            TipoJornada tipoJornada, double sueldo, String especialidad) {
        super(dni, nombre, edad, direccion, fechaIncorporacion);
        this.tipoJornada = tipoJornada;
        this.sueldo = sueldo;
        this.especialidad = especialidad;
    }

    public TipoJornada getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(TipoJornada tipoJornada) {
        this.tipoJornada = tipoJornada;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + "[tipoJornada=" + tipoJornada.getNombre() + ", sueldo=" + sueldo + ", especialidad="
                + especialidad + "]";
    }

    @Override
    void aplicarBonificacion() {
        LocalDate today = LocalDate.now();
        int years = this.getFechaIncorporacion().until(today).getYears();
        if (years > 3)
            this.sueldo *= 1.15;
    }

}
