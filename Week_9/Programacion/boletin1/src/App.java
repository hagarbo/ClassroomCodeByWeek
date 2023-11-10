import java.util.ArrayList;
import java.util.Scanner;

public class App {

    /*
     * Realiza un programa con una variable entera t la cual contiene un tiempo
     * en segundos y queremos conocer este tiempo pero expresado en horas, minutos
     * y segundos
     */
    public static String secondsToHMS(int t) {
        int horas = Math.floorDiv(t, 60 * 60);
        int minutos = Math.floorDiv(t % (60 * 60), 60);
        int segundos = t - (horas * 60 * 60) - (minutos * 60);
        return horas + " Horas, " + minutos + " Minutos, " + segundos + " Segundos";
    }

    final static int[] billetes = { 200, 100, 50, 20, 10, 5 };

    public static String theMoney(double euros) {
        String resultado = "";
        double resto = euros;
        for (int billete : billetes) {
            int numBilletes = (int) Math.floor(resto / billete);
            if (numBilletes > 0) {
                resto = resto - numBilletes * billete;
                resultado += numBilletes + " billete(s) de " + billete + "\n";
            }
        }
        resultado += "Sobran " + (int) Math.floor(resto) + " euros";
        return resultado;
    }

    final static int[] puertas = new int[101];

    public static void initialize() {
        int winnner = (int) (Math.random() * 100);
        puertas[winnner] = 1;
    }

    public static int winnner() {
        for (int i = 1; i < puertas.length; i++) {
            if (puertas[i] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(secondsToHMS(20000));
        System.out.println(theMoney(5543.0));

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Elije una puerta del 1 al 100:");
        int choice = 0;
        choice = myScanner.nextInt();
        myScanner.nextLine();

        initialize();
        int otraPuerta = winnner();
        while ((otraPuerta == choice)) {
            otraPuerta = (int) Math.random() * 100;
        }
        System.out.println("El premio esta en la puerta " + choice + " o en la puerta " + otraPuerta);
        System.out.println("Quieres mantener tu eleccion?(s/n)");
        if (myScanner.nextLine().equals("s")) {
            System.out.println((choice == winnner()) ? "Enhorabuena, has ganado!!" : "Lo siento, has perdido");
        } else {
            System.out.println(
                    (otraPuerta == winnner()) ? "Enhorabuena, has ganado!!" : "Lo siento, has perdido");
        }
    }
}
