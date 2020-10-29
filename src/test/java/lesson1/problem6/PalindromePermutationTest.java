package lesson1.problem6;

import junit.framework.TestCase;

public class PalindromePermutationTest extends TestCase {

    public void testIsPalindromePermutation() {
        PalindromePermutation underTest = new PalindromePermutation();

        boolean expected = true;
        boolean actual = underTest.isPalindromePermutation("aaabbbaaa");

        assertEquals(expected,actual);
    }
}