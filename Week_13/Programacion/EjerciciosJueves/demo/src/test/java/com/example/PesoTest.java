package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PesoTest {
    @Test
    public void testGetLibras() {
        Peso p = new Peso(100, "K");
        assertEquals(220.75, p.getLibras(), 0.5);
        Peso p1 = new Peso(100, "Lb");
        assertEquals(100, p1.getLibras(), 0.5);
    }

    @Test
    public void testGetLingotes() {

    }

    @Test
    public void testGetPeso() {

    }
}
