package com.example;

import java.util.Arrays;

public class Main {

    private static final double PRECIO_MATERIA = 60.0;

    public static int getPrimes(int num1, int num2) {
        int numMenor = (num1 < num2) ? num1 : num2;
        int numMayor = (num1 > num2) ? num1 : num2;

        int count = 0;
        for (int i = numMenor; i <= numMayor; i++) {
            if (esPrimo(i))
                count++;
        }
        return count;
    }

    private static boolean esPrimo(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static double getPrice(int num, int age) {
        double basePrice = PRECIO_MATERIA * num;
        double finalPrice = basePrice * (1.0 - getDiscount(age));
        return finalPrice;
    }

    private static double getDiscount(int age) {
        if (age < 35)
            return 0.0;
        else if (age >= 35 && age < 50)
            return 0.2;
        else
            return 0.4;
    }

    public static int[] getReverse(int[] array) {
        int[] reverseArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            reverseArray[array.length - 1 - i] = array[i];
        }
        return reverseArray;
    }

    public static int[] getMultiples(int[][] matrix, int num) {
        int count = 0;
        int size = numMultiplos(matrix, num);
        int[] multiplos = new int[size];
        for (int[] row : matrix) {
            for (int cell : row) {
                if (cell % num == 0) {
                    multiplos[count] = cell;
                    count++;
                }
            }
        }
        return multiplos;
    }

    private static int numMultiplos(int[][] matrix, int num) {
        int count = 0;
        for (int[] row : matrix) {
            for (int cell : row) {
                if (cell % num == 0)
                    count++;
            }
        }
        return count;
    }

    public static int[] getMaxRow(int[][] matrix) {
        int[] rowMaxNumbers = new int[matrix.length];
        int index = 0;
        for (int[] row : matrix) {
            rowMaxNumbers[index] = getMax(row);
            index++;
        }
        return rowMaxNumbers;
    }

    private static int getMax(int[] vector) {
        int max = Arrays.stream(vector).max().orElse(0);
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 4, 5, 6 },
                { 5, 7, 3, 1 },
                { 9, 6, 2, 21 }
        };
        int[] expected = { 4, 6, 6, 2 };
        System.out.println(Arrays.toString(getMultiples(matrix, 2)));
        System.out.println(Arrays.toString(getMaxRow(matrix)));
    }
}
