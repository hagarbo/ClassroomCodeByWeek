public class Ejercicio1 {

    static boolean numeroEsValido(int n) {
        if ((n % 2 == 0 && n * 5 > 25) ||
                (n % 2 != 0 && n * 3 < 10))
            return true;
        else
            return false;
    }

    static void imprimeInfo(int n) {
        if (numeroEsValido(n))
            System.out.println("El numero cumple los requisistos");
        else
            System.out.println("El numero no cumple los requisitos");
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            int nextInt = Utilities.readIntegerFromTerminal();
            imprimeInfo(nextInt);
        }
    }
}
