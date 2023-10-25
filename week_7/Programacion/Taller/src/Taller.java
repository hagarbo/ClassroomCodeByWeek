import java.util.ArrayList;

public class Taller {

    public static void main(String[] args) throws Exception {

        ArrayList<Vehiculo> datosTaller = new ArrayList<Vehiculo>();
        Coche nuevoCoche = new Coche("Ford", 4, "gasolina", 5, 5, "4567-BFA");
        Bicicleta nuevaBicicleta = new Bicicleta("BH", 2, "electrico", 8);
        Motocicleta nuevaMotocicleta = new Motocicleta("Aprilia", 2, "diesel", 9, "3333-JHB");

        datosTaller.add(nuevaBicicleta);
        datosTaller.add(nuevaMotocicleta);
        datosTaller.add(nuevoCoche);

        System.out.println("DATOS DE LOS VEHICULOS:\n");
        for (Vehiculo vehiculo : datosTaller) {
            System.out.printf("Vehiculo: %d // Marca: %s // Motor: %s // Horas: %.2f // Importe: %.2f euros\n\n",
                    datosTaller.indexOf(vehiculo), vehiculo.getMarca(), vehiculo.getMotor(), vehiculo.reparar(),
                    vehiculo.cobrar(vehiculo.reparar()));
        }
    }
}
