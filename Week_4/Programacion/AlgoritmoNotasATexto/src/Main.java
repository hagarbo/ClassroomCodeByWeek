import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner myscanner = new Scanner(System.in);
        System.out.println("Introduzca una nota numerica. Pulse S para salir:");
        try {

            int nextInput = myscanner.nextInt();
            int notaMayor = 0;
            String valorNota = "Suspenso";
            while (true) {
                switch (nextInput) {
                    case 10:
                        System.out.println(nextInput + " es Matricula de Honor");
                        notaMayor =  nextInput;
                        valorNota = "Matricula de Honor";
                        break;
                    case 9:
                        System.out.println(nextInput + " es Sobresaliente");
                        if (notaMayor <  nextInput) {
                            notaMayor = nextInput;
                            valorNota = "Sobresaliente";
                            break;
                        }
                    case 8:
                    case 7:
                        System.out.println(nextInput + " es Notable");
                        if (notaMayor <  nextInput) {
                            notaMayor =  nextInput;
                            valorNota = "Notable";
                            break;
                        }
                    case 6:
                    case 5:
                        System.out.println(nextInput + " es Aprobado");
                        if (notaMayor <  nextInput) {
                            notaMayor =  nextInput;
                            valorNota = "Aprobado";
                            break;
                        }
                    default:
                        System.out.println(nextInput + " es Suspenso");
                        if (notaMayor <  nextInput) {
                            notaMayor =  nextInput;
                            valorNota = "Suspenso";
                            break;
                        }
                }
                System.out.println("Introduzca la siguiente nota:");
                nextInput = myscanner.next();
            }
            System.out.println("La nota mas alta es: "+notaMayor+"->"+valorNota);
        } catch (InputMismatchException e){
            System.out.println("Introduzca una nota numerica. Pulse S para salir:");
            myscanner.next();
        }

    }
}