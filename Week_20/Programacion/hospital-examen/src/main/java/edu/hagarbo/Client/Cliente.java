package edu.hagarbo.Client;

import java.util.Scanner;

import edu.hagarbo.Model.HospitalServicio;
import edu.hagarbo.Model.IHospitalServicio;

public class Cliente {
    private static final String[] MENU_PRINCIPAL = {
            "1.-",
            "2.-",
            "3.-",
            "4.-",
            "5.-",
            "6.-",
            "0.-"
    };

    private IHospitalServicio hospitalServicio;
    private Scanner myScanner;

    public Cliente() {
        this.hospitalServicio = new HospitalServicio();
        this.myScanner = new Scanner(System.in);
    }

    private void mostrarMenu(String... opciones) {
        System.out.println("**************************");
        for (String opcion : opciones) {
            System.out.println(opcion);
        }
        System.out.println("**************************");
    }

    private int leerOpcion(int maxOpciones) {
        int opcion = -1;
        do {
            System.out.println("**** ELIJA UNA OPCION VALIDA: ****");
            opcion = this.myScanner.nextInt();
        } while (opcion < 0 || opcion > maxOpciones - 1);
        this.myScanner.nextLine();
        return opcion;
    }

    public void run() {
        this.hospitalServicio.cargarDatos();

        /*
         * boolean exit = false;
         * int opcion;
         * do {
         * mostrarMenu(MENU_PRINCIPAL);
         * opcion = leerOpcion(MENU_PRINCIPAL.length);
         * switch (opcion) {
         * case 1:
         * 
         * break;
         * 
         * default:
         * exit = true;
         * break;
         * }
         * 
         * } while (!exit);
         */
    }
}
