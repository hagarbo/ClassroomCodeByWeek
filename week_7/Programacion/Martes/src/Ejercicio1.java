/* Crear un programa que lea por teclado una tabla de 10 numeros enteros 
y la desplace una posiocion hacia la derecha: el primero pasa a ser el segundo, 
el segundo pasa a ser el tercero y asi sucesivamente. El ultimo pasa a ser 
el primero */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio1 {

    private static final int MAX_LECTURAS = 10;
    private static final String FICHERO_STRING = "numeros.txt";

    private static int[] desplazarNumeros(int[] array) {
        int[] resultado = new int[array.length];
        for (int i = 0; i < resultado.length; i++) {
            if (i != array.length - 1)
                resultado[i + 1] = array[i];
            else
                resultado[0] = array[i];
        }
        return resultado;
    }

    public static void main(String[] args) throws Exception {

        Util util = new Util();

        int[] numeros = util.leerNumerosFichero(FICHERO_STRING, MAX_LECTURAS);

        int[] numerosDesplazados = desplazarNumeros(numeros);

        System.out.println("ARRAY INICIAL:");
        System.out.println(util.arrayToString(numeros));
        System.out.println("ARRAY DESPLAZADO");
        System.out.println(util.arrayToString(numerosDesplazados));

    }
}
