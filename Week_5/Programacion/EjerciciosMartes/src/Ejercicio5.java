import java.util.Scanner;

public class Ejercicio5 {

    private static final String EXIT_CODE = "0";

    public static void main(String[] args) {

        String nextDNI;
        nextDNI = leerDNI();

        while (!nextDNI.equals(EXIT_CODE)) {
            if (ValidadorDni.validar(nextDNI))
                System.out.println("El DNI: " + nextDNI + " es valido");
            else
                System.out.println("ERROR - DNI invalido");
            nextDNI = leerDNI();
        }
    }

    private static String leerDNI() {
        Scanner myScanner = new Scanner(System.in);
        try {
            System.out.println();
            System.out.println("Introduca un DNI (8 numeros y una letra) --- Pulse 0 para salir");
            return myScanner.nextLine();
        } catch (Exception e) {
            System.out.println("ERROR AL LEER EL DNI --- SALIENDO ---");
            return EXIT_CODE;
        }
    }
}
