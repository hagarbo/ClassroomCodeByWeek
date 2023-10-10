import java.util.Scanner;

public class Ejercicio123 {

    static int contadorPares = 0; // Modificacion ejercicio 3

    static int readIntegerFromTerminal() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Introduzca un numero:");
        while (!myScanner.hasNextInt()) {
            System.out.println("Error:Numero invalido");
            System.out.println("Introduzca un numero:");
            myScanner.next();
        }
        return myScanner.nextInt();
    }

    static void printBetween(int x, int y) {
        String buffer = "[";
        // Modificacion para el ejercicio 2: Imprimir solo los impares
        /*
         * int start = (x % 2 == 0) ? x + 1 : x + 2;
         * int end = (y % 2 == 0) ? y - 1 : y - 2;
         * for (int i = start; i <= end; i += 2) {
         * buffer += i + ",";
         * }
         */
        for (int i = x + 1; i < y; i++) {
            buffer += i + ",";
            if (i % 2 == 0)
                contadorPares++; // Modificacion ejercicio 3
        }
        buffer = buffer.substring(0, buffer.length() - 1) + "]";
        System.out.println("Numeros entre " + x + " y " + y + ": " + buffer);
    }

    public static void main(String[] args) {

        int firstInt = readIntegerFromTerminal();
        int secondInt = readIntegerFromTerminal();

        while (firstInt != secondInt) {
            if (firstInt < secondInt)
                printBetween(firstInt, secondInt);
            else
                printBetween(secondInt, firstInt);
            firstInt = readIntegerFromTerminal();
            secondInt = readIntegerFromTerminal();
        }

        System.out.println("Se han impreso un total de :" + contadorPares + " numeros pares");
    }

}
