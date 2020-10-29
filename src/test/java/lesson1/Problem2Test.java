package lesson1;

import junit.framework.TestCase;
import lesson1.problem2.ReverseWords;

public class Problem2Test extends TestCase {

    public void testReverseWords() {
        ReverseWords underTest = new ReverseWords();

        String expected = "olleh etam";
        String actual = underTest.reverseWords("hello mate");

        assertEquals(expected,actual);
    }
}