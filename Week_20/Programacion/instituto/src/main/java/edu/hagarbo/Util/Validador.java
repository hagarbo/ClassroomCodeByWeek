package edu.hagarbo.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import edu.hagarbo.Enums.TipoValidacion;
import edu.hagarbo.Exceptions.DataInputException;

public class Validador {

    // private Exception myException = null;
    private TipoValidacion regexp;
    private DataInputException exception;

    public Validador(TipoValidacion regexp, DataInputException e) {
        this.regexp = regexp;
        this.exception = e;
    }

    public DataInputException getException() {
        return this.exception;
    }

    public boolean validar(String objectToValidate) throws DataInputException {
        if (!objectToValidate.matches(this.regexp.getRegExp()))
            throw this.exception;
        if (this.exception.getErrorCode() == DataInputException.INVALID_DATE) {
            try {
                LocalDate.parse(objectToValidate, DateTimeFormatter.ofPattern("d/MM/yyyy"));
            } catch (DateTimeParseException e) {
                throw new DataInputException(DataInputException.INVALID_DATE);
            }
        }
        return true;
    }

}
