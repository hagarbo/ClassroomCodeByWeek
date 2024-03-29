package edu.hagarbo.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import edu.hagarbo.Entities.AreaSanitaria;
import edu.hagarbo.Entities.Ingreso;
import edu.hagarbo.Entities.Paciente;
import edu.hagarbo.Entities.Persona;
import edu.hagarbo.Entities.Trabajador;

public class HospitalServicio implements IHospitalServicio {

    private static final String[] AREAS = { "traumatologia", "oftalmologia", "otorrino", "pediatria" };

    private ArrayList<AreaSanitaria> areaSanitarias;
    private ArrayList<Persona> personasHospital;

    public HospitalServicio() {
        this.personasHospital = new ArrayList<>();
        this.areaSanitarias = new ArrayList<>();
    }

    public void cargarDatos() {
        this.crearAreas();
        this.crearPacientes();
        this.crearTrabajadores();
    }

    private void crearAreas() {
        for (String area : AREAS) {
            this.areaSanitarias.add(new AreaSanitaria(area));
        }
    }

    private void crearPacientes() {
        Ingreso ingreso1 = new Ingreso(LocalDate.of(2023, 6, 12), LocalDate.of(2023, 6, 27),
                this.areaSanitarias.get(1));
        Ingreso ingreso2 = new Ingreso(LocalDate.of(2023, 6, 12), LocalDate.of(2023, 6, 18),
                this.areaSanitarias.get(2));
        Ingreso ingreso3 = new Ingreso(LocalDate.of(2023, 6, 12), LocalDate.of(2023, 6, 15),
                this.areaSanitarias.get(3));
        Ingreso ingreso4 = new Ingreso(LocalDate.of(2023, 6, 12), LocalDate.of(2023, 6, 22),
                this.areaSanitarias.get(4));

        Paciente paciente1 = new Paciente("77665544G", "Rosalia Vazquez", 47, "Castellana s/n");
        paciente1.addToHistory(ingreso1);
        paciente1.addToHistory(ingreso4);
        Paciente paciente2 = new Paciente("12345678Z", "Andres Murillo", 25, "Galicia s/n");
        paciente2.addToHistory(ingreso2);
        paciente2.addToHistory(ingreso3);

        this.personasHospital.add(paciente1);
        this.personasHospital.add(paciente2);
    }

    private void crearTrabajadores() {
        Trabajador trabajador1 = new Trabajador("98765432J", "Emiliana Padilla", 35, "Argentina 6",
                LocalDate.of(2012, 7, 31), this.areaSanitarias.get(1), "Traumatologo", 2300);
        Trabajador trabajador2 = new Trabajador("85432697I", "Jose Lopez", 48, "Los Mayos 6",
                LocalDate.of(2016, 7, 31), this.areaSanitarias.get(3), "Tecnico", 1400);
        Trabajador trabajador3 = new Trabajador("32145698K", "Antonio Perez", 51, "Colombia 6",
                LocalDate.of(2012, 7, 31), this.areaSanitarias.get(1), "Enfermero", 1800);

        this.personasHospital.add(trabajador3);
        this.personasHospital.add(trabajador2);
        this.personasHospital.add(trabajador1);
    }

    @Override
    public double getAvgSalaryByPosition(String position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAvgSalaryByPosition'");
    }

    @Override
    public double getAvgSalaryByAreaPosition(String position, String area) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAvgSalaryByAreaPosition'");
    }

    @Override
    public Map<String, Double> mediaDiasPorPaciente() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mediaDiasPorPaciente'");
    }

    @Override
    public Map<String, Double> areaConMasCoste() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'areaConMasCoste'");
    }

}
