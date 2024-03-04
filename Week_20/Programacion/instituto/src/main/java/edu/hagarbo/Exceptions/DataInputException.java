package edu.hagarbo.Exceptions;

public class DataInputException extends Exception {

    final static int INVALID_DNI = 1;
    final static int INVALID_NOMBRE = 2;
    final static int INVALID_EDAD = 3;
    final static int INVALID_SALARIO = 4;

    private int errorCode;

    public DataInputException(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        switch (this.errorCode) {
            case 1:
                return "Los datos del DNI no son validos";
            case 2:
                return "El NOMBRE no es valido: solo puede contener letras de la A a la Z";
            case 3:
                return "La EDAD no es valida: maximo 3 digitos";
            case 4:
                return "El salario no es valido: maximo 5 cifras";
            default:
                return "No se ka pasao";
        }
    }

}
