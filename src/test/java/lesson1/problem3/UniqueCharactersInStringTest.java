package lesson1.problem3;

import junit.framework.TestCase;

public class UniqueCharactersInStringTest extends TestCase {

    public void testHasUniqueChars() {
        UniqueCharactersInString underTest = new UniqueCharactersInString();

        boolean expected = true;
        boolean actual = underTest.hasUniqueChars("abcdefgtr");

        assertEquals(expected,actual);
    }
}