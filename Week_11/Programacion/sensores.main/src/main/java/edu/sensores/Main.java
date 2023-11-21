package edu.sensores;

import java.util.Arrays;

public class Main {

    public static double getDistance(double speed, double time) {
        return (speed * time) / 2;
    }

    public static boolean isValidCar(double[] sensorProbability) {
        double avg = Arrays.stream(sensorProbability).average().orElse(0);
        return avg <= 10;
    }

    public static double checkObjectWithPatternBlackAndWhite(boolean[][] pattern, boolean[][] object) {
        double diferencias = 0.0;
        int rows = pattern.length;
        int columns = pattern[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (object[i][j] != pattern[i][j])
                    diferencias += 1.0;
            }
        }
        return (diferencias / ((double) rows * (double) columns)) * 100;
    }

    public static double checkObjectWithPatternColour(int[][] pattern, int[][] object) {
        double diferencias = 0.0;
        int rows = pattern.length;
        int columns = pattern[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (Math.abs(object[i][j] - pattern[i][j]) > 10)
                    diferencias += 1.0;
            }
        }
        return (diferencias / ((double) rows * (double) columns)) * 100;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
