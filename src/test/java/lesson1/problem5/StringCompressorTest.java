package lesson1.problem5;

import junit.framework.TestCase;

public class StringCompressorTest extends TestCase {

    public void testCompressString() {
        StringCompressor underTest = new StringCompressor();

        String expected =  "a3b3c3";
        String actual = underTest.compressString("aaabbbccc");

        assertEquals(expected,actual);
    }
}