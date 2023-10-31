public class Main {

    private static final double DISABILITY_PLUS = 500;

    public static double getSalaryMean(double[] salaries) {
        double media = 0.0;
        for (double salary : salaries) {
            media += salary;
        }
        return media / salaries.length;
    }

    public static double getSalaryMedian(double[] salaries) {
        if (salaries.length % 2 != 0) // numero impar de elementos
            return salaries[salaries.length / 2];
        else // numero par(mitad+mitad+1)/2
            return (salaries[salaries.length / 2] + salaries[salaries.length / 2 - 1]) / 2;
    }

    private static double[] orderSalaries(double[] salaries) {
        double[] orderedSalaries = salaries;
        for (int i = 0; i < orderedSalaries.length - 1; i++) {
            for (int j = i; j < orderedSalaries.length - i; j++) {
                if (orderedSalaries[j] > orderedSalaries[j + 1]) {
                    double swap = orderedSalaries[j];
                    orderedSalaries[j] = orderedSalaries[j + 1];
                    orderedSalaries[j + 1] = orderedSalaries[j];
                }
            }
        }
        return orderedSalaries;
    }

    public static double getPayroll(double salary, int children,
            double percentage, boolean disability) {
        double finalSalary = salary;
        double childrenPercentage = ((children < 3) ? 1 * children : 3 * (children - 2) + 2);
        double finalPercentage = percentage - childrenPercentage;
        finalSalary = salary * (1.0 - (finalPercentage / 100.0));
        if (disability)
            finalSalary += DISABILITY_PLUS;
        return finalSalary;
    }

    public static double[][] transposeMatrix(double[][] matrix) {
        double[][] transposeMatrix = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < transposeMatrix.length; i++) {
            for (int j = 0; j < transposeMatrix.length; j++) {
                transposeMatrix[i][j] = matrix[j][i];
            }
        }
        return transposeMatrix;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getPayroll(25000, 5, 19.0, true));
    }
}
