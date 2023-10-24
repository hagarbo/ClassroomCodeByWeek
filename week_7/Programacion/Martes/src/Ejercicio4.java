/* Crear una tabla bidimensional de tamaño 5x5 y rellenarla de la siguiente forma: la posición T[n,m]
	debe contener n+m. Después se debe mostrar su contenido. */

public class Ejercicio4 {

    private static final int MAX_FILAS = 5;
    private static final int MAX_COLUMNAS = 5;

    public static void main(String[] args) {
        Util util = new Util();

        int[][] matriz = util.matrizSumaFilaColumna(MAX_FILAS, MAX_COLUMNAS);

        System.out.println("MATRIZ RESULTANTE:");
        System.out.println(util.arrayToString(matriz));
    }
}
