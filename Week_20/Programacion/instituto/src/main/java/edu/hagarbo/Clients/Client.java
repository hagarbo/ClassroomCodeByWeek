package edu.hagarbo.Clients;

import java.util.InputMismatchException;
import java.util.Scanner;

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

    public void getStarted() {
        this.scanner = new Scanner(System.in);

        do {
            mostrarMenu();
        } while (true);
    }

}
