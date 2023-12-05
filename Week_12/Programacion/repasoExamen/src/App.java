import java.util.Arrays;

public class App {

    public static int[] getMinColumNum(int[][] matrix) {
        int[] minVector = new int[matrix[0].length];
        int[] column = new int[matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            minVector[i] = getMin(column);
        }
        return minVector;
    }

    public static int[] getMaxNums(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            for (int cell : row) {
                if (cell > 10)
                    count++;
            }
        }

        int[] result = new int[count];
        count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 10) {
                    result[count] = matrix[i][j];
                    count++;
                }
            }
        }

        return result;
    }

    public static int getMax(int[] array) {
        return Arrays.stream(array).max().orElse(-1);
    }

    public static int getMin(int[] array) {
        return Arrays.stream(array).min().orElse(-1);
    }

    public static void main(String[] args) throws Exception {
        int[][] matrix = {
                { 10, 9, 7 },
                { 35, 16, 28 },
                { 0, 1, 2 }
        };

        System.out.println(Arrays.toString(getMinColumNum(matrix)));
        System.out.println(Arrays.toString(getMaxNums(matrix)));
    }
}
