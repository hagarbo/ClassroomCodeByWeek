import java.util.Arrays;

public class LuckyNumber {

    /*
     * public static int luckyNumber(String date) {
     * String[] values = date.split("-");
     * int suma = 0;
     * while (values.length > 1) {
     * suma = 0;
     * for (String n : values) {
     * suma += Integer.parseInt(n);
     * }
     * values = String.valueOf(suma).split("");
     * }
     * return suma;
     * }
     */

    public static int luckyNumber(String date) {
        String[] values = date.split("-");
        return reduceToOneDigit(values);
    }

    private static int reduceToOneDigit(String[] values) {
        int suma = Arrays.stream(values).mapToInt(e -> Integer.parseInt(e)).sum();
        String[] split = String.valueOf(suma).split("");
        return (split.length == 1) ? suma : reduceToOneDigit(split);
    }

    public static void main(String[] args) {
        System.out.println(luckyNumber("16-08-1973"));
    }
}
