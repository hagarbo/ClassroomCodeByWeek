package edu.gorilas.yatzi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class YatzyTest {

    /*
     * Chance
     * The player scores the sum of all dice, no matter what they read.
     */
    @Test
    public void test_chance() {
        assertEquals(15, Yatzy.chance(2, 3, 4, 5, 1));
        assertEquals(16, Yatzy.chance(3, 3, 4, 5, 1));
        assertEquals(21, Yatzy.chance(4, 5, 5, 6, 1));
    }

    /*
     * Yatzy
     * If all dice have the same number, the player scores 50 points.
     */
    @Test
    public void test_yatzy() {
        assertEquals(50, Yatzy.yatzy(4, 4, 4, 4, 4));
        assertEquals(50, Yatzy.yatzy(6, 6, 6, 6, 6));
        assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
    }

    /* The player scores the sum of the dice that reads one */
    @Test
    public void test_ones() {
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
        assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
    }

    /* The player scores the sum of the dice that reads two */
    @Test
    public void test_twos() {
        assertEquals(0, Yatzy.twos(1, 1, 1, 1, 1));
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
    }

    /* The player scores the sum of the dice that reads three */
    @Test
    public void test_threes() {
        assertEquals(0, Yatzy.threes(1, 1, 1, 1, 1));
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
    }

    @Test
    public void test_constructor() {
        Yatzy yatzy = new Yatzy(1, 1, 1, 1, 1);
        for (int value : yatzy.dice) {
            assertEquals(1, value);
        }
    }

    /* The player scores the sum of the dice that reads four */
    @Test
    public void test_fours() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(0, new Yatzy(3, 5, 5, 5, 5).fours());
    }

    /* The player scores the sum of the dice that reads five */
    @Test
    public void test_fives() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(0, new Yatzy(4, 3, 2, 6, 1).fives());
    }

    /* The player scores the sum of the dice that reads six */
    @Test
    public void test_sixes() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void test_pair() {
        assertEquals(6, Yatzy.score_pair(3, 4, 3, 5, 6));
        assertEquals(10, Yatzy.score_pair(5, 3, 3, 3, 5));
        assertEquals(12, Yatzy.score_pair(5, 3, 6, 6, 5));
        assertEquals(0, Yatzy.score_pair(1, 2, 3, 4, 5));
    }

    @Test
    public void test_two_pairs() {
        assertEquals(16, Yatzy.two_pair(3, 3, 5, 4, 5));
        assertEquals(6, Yatzy.two_pair(1, 1, 2, 2, 2));
        assertEquals(0, Yatzy.two_pair(1, 1, 2, 3, 4));
        assertEquals(0, Yatzy.two_pair(1, 2, 3, 4, 5));
    }

    @Test
    public void test_three_of_a_kind() {
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 4, 5));
        assertEquals(0, Yatzy.three_of_a_kind(3, 3, 4, 5, 6));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 5));
        assertEquals(0, Yatzy.three_of_a_kind(1, 2, 3, 4, 5));
    }

    @Test
    public void test_four_of_a_kind() {
        assertEquals(8, Yatzy.four_of_a_kind(2, 2, 2, 2, 5));
        assertEquals(0, Yatzy.four_of_a_kind(2, 2, 2, 5, 5));
        assertEquals(8, Yatzy.four_of_a_kind(2, 2, 2, 2, 2));
        assertEquals(0, Yatzy.four_of_a_kind(1, 2, 3, 4, 5));
    }

    @Test
    public void test_small_straight() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
        assertEquals(0, Yatzy.smallStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.smallStraight(1, 3, 4, 5, 5));
        assertEquals(0, Yatzy.smallStraight(6, 6, 6, 6, 6));
        assertEquals(0, Yatzy.smallStraight(1, 2, 3, 4, 6));
    }

    @Test
    public void test_large_straight() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
        assertEquals(0, Yatzy.largeStraight(1, 2, 3, 4, 5));
        assertEquals(0, Yatzy.largeStraight(1, 3, 4, 5, 5));
        assertEquals(0, Yatzy.largeStraight(6, 6, 6, 6, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 3, 4, 6));
    }

    @Test
    public void test_fullHouse() {
        assertEquals(8, Yatzy.fullHouse(1, 1, 2, 2, 2));
        assertEquals(0, Yatzy.fullHouse(2, 2, 3, 3, 4));
        assertEquals(0, Yatzy.fullHouse(4, 4, 4, 4, 4));
        assertEquals(0, Yatzy.fullHouse(4, 4, 4, 1, 2));
    }
}
