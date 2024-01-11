package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConsumoTest {
    @Test
    public void testConsumoEuros() {
        Consumo c1 = new Consumo(100, 4, 90, 2);
        assertEquals(8, c1.consumoEuros(), 0.0);
    }

    @Test
    public void testConsumoMedio() {
        Consumo c1 = new Consumo(100, 4, 90, 2);
        assertEquals(4, c1.consumoMedio(), 0.0);
    }

    @Test
    public void testGetKms() {
        Consumo c1 = new Consumo(100, 4, 90, 2);
        assertEquals(100, c1.getKms(), 0.0);
    }

    @Test
    public void testGetTiempo() {
        Consumo c1 = new Consumo(100, 4, 90, 2);
        assertEquals(100 / 90, c1.getTiempo(), 0.5);
    }

    @Test
    public void testToString() {
        Consumo c1 = new Consumo(100, 4, 90, 2);
        System.out.println(c1.toString());
    }
}
