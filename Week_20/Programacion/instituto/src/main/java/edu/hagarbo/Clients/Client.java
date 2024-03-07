package edu.hagarbo.Clients;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import edu.hagarbo.Entities.Alumno;
import edu.hagarbo.Entities.Profesor;
import edu.hagarbo.Entities.Miembro;
import edu.hagarbo.Enums.TipoJornada;
import edu.hagarbo.Enums.TipoValidacion;
import edu.hagarbo.Exceptions.DataInputException;
import edu.hagarbo.Util.Validador;

public class Client {

    private Scanner scanner;
    private ArrayList<Miembro> miembros = new ArrayList<>();
    // private ArrayList<Alumno> alumnos = new ArrayList<>();

    private void mostrarMenu() {
        System.out.println("***************************************");
        System.out.println("<<<< Elija una opcion: >>>>");
        System.out.println("1.- Listado de Alumnos");
        System.out.println("2.- Alta de miembro");
        System.out.println("3.- Baja de miembro");
        System.out.println("4.- Consulta sobre miembro");
        System.out.println("5.- Nota media del instituto");
        System.out.println("6.- Edad media de los profesores");
        System.out.println("7.- Salario medio de los profesores");
        System.out.println("0.- Salir");
        System.out.println("***************************************");
    }

    private String leerDatoConValidacion(Validador validador, String mensaje) {
        do {
            System.out.println(mensaje);
            try {
                String input = this.scanner.nextLine();
                validador.validar(input);
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private String leerDatoSinValidacion(String mensaje) {
        System.out.println(mensaje);
        return this.scanner.nextLine();
    }

    private void init() {
        this.scanner = new Scanner(System.in);

        this.miembros.add(new Alumno("77665544A", "Jose Ramon Gayoso", 23, "Calle Aragon", LocalDate.of(2021, 9, 1),
                "DAW", 8.45, 1200));
        this.miembros.add(new Alumno("47655544G", "Antonia Garrido", 28, "Calle Aragon", LocalDate.of(2022, 9, 1),
                "DAW", 4.3, 1200));
        this.miembros.add(new Alumno("77687544Z", "Maribel Alonso", 33, "Calle Aragon", LocalDate.of(2019, 9, 1),
                "DAW", 6.99, 1200));

        this.miembros.add(new Profesor("77661199C", "Sancho Panza", 42, "Calle Aragon", LocalDate.of(1990, 3, 1),
                TipoJornada.PARCIAL, 20000, "Informatica"));
        this.miembros.add(new Profesor("12345678C", "Andres del Amo", 55, "Calle Aragon", LocalDate.of(1981, 3, 1),
                TipoJornada.PARCIAL, 20000, "Informatica"));
        this.miembros.add(new Profesor("87654321F", "Isabel Arosa", 30, "Calle Aragon", LocalDate.of(2022, 3, 1),
                TipoJornada.PARCIAL, 20000, "Informatica"));

    }

    private void listarMiembros() {
        System.out.println("***************************************");
        System.out.println("LISTADO DE MIEMBROS:");
        System.out.println();
        this.miembros.stream()
                .forEach(miembro -> System.out.println(miembro.toString()));
        System.out.println();
    }

    private void crearMiembro() {
        String opcion = leerDatoConValidacion(
                new Validador(TipoValidacion.OPTION_MIEMBRO, new DataInputException(DataInputException.INVALID_OPTION)),
                "Introduzca una opción:\n1.-Alta de alumno\n2.-Alta de profesor");
        String nombre = leerDatoConValidacion(
                new Validador(TipoValidacion.NOMBRE, new DataInputException(DataInputException.INVALID_NAME)),
                "Introduzca el nombre:");
        String dni = leerDatoConValidacion(
                new Validador(TipoValidacion.DNI, new DataInputException(DataInputException.INVALID_NAME)),
                "Introduzca el DNI(8 numeros y una letra):");
        String fecha = leerDatoConValidacion(
                new Validador(TipoValidacion.FECHA, new DataInputException(DataInputException.INVALID_DATE)),
                "Introduzca la fecha de alta:");
        String edad = leerDatoConValidacion(
                new Validador(TipoValidacion.EDAD, new DataInputException(DataInputException.INVALID_AGE)),
                "Introduzca la edad:");
        String direccion = leerDatoSinValidacion("Introduzca la direccion:");

        if (Integer.parseInt(opcion) == 1) // ALUMNO
        {
            String ciclo = leerDatoSinValidacion("Introduzca el ciclo formativo:");
            this.miembros.add(new Alumno(dni, nombre, Integer.parseInt(edad), direccion,
                    LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d/MM/yyyy")), ciclo, 0.0, 1200));
            System.out.println("Alumno añadido CORRECTAMENTE");

        } else // PROFESOR
        {
            String sueldo = leerDatoConValidacion(
                    new Validador(TipoValidacion.SALARIO, new DataInputException(DataInputException.INVALID_SALARIO)),
                    "Introduzca el salario:");
            String especialidad = leerDatoSinValidacion("Introduzca la especialidad:");
            this.miembros
                    .add(new Profesor(dni, nombre, Integer.parseInt(edad), direccion,
                            LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d/MM/yyyy")), TipoJornada.COMPLETA,
                            Double.parseDouble(sueldo), especialidad));
            System.out.println("Profesor añadido CORRECTAMENTE");

        }
    }

    private void borrarMiembro() {
        String dni = leerDatoSinValidacion("Introduzca dni del miembro que desea eliminar:");
        for (Miembro miembro : miembros) {
            if (miembro.getDni().equals(dni)) {
                this.miembros.remove(miembro);
                System.out.println("Miembro BORRADO CORRECTAMENTE");
                return;
            }
        }
        System.out.println("No se ha encontrado ningun miembro con ese dni!!!");
    }

    private void consultarMiembro() {
        String dni = leerDatoSinValidacion("Introduzca dni del miembro que desea consultar:");
        for (Miembro miembro : miembros) {
            if (miembro.getDni().equals(dni)) {
                System.out.println(miembro.toString());
                return;
            }
        }
        System.out.println("No se ha encontrado ningun miembro con ese dni!!!");
    }

    private void calcularMediaAlumnos() {
        double media = this.miembros.stream()
                .filter(e -> e instanceof Alumno)
                .map(Alumno.class::cast).mapToDouble(Alumno::getMedia).average().getAsDouble();
        System.out.println("La media de todos los alumnos es: " + String.format("%.2f", media));
    }

    private void calcularSalarioMedio() {
        double media = this.miembros.stream()
                .filter(e -> e instanceof Profesor)
                .map(Profesor.class::cast).mapToDouble(Profesor::getSueldo).average().getAsDouble();
        System.out.println("El sueldo medio del profesorado es: " + String.format("%.2f", media));
    }

    private void calcularEdadMediaProfesorado() {
        double media = this.miembros.stream()
                .filter(e -> e instanceof Profesor)
                .map(Profesor.class::cast).mapToDouble(Profesor::getEdad).average().getAsDouble();
        System.out.println("La edad del profesorado es: " + String.format("%.2f", media));
    }

    public void getStarted() {
        init();
        String opcionString = "";
        do {
            mostrarMenu();
            opcionString = leerDatoConValidacion(
                    new Validador(TipoValidacion.OPTION, new DataInputException(DataInputException.INVALID_OPTION)),
                    "Introduzca una opción:");
            switch (Integer.parseInt(opcionString)) {
                case 1: // LISTADO DE ALUMNOS
                    listarMiembros();
                    break;
                case 2:
                    crearMiembro();
                    break;
                case 3: // Baja de alumno
                    borrarMiembro();
                    break;
                case 4: // Consulta de alumno
                    consultarMiembro();
                    break;
                case 5:
                    calcularMediaAlumnos();
                    break;
                case 6:
                    calcularEdadMediaProfesorado();
                    break;
                case 7:
                    calcularSalarioMedio();
                    break;
            }

        } while (!opcionString.equals("0"));
    }

}
