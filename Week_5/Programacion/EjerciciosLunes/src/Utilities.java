import java.util.Scanner;

public class Utilities {

    public static int readIntegerFromTerminal() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Introduzca un numero:");
        while (!myScanner.hasNextInt()) {
            System.out.println("Error:Numero invalido");
            System.out.println("Introduzca un numero:");
            myScanner.next();
        }
        return myScanner.nextInt();
    }

}
