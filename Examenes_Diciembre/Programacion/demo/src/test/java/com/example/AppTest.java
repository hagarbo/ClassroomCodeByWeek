package com.example;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {

    @Test
    public void getPrimesTest() {
        assertEquals(0, Main.getPrimes(1, 0));
        assertEquals(0, Main.getPrimes(0, 1));
        assertEquals(4, Main.getPrimes(2, 7));
        assertEquals(2, Main.getPrimes(13, 9));
    }

    @Test
    public void getPriceTest() {
        assertEquals(0.0, Main.getPrice(0, 25), 0.0);
        assertEquals(300.0, Main.getPrice(5, 18), 0.0);
        assertEquals(240.0, Main.getPrice(5, 35), 0);
        assertEquals(180.0, Main.getPrice(5, 50), 0);
    }

    @Test
    public void getReverseTest() {
        int[] array = { 5, 6, 7, 9 };
        int[] expected = { 9, 7, 6, 5 };
        assertArrayEquals(expected, Main.getReverse(array));
        int[] array2 = {};
        int[] expected2 = {};
        assertArrayEquals(expected2, Main.getReverse(array2));
    }

    @Test
    public void getMultiplesTest() {
        int[][] matrix = {
                { 0, 4, 5, 6 },
                { 5, 7, 3, 1 },
                { 9, 6, 2, 21 }
        };
        int[] expected = { 0, 4, 6, 6, 2 };
        assertArrayEquals(expected, Main.getMultiples(matrix, 2));
        int[] expected2 = { 0 };
        assertArrayEquals(expected2, Main.getMultiples(matrix, 50));
    }

    @Test
    public void getMaxRowTest() {
        int[][] matrix = {
                { 0, 4, 5, 6 },
                { 5, 7, 3, 1 },
                { 9, 6, 2, 21 }
        };
        int[] expected = { 6, 7, 21 };
        assertArrayEquals(expected, Main.getMaxRow(matrix));
    }
}
