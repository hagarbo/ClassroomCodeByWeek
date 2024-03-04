package edu.hagarbo.Util;

public class Validador {

    // private Exception myException = null;
    private Validador instance = null;

    private Validador() {
    }

    public Validador getInstance() {
        if (this.instance == null)
            this.instance = new Validador();
        return this.instance;
    }

}
