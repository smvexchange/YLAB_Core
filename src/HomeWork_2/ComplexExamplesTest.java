package HomeWork_2;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ComplexExamplesTest {
    int targetSumTest1 = 10;
    int[] arrayTest1 = new int[]{2, 4, 1, 4, 6, 1, 2, 2, 3, 7, 3, 9, 4};    // [4, 6]
    int targetSumTest2 = 12;
    int[] arrayTest2 = new int[]{1, 3, 8, 4, 5, 5, 9, 7, 9, 2, 6, 1, 5};    // [8, 4]
    int targetSumTest3 = 2;
    int[] arrayTest3 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};    // [1, 1]
    int targetSumTest4 = 1;
    int[] arrayTest4 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};    // throw NoSuchElementException
    int targetSumTest5 = 17;
    int[] arrayTest5 = new int[]{2, 4, 1, 4, 6, 1, 2, 2, 3, 7, 3, 9, 4};    // throw NoSuchElementException
    int targetSumTest6 = 2;
    int[] arrayTest6 = new int[]{};                                         // throw NoSuchElementException

    @Test
    public void getPairOfNumbersTarget10() {
        int[] expected = ComplexExamples.getPairOfNumbers(arrayTest1, targetSumTest1);
        int[] actual = {4, 6};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getPairOfNumbersTarget12() {
        int[] expected = ComplexExamples.getPairOfNumbers(arrayTest2, targetSumTest2);
        int[] actual = {8, 4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getPairOfSameNumbersTarget2() {
        int[] expected = ComplexExamples.getPairOfNumbers(arrayTest3, targetSumTest3);
        int[] actual = {1, 1};
        assertArrayEquals(expected, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void getPairOfZeroNumbersTarget1() {
        ComplexExamples.getPairOfNumbers(arrayTest4, targetSumTest4);
    }

    @Test(expected = NoSuchElementException.class)
    public void getPairOfNumbersTarget17() {
        ComplexExamples.getPairOfNumbers(arrayTest5, targetSumTest5);
    }

    @Test(expected = NoSuchElementException.class)
    public void getPairOfNumbersEmpty() {
        ComplexExamples.getPairOfNumbers(arrayTest6, targetSumTest6);
    }


    @Test
    public void fuzzySearchCar() {
        assertTrue(ComplexExamples.fuzzySearch("car", "ca6$$#_rtwheel")); // true

    }

    @Test
    public void fuzzySearchCwhl() {
        assertTrue(ComplexExamples.fuzzySearch("cwhl", "cartwheel")); // true

    }

    @Test
    public void fuzzySearchCwhee() {
        assertTrue(ComplexExamples.fuzzySearch("cwhee", "cartwheel")); // true

    }

    @Test
    public void fuzzySearchCartwheel() {
        assertTrue(ComplexExamples.fuzzySearch("cartwheel", "cartwheel")); // true

    }

    @Test
    public void fuzzySearchCwheeel() {
        assertFalse(ComplexExamples.fuzzySearch("cwheeel", "cartwheel")); // false

    }

    @Test
    public void fuzzySearchLw() {
        assertFalse(ComplexExamples.fuzzySearch("lw", "cartwheel")); // false

    }
}