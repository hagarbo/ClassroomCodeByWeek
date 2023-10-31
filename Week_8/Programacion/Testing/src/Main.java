public class Main {

    static final char[] VOCALES = { 'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú' };

    public static int checkWordLength(String word) {
        return word.length();
    }

    public static int NumOfVowels(String word) {
        char[] caracteres = word.toCharArray();
        int numVocales = 0;
        for (char letra : caracteres) {
            for (char vocal : VOCALES) {
                if (Character.toLowerCase(letra) == vocal)
                    numVocales++;
            }
        }
        return numVocales;
    }

    public static int checkNumberOfPrimes(int[] numbers) {
        int numPrimos = 0;
        for (int i : numbers) {
            if (isPrime(i))
                numPrimos++;
        }
        return numPrimos;
    }

    public static boolean isPrime(int i) {
        if (i == 1)
            return false;

        for (int j = 2; j < i; j++) {
            if (i % j == 0)
                return false;
        }
        return true;
    }

    public static boolean isIdentityMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    if (matrix[i][j] != 1)
                        return false;
                } else {
                    if (matrix[i][j] != 0)
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        /*
         * System.out.println(isPrime(2));
         * System.out.println(isPrime(3));
         * System.out.println(isPrime(4));
         * System.out.println(isPrime(99));
         * int[][] matrix = new int[5][5];
         * 
         * for (int i = 0; i < 5; i++) {
         * for (int j = 0; j < 5; j++) {
         * matrix[i][j] = (i == j) ? 1 : 2;
         * }
         * 
         * }
         * System.out.println(isIdentityMatrix(matrix));
         */
    }
}
