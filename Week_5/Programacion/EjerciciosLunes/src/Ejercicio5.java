import java.util.Scanner;

public class Ejercicio5 {

    static final int LIMITE_INFERIOR = 56;
    static final int LIMITE_SUPERIOR = 108;

    public static int leerEntero(String msg) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println(msg);
        while (!myScanner.hasNextInt()) {
            System.out.println(msg);
            myScanner.next();
        }
        return myScanner.nextInt();
    }

    public static void main(String[] args) {

        int input = 0;
        int random = (int) (Math.random() * ((LIMITE_SUPERIOR - LIMITE_INFERIOR + 1) + LIMITE_INFERIOR));

        while (input < 50 || input % 2 == 0) {
            input = leerEntero("Introduce un numero impar mayor que 50:");
        }

        System.out.println("X * " + input + " = " + input * random);

        int intentos = 0;
        while (intentos < 3 && input != random) {
            input = leerEntero("Adivina el valor de X, tienes " + (3 - intentos) + " intentos");
            intentos++;
        }

        if (input == random)
            System.out.println("Enhorabuena, has acertado!!");
        else
            System.out.println("Lo siento, te has quedado sin intentos. El resultado era:" + random);
    }
}
