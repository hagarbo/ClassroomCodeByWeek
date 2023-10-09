public class Ejercicio2 {

    static void imprimeFromOneToN(int n) {
        String buffer = "[";
        for (int i = 1; i <= n; i++) {
            buffer += i + ",";
        }
        buffer = buffer.substring(0, buffer.length() - 1);
        if (buffer.length() == 0)
            buffer = "[]";
        else
            buffer += "]";
        System.out.println(buffer);
    }

    public static void main(String[] args) {

        int nextInt = Utilities.readIntegerFromTerminal();
        imprimeFromOneToN(nextInt);
    }
}
