package com.example;

public class Finanzas {

    private double ratioDE;

    public Finanzas() {
        this(1.36);
    }

    public Finanzas(double ratioDE) {
        this.ratioDE = ratioDE;
    }

    public double getratioDE() {
        return ratioDE;
    }

    public void setratioDE(double ratioDE) {
        this.ratioDE = ratioDE;
    }

    public double dolaresToEuros(double cantidad) {
        return this.ratioDE * cantidad;
    }

    public double eurosToDolares(double cantidad) {
        return cantidad / this.ratioDE;
    }

    @Override
    public String toString() {
        return "Finanzas [ratio $-€=" + ratioDE + "]";
    }

}
