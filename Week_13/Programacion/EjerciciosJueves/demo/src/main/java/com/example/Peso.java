package com.example;

public class Peso {

    private final static String ONZA = "Oz";
    private final static String LIBRA = "Lb";
    private final static String LINGOTE = "Li";
    private final static String PENIQUE = "P";
    private final static String KILO = "K";
    private final static String GRAMO = "G";
    private final static String QUINTAL = "Q";

    private final static double ONZA_KILO = 0.02835;
    private final static double LIBRA_KILO = 0.453;
    private final static double LINGOTE_KILO = 14.59;
    private final static double PENIQUE_KILO = 0.00155;
    private final static double GRAMO_KILO = 0.001;
    private final static double QUINTAL_KILO = 43.3;

    private double peso; // En Kg

    public Peso(double peso, String medida) {
        this.peso = this.pesoAKilos(peso, medida);
    }

    private double pesoAKilos(double peso, String medida) {
        if (medida.equals(KILO))
            return peso;
        if (medida.equals(ONZA))
            return peso * ONZA_KILO;
        if (medida.equals(LIBRA))
            return peso * LIBRA_KILO;
        if (medida.equals(GRAMO))
            return peso * GRAMO_KILO;
        if (medida.equals(QUINTAL))
            return peso * QUINTAL_KILO;
        if (medida.equals(LINGOTE))
            return peso * LINGOTE_KILO;
        if (medida.equals(PENIQUE))
            return peso * PENIQUE_KILO;
        return 0.0;
    }

    public double getLibras() {
        return this.peso / LIBRA_KILO;
    }

    public double getLingotes() {
        return this.peso / LINGOTE_KILO;
    }

    public double getPeso(String medida) {
        if (medida.equals(KILO))
            return this.peso;
        if (medida.equals(ONZA))
            return this.peso / ONZA_KILO;
        if (medida.equals(LIBRA))
            return this.peso / LIBRA_KILO;
        if (medida.equals(GRAMO))
            return this.peso / GRAMO_KILO;
        if (medida.equals(QUINTAL))
            return this.peso / QUINTAL_KILO;
        if (medida.equals(LINGOTE))
            return this.peso / LINGOTE_KILO;
        if (medida.equals(PENIQUE))
            return this.peso / PENIQUE_KILO;
        return 0.0;
    }

}
