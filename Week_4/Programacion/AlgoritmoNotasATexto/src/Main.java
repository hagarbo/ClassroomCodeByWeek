import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String FIN_DE_PROGRAMA = "S";
        final String NOTA_SUSPENSO = "Suspenso";
        final String NOTA_APROBADO = "Aprobado";
        final String NOTA_NOTABLE = "Notable";
        final String NOTA_SOBRESALIENTE = "Sobresaliente";
        final String NOTA_MATRICULA = "Matricula de Honor";


        Scanner myscanner = new Scanner(System.in);
        System.out.println("Introduzca una nota numerica. Pulse S para salir:");


            String nextInput = myscanner.nextLine();
            int notaMaxima = 0;
            String notaValor = "Suspenso";
            int notaContador = 0;
            while (!nextInput.equals(FIN_DE_PROGRAMA)){
                try {
                    int nextInt = Integer.parseInt(nextInput);
                    notaContador++;
                    if (nextInt>=0 && nextInt<5) {
                        System.out.println("La nota "+nextInt+" es "+NOTA_SUSPENSO);
                        if (notaMaxima<nextInt){
                            notaMaxima = nextInt;
                            notaValor = NOTA_SUSPENSO;
                        }
                    } else if (nextInt>=5 && nextInt<7) {
                        System.out.println("La nota "+nextInt+" es "+NOTA_APROBADO);
                        if (notaMaxima<nextInt){
                            notaMaxima = nextInt;
                            notaValor = NOTA_APROBADO;
                        }
                    } else if (nextInt>=7&&nextInt<9) {
                        System.out.println("La nota "+nextInt+" es "+NOTA_NOTABLE);
                        if (notaMaxima<nextInt){
                            notaMaxima = nextInt;
                            notaValor = NOTA_NOTABLE;
                        }
                    } else if (nextInt==9) {
                        System.out.println("La nota "+nextInt+" es "+NOTA_SOBRESALIENTE);
                        if (notaMaxima<nextInt){
                            notaMaxima = nextInt;
                            notaValor = NOTA_SOBRESALIENTE;
                        }
                    } else if (nextInt==10) {
                        System.out.println("La nota "+nextInt+" es "+NOTA_MATRICULA);
                        if (notaMaxima<nextInt){
                            notaMaxima = nextInt;
                            notaValor = NOTA_MATRICULA;
                        }
                    } else {
                        System.out.println("Nota fuera del rango(1-10)");
                    }
                }
                catch (NumberFormatException e){
                    System.out.println(e+" Introduzca una nota numerica. Pulse S para salir:");
                }
                System.out.println("Introduzca una nota numerica. Pulse S para salir:");
                nextInput = myscanner.nextLine();
            }

            if (notaContador!=0)
                System.out.println("La nota mas alta es: "+notaMaxima+"->"+notaValor);
            else System.out.println("No se han introducido notas");




    }
}