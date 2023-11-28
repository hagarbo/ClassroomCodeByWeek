package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test_countContainWords() {
        String[] frases = { "Hola que tal", "Ola que ase", "un dos tres cuatro" };
        assertEquals(2, App.countContainWords(frases, "ola"));
        assertEquals(0, App.countContainWords(frases, "cinco"));
    }
}
