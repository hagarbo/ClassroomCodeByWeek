import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {

        Empleado[] tienda = new Empleado[7];
        for (int i = 0; i < tienda.length; i++) {
            int n = (int) (Math.random() * 3);
            if (n == 0)
                tienda[i] = new Directivo("Otto", 400000, LocalDate.of(2000, 4, 15), "puto amo", "Ventas");
            if (n == 1)
                tienda[i] = new Operario("Mortadelo", 25000, LocalDate.of(2005, 6, 20), "35", "libros");
            if (n == 2)
                tienda[i] = new Tecnico("Jose Juan", 15000, LocalDate.of(2023, 3, 3), "tercera");
        }

        for (Empleado empleado : tienda) {
            System.out.println(empleado.toString());
        }
    }
}
