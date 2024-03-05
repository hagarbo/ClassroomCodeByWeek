package edu.hagarbo.Enums;

public enum TipoValidacion {
    NOMBRE("[A-Za-z]{1,20}"), DNI("[0-9]{8}[A-Za-z]"), OPTION("[0-7]"), OPTION_MIEMBRO("[1-2]"), EDAD("[0-9]{1,2}"),
    SALARIO("[0-9]{4,5}"), FECHA("[0-9]{2}/[0-9]{2}/[0-9]{4}");

    private String regexp;

    private TipoValidacion(String regexp) {
        this.regexp = regexp;
    }

    public String getRegExp() {
        return this.regexp;
    }
}
