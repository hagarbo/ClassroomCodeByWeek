import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

public class Alquiler {

    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fecha;
    private int dias;

    public Alquiler(Cliente cliente, Vehiculo vehiculo, LocalDate fecha, int dias) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.dias = dias;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Alquiler:\n" + cliente.toString() + "\n" + vehiculo.toString() + "\nFecha Alquiler: "
                + fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "  Dias: " + dias;
    }

}
