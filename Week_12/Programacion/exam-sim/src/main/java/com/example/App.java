package com.example;

import java.util.Arrays;

public class App {

    /**
     * Ejercicios de repaso:
     * 
     * 1. Método countContainWords(String[] phrases, String words) : return int
     * 
     * Este método se le pasa un array de frases y una palabra. Tiene que devolver
     * el número
     * de frases que contiene esa palabra.
     * 
     * Tiempo máximo: 20 min
     */

    public static int countContainWords(String[] phrases, String word) {
        int count = 0;
        for (String phrase : phrases) {
            if (phrase.toUpperCase().contains(word.toUpperCase()))
                count++;
        }
        return count;
    }

    /*
     * 2. Método getFinalNum(int num, double percentage) : return double
     * 
     * Este método recibe como parámetro un número y un porcentaje. El método tiene
     * que devolver un número que será el porcentaje del número dado.
     * Si al realizar la operación el número es inferior a 1000 pero mayor que 100,
     * el número se divide entre 3.
     * Si al realizar la operación el número es inferior a 100 pero mayor que 10, se
     * deja tal cual.
     * Si al realizar la operación el número es menor que 10, se multiplica por 3.
     * 
     * 
     * Tiempo máximo: 35 min
     */

    public static double getFinalNum(int num, double percentage) {
        double result = (num * percentage) / 100.0;
        if (result > 100 && result < 1000)
            return result / 3.0;
        if (result < 10)
            return result * 3.0;
        // else
        return result;
    }

    /*
     * 3. Método getFirstRow(int[][] matrix, int columns) return int[]
     * 
     * Este método se le pasa como parámetro una matriz y el número de columnas que
     * va a tener.
     * Tiene que devolver la primera fila en un array.
     * El número de columnas nos dice que longitud tendrá el array que debemos
     * devolver.
     * 
     * Tiempo máximo: 30 min
     *
     * 
     */

    public static int[] getFirstRow(int[][] matrix, int columns) {
        int[] result = new int[columns];
        for (int i = 0; i < columns; i++) {
            result[i] = matrix[0][i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 5 }, { 0, 3, 4 } };
        System.out.println(Arrays.toString(getFirstRow(matrix, 3)));
        System.out.println(getFinalNum(30, 90.0));
        System.out.println(getFinalNum(300, 90.0));
        System.out.println(getFinalNum(30, 10.0));
        String[] frases = { "Hola que tal", "Ola que ase", "un dos tres cuatro" };
        System.out.println(countContainWords(frases, "ola"));
    }
}
