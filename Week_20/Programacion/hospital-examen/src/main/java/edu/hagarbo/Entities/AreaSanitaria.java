package edu.hagarbo.Entities;

public class AreaSanitaria {
    private static int ID_AREA = 1;
    private int id;
    private String nombreEspecialidad;

    public AreaSanitaria() {
        this.id = ID_AREA;
        AreaSanitaria.ID_AREA++;
        this.nombreEspecialidad = "";
    }

    public AreaSanitaria(String nombreEspecialidad) {
        this.id = ID_AREA;
        AreaSanitaria.ID_AREA++;
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

}
