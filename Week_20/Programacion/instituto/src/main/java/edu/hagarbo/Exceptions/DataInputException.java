package edu.hagarbo.Exceptions;

public class DataInputException extends Exception {

    public final static int INVALID_OPTION = 1;
    public final static int INVALID_NAME = 2;
    public final static int INVALID_DATE = 3;
    public final static int INVALID_SALARIO = 4;
    public final static int INVALID_DNI = 5;
    public final static int INVALID_AGE = 6;

    private int errorCode;

    public DataInputException(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        switch (this.errorCode) {
            case 1:
                return "ERROR :: La OPCION elegida no es válida";
            case 2:
                return "ERROR :: El NOMBRE no es valido: solo puede contener letras de la A a la Z";
            case 3:
                return "ERROR :: La FECHA no es valida: Formato valido(dd/mm/yyyy)";
            case 4:
                return "ERROR :: El SUELDO no es valido: maximo 99999";
            case 5:
                return "ERROR :: El DNI no es valido: Formato valido 12345678A";
            case 6:
                return "ERROR :: La EDAD no es valida: maximo 99";
            default:
                return "No se ka pasao";
        }
    }

}
