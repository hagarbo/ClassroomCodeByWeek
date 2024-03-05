package edu.hagarbo.Entities;

import java.time.LocalDate;

public class Alumno extends Miembro {

    private String ciclo = "";
    private double media = 0.0;
    private double importeMatricula = 0.0;

    public Alumno() {
        super();
    }

    public Alumno(String dni, String nombre, int edad, String direccion, LocalDate fechaIncorporacion, String ciclo,
            double media, double importeMatricula) {
        super(dni, nombre, edad, direccion, fechaIncorporacion);
        this.ciclo = ciclo;
        this.media = media;
        this.importeMatricula = importeMatricula;
        this.aplicarBonificacion();
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getImporteMatricula() {
        return importeMatricula;
    }

    public void setImporteMatricula(double importeMatricula) {
        this.importeMatricula = importeMatricula;
    }

    @Override
    public String toString() {
        return super.toString() + "[ciclo=" + ciclo + ", media=" + media + ", importeMatricula=" + importeMatricula
                + "]";
    }

    @Override
    void aplicarBonificacion() {
        LocalDate today = LocalDate.now();
        int years = this.getFechaIncorporacion().until(today).getYears();
        if (years > 2)
            this.importeMatricula *= 0.9;
    }

}
