package lesson1.problem4;

import junit.framework.TestCase;

public class PermutationCheckerTest extends TestCase {

    public void testCheckPermutation() {
        PermutationChecker underTest = new PermutationChecker();

        boolean expected = true;
        boolean actual = underTest.checkPermutation("eecba","abcee");

        assertEquals(expected,actual);

    }
}