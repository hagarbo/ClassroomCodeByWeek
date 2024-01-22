import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) throws Exception {
        Cliente cliente = new Cliente("55555555H", "Pepe", "Gotera");
        Vehiculo vehiculo = new Furgoneta("8765-gjh", "Citröen", "c15", "verde", "54€/dia", 500, 3000);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Alquiler alquiler = new Alquiler(cliente, vehiculo, LocalDate.parse("01/02/1985", dtf), 15);
        System.out.println(alquiler.toString());
    }
}
