/*  Crear 20 números random. Depspués contar de esos 20 números cuantos pares e impares hay.
	El programa creará 2 arrays, uno de pares y otro de impares con el tamaño correcto en
	base al número de pares e impares que haya en esos 20 números random.
	Por último, imprimir por pantalla estos 2 arrays. */

public class Ejercicio2 {

    private static final int MAX_NUMEROS = 20;
    private static final int MAX_RANDOM = 200;

    public static void main(String[] args) {

        Util util = new Util();
        int[] numeros = util.arrayRNG(MAX_NUMEROS, MAX_RANDOM);
        int pares = 0, impares = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0)
                pares++;
            else
                impares++;
        }

        int[] arrayPares = new int[pares];
        int[] arrayImpares = new int[impares];

        int paresIndex = 0, imparesIndex = 0;
        for (int element : numeros) {
            if (element % 2 == 0) {
                arrayPares[paresIndex] = element;
                paresIndex++;
            } else {
                arrayImpares[imparesIndex] = element;
                imparesIndex++;
            }
        }

        System.out.println("ARRAY INICIAL");
        System.out.println(util.arrayToString(numeros));
        System.out.println("ARRAY PARES");
        System.out.println(util.arrayToString(arrayPares));
        System.out.println("ARRAY IMPARES");
        System.out.println(util.arrayToString(arrayImpares));
    }

}
