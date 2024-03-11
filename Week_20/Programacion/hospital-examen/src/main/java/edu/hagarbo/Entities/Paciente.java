package edu.hagarbo.Entities;

import java.util.HashMap;

public class Paciente extends Persona {
    private int nextId = 1;
    private HashMap<Integer, Registro> historialIngresos;

    public Paciente() {
        super();
        this.historialIngresos = new HashMap<>();
    }

    public Paciente(String dni, String nombre, int edad, String direccion) {
        super(dni, nombre, edad, direccion);
    }

    @Override
    public double coste() {
        double coste = this.historialIngresos.entrySet().stream()
                .mapToDouble(
                        ingreso -> {
                            if (ingreso.getValue().getArea().getNombreEspecialidad().equals("traumatologia"))
                                return ingreso.getValue().getFechaIngreso().until(ingreso.getValue().getFechaAlta())
                                        .getDays() * 700 * 1.02;
                            else
                                return ingreso.getValue().getFechaIngreso().until(ingreso.getValue().getFechaAlta())
                                        .getDays() * 700;
                        })
                .sum();

        return coste;
    }

    public HashMap<Integer, Registro> getHistorialIngresos() {
        return historialIngresos;
    }

    public void setHistorialIngresos(HashMap<Integer, Registro> historialIngresos) {
        this.historialIngresos = historialIngresos;
    }

    public void addToHistory(Registro ingreso) {
        this.historialIngresos.put(this.nextId, ingreso);
        this.nextId++;
    }

}
