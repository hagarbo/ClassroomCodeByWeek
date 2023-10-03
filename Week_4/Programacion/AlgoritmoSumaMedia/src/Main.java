import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int siguienteEntero;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Introduzca un numero por teclado:");
        siguienteEntero = myScanner.nextInt();
        int contador = 0;
        int suma = 0;
        while (siguienteEntero!=0){
            suma+=siguienteEntero;
            contador++;
            System.out.println("Introduzca el siguiente numero:");
            siguienteEntero = myScanner.nextInt();
        }
        System.out.println("Has introducido "+contador+" valores.");
        System.out.println("La suma es: "+suma);
        if (contador!=0) System.out.println("La media es: "+ suma/contador);
        else System.out.println("La media es: 0");
    }
}
