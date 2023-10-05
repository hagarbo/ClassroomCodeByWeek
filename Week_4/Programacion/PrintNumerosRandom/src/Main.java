import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] numeros = new int[2];

        for (int i = 0; i < 2; i++) {
            numeros[i] = (int) (Math.random() * 1000 + 1);
        }

        for (int i = 0; i < 2; i++) {
            // System.out.println(numeros[i]+",");
        }

        /*
         * Escribir un algoritmo que genere un numero aleatorio y tratemos de adivinarlo
         * dandole inputs por pantalla hasta que lo encontremos
         * El programa deberá dar pistas de si nos estamos acercando o no diciendo si
         * nuestro input es mayor o menor que el resultado
         */
        final int MAX_RANDOM_NUMBER = 2;
        int randomSolution = (int) (Math.random() * MAX_RANDOM_NUMBER + 1);

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Introduzca un numero del 1 al " + MAX_RANDOM_NUMBER);
        int siguienteIntento = myScanner.nextInt();

        int numIntentos = 1;
        while (siguienteIntento != randomSolution && numIntentos < 10) {

            if (siguienteIntento > randomSolution) {
                System.out.println(
                        "Tu numero es MAYOR que el mio, vuelve a intentarlo.Llevas " + numIntentos + " intentos.");
            } else {
                System.out.println(
                        "Tu numero es MENOR que el mio, vuelve a intentarlo.Llevas " + numIntentos + " intentos.");
            }
            siguienteIntento = myScanner.nextInt();
            numIntentos++;
        }
        if (numIntentos < 10)
            System.out.println("Felicidades, has acertado!!! El numero correcto era " + siguienteIntento
                    + " y has usado " + numIntentos + " intentos hasta encontrarlo");
        else
            System.out.println("Numero de intentos maximo superado, HAS PERDIDO!!!");

    }
}
