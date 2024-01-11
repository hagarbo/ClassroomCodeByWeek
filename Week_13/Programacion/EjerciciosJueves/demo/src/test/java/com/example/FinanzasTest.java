package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FinanzasTest {
    @Test
    public void testDolaresToEuros() {
        Finanzas finanzas = new Finanzas();
        assertEquals(136, finanzas.dolaresToEuros(100), 0.5);

        Finanzas finanzas1 = new Finanzas(0.9);
        assertEquals(90, finanzas1.dolaresToEuros(100), 0.5);
    }

    @Test
    public void testEurosToDolares() {
        Finanzas finanzas = new Finanzas();
        assertEquals(100, finanzas.eurosToDolares(136), 0.5);

        Finanzas finanzas1 = new Finanzas(0.9);
        assertEquals(111.11, finanzas1.eurosToDolares(100), 0.5);
    }
}
