package edu.hagarbo.Util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import edu.hagarbo.Exceptions.DataInputException;

public class Validador {

    // private Exception myException = null;
    private static Validador instance = null;

    private Validador() {
    }

    public static Validador getInstance() {
        if (instance == null)
            instance = new Validador();
        return instance;
    }

    public boolean validarOpcion(String opcion) throws DataInputException {
        if (!opcion.matches("[0-4]"))
            throw new DataInputException(DataInputException.INVALID_OPTION);
        return true;
    }

    public boolean validarNombre(String nombre) throws DataInputException {
        if (!nombre.matches("[A-Za-z]{1,20}"))
            throw new DataInputException(DataInputException.INVALID_NAME);
        return true;
    }

    public boolean validarDni(String dni) throws DataInputException {
        if (!dni.matches("[0-9]{8}[A-Za-z]"))
            throw new DataInputException(DataInputException.INVALID_DNI);
        return true;
    }

    public boolean validarEdad(String edad) throws DataInputException {
        if (!edad.matches("[0-9]{1,2}"))
            throw new DataInputException(DataInputException.INVALID_AGE);
        return true;
    }

    public boolean validarSalario(String salario) throws DataInputException {
        if (!salario.matches("[0-9]{4,5}"))
            throw new DataInputException(DataInputException.INVALID_SALARIO);
        return true;
    }

    public boolean validarFecha(String fecha) throws DataInputException {
        try {
            LocalDate.parse(fecha);
        } catch (DateTimeParseException e) {
            throw new DataInputException(DataInputException.INVALID_DATE);
        }
        return true;
    }

}
