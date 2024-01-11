package com.example;

public class Satelite {

    private double meridiano;
    private double paralelo;
    private double altura;

    public Satelite(double meridiano, double paralelo, double altura) {
        this.meridiano = meridiano;
        this.paralelo = paralelo;
        this.altura = altura;
    }

    public double getMeridiano() {
        return meridiano;
    }

    public void setMeridiano(double meridiano) {
        this.meridiano = meridiano;
    }

    public double getParalelo() {
        return paralelo;
    }

    public void setParalelo(double paralelo) {
        this.paralelo = paralelo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void variaAltura(double desplazamiento) {
        this.altura += desplazamiento;
    }

    public boolean enOrbita() {
        return (this.altura == 0) ? true : false;
    }

    public void variaPosicion(double variap, double variam) {
        this.paralelo += variap;
        this.meridiano += variam;
    }
}
