package lesson1.problem2;

import junit.framework.TestCase;

public class ReverseWordsTest extends TestCase {

    public void testReverseWords() {
        ReverseWords underTest = new ReverseWords();

        String expected = "olleh etam";
        String actual = underTest.reverseWords("hello mate");

        assertEquals(expected,actual);
    }
}