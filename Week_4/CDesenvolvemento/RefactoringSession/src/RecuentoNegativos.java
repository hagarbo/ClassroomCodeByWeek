import java.util.Scanner;

public class RecuentoNegativos {

    // DEFINICION DE CONSTANTES
    private static final String REQUEST_MESSAGE = "Por favor, introduzca un numero: (Para finalizar, introduzca -999)";
    private static final int EXIT_CODE = -999;

    /*
     * Imprime texto por pantalla en funcion del signo del numero pasado
     * por parametro y del numero de negativos almacenados
     */
    private static void printNumberInfo(int num, int count) {
        System.out.println();
        if (num < 0) {
            System.out.println("El numero " + num + " es negativo. Almacenando...");
        } else if (num > 0) {
            System.out.println("El numero " + num + " es positivo");
        } else {
            System.out.println("Error. El numero introducido no puede ser 0");
        }
        System.out.println("Total de numeros negativos almacenados: " + count);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int nextInt;

        System.out.println(REQUEST_MESSAGE);
        nextInt = myScanner.nextInt();

        int negativeCount = 0;
        while (nextInt != EXIT_CODE) {
            if (nextInt < 0)
                negativeCount++;
            printNumberInfo(nextInt, negativeCount);
            System.out.println(REQUEST_MESSAGE);
            nextInt = myScanner.nextInt();
        }

        System.out.println("El total de numeros negativos introducidos ha sido " + negativeCount);
        System.out.println("---FIN DEL PROGRAMA---");
    }
}
