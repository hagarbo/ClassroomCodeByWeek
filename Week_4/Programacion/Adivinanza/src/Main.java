import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String ADIVINANZA = "¿Cual es el bicho que pica la panza?";
        final String SOLUCION = "hambre";
        final String PISTA = "No es un bicho de verdad";

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Hola intruso, sabrias decirme: "+ADIVINANZA);
        String siguienteRespuesta = myScanner.next();


        if (!siguienteRespuesta.equalsIgnoreCase(SOLUCION)){
            System.out.println("Has fallado, aquí tienes una pista: "+PISTA);
            siguienteRespuesta = myScanner.next();
            if (siguienteRespuesta.equalsIgnoreCase(SOLUCION)) System.out.println("Enhorabuena!!! Eres listiiiisimo.");
            else System.out.println("Eres mu malo!!");
        } else
            System.out.println("Enhorabuena!!! Eres listiiiisimo.");
    }
}
