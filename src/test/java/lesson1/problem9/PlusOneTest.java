package lesson1.problem9;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOneTest extends TestCase {

    public void testAddOne() {
        PlusOne underTest = new PlusOne();

        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,0,0));
        ArrayList<Integer> toModify = new ArrayList<Integer>(Arrays.asList(9,9));

        ArrayList<Integer> actual = underTest.addOne(toModify);

        assertTrue(expected.equals(actual));
    }
}