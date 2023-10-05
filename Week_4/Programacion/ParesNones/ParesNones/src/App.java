import java.util.Scanner;

public class App {

    private static final String EXIT_CODE = "N";

    private void round() {

    }

    public static void main(String[] args) throws Exception {

        Scanner myScanner = new Scanner(System.in);

        String nextInput = myScanner.nextLine();

        while (!nextInput.equalsIgnoreCase(EXIT_CODE)) {
            System.out.println("<Para elegir pares pulsa 1>, <Para elegir nones pulsa 2>");

        }
    }
}
