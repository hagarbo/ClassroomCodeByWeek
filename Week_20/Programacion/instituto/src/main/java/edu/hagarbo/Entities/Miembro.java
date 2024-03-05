package edu.hagarbo.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Miembro extends Persona {

    private LocalDate fechaIncorporacion = LocalDate.of(1970, 1, 1);

    public Miembro() {
        super();
    }

    public Miembro(String dni, String nombre, int edad, String direccion, LocalDate fechaIncorporacion) {
        super(dni, nombre, edad, direccion);
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    @Override
    public String toString() {
        return super.toString() + "[fechaIncorporacion="
                + getFechaIncorporacion().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "]";
    }

    abstract void aplicarBonificacion();

}
