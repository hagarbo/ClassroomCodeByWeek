package edu.hagarbo.Clients;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.hagarbo.Exceptions.DataInputException;
import edu.hagarbo.Util.Validador;

public class Client {

    private Scanner scanner;
    private Validador validador;

    private void mostrarMenu() {
        System.out.println("***************************************");
        System.out.println("<<<< Elija una opcion: >>>>");
        System.out.println("0.- Listado de Alumnos");
        System.out.println("1.- Alta de Alumno");
        System.out.println("2.- Baja de Alumno");
        System.out.println("3.- Consulta sobre Alumno");
        System.out.println("4.- Salir");
        System.out.println("***************************************");
    }

    private int leerOpcion() throws DataInputException {
        String input = this.scanner.nextLine();
        this.validador.validarOpcion(input);
        return Integer.parseInt(input);
    }

    public void getStarted() {
        this.scanner = new Scanner(System.in);
        this.validador = Validador.getInstance();
        int opcion = -1;
        do {
            mostrarMenu();
            try {
                opcion = leerOpcion();
                switch (opcion) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            } catch (DataInputException e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 4);
    }

}
