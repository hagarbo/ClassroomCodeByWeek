/* Pide 5 números por pantalla y crea un algoritmo que ordene estos números de menor a mayor. */

public class Ejercicio3 {

    private static final int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        Util util = new Util();
        int[] numeros = util.arrayRNG(ARRAY_SIZE, 20);
        System.out.println("ARRAY INICIAL");
        System.out.println(util.arrayToString(numeros));

        numeros = util.burbuja(numeros);
        System.out.println("ARRAY ORDENADO");
        System.out.println(util.arrayToString(numeros));
    }

}
