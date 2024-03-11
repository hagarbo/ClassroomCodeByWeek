package edu.hagarbo.Model;

import java.util.Map;

public interface IHospitalServicio {
    public void cargarDatos();

    public double getAvgSalaryByPosition(String position);

    public double getAvgSalaryByAreaPosition(String position, String area);

    public Map<String, Double> mediaDiasPorPaciente();

    public Map<String, Double> areaConMasCoste();
}
