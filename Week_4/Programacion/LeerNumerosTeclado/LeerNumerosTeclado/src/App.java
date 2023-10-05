import java.util.Scanner;

public class App {

    private static final String REQUEST_MESSAGE = "Introduzca un numero:";
    private static final int MAX_INPUTS = 5;

    public static void main(String[] args) throws Exception {

        Scanner myScanner = new Scanner(System.in);

        int[] inputArray = new int[MAX_INPUTS];
        for (int i = 0; i < MAX_INPUTS; i++) {
            System.out.println(REQUEST_MESSAGE);
            inputArray[i] = myScanner.nextInt();
        }

        String negativePrint = "[";
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < 0)
                negativePrint += inputArray[i] + ",";
        }
        negativePrint += "]";

        System.out.println("Los negativos son " + negativePrint);

        String reverseString = "";
        for (int i = 0; i < inputArray.length; i++) {
            reverseString = inputArray[i] + "," + reverseString;
        }
        reverseString.substring(0, reverseString.length() - 1);
        System.out.println("Los numeros introducidos al reves son:" + reverseString);

    }
}
