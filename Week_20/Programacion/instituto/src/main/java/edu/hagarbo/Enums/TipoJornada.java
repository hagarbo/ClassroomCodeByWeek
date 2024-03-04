package edu.hagarbo.Enums;

public enum TipoJornada {

    COMPLETA("Completa"), PARCIAL("Parcial");

    private String nombre;

    private TipoJornada(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

}
