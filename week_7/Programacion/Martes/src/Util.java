import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Util {

    public Util() {
    };

    public int[] leerNumerosFichero(String fichero, int maxLecturas) {
        int[] resultado = new int[maxLecturas];
        try {
            File myFile = new File(fichero);
            Scanner myReader = new Scanner(myFile);
            int countLeidos = 0;
            while (myReader.hasNextInt() && countLeidos < maxLecturas) {
                int nextInt = myReader.nextInt();
                resultado[countLeidos] = nextInt;
                countLeidos++;
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return resultado;
    }

    public String arrayToString(int[] array) {
        String result = "[ ";
        for (int i = 0; i < array.length; i++) {
            result += (i == array.length - 1) ? array[i] : array[i] + " , ";
        }
        result += " ]";
        return result;
    }

    public String arrayToString(int[][] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += "[ ";
            for (int j = 0; j < array[i].length; j++) {
                result += (j == array[i].length - 1) ? array[i][j] : array[i][j] + " , ";
            }
            result += " ]\n";
        }

        return result;
    }

    public int[] burbuja(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
        return array;
    }

    public int[] arrayRNG(int size, int maxNumber) {
        int[] numeros = new int[size];
        for (int i = 0; i < size; i++) {
            numeros[i] = (int) (Math.random() * maxNumber);
        }
        return numeros;
    }

    public int[][] matrizSumaFilaColumna(int filas, int columnas) {
        int[][] resultado = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = i + j;
            }
        }
        return resultado;
    }
}
