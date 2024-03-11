package edu.hagarbo.Client;

import edu.hagarbo.Model.HospitalServicio;
import edu.hagarbo.Model.IHospitalServicio;

public class Cliente {

    private IHospitalServicio hospitalServicio;

    public Cliente() {
        this.hospitalServicio = new HospitalServicio();
    }

    public void run() {
        this.hospitalServicio.cargarDatos();

        boolean exit = false;
        int opcion;
        do {
            opcion = leerOpcion();
            switch (opcion) {
                case 1:

                    break;

                default:
                    exit = true;
                    break;
            }

        } while (!exit);
    }
}
