package Miftakhov.Alex.arraysManipulationAndCo;

import static org.junit.Assert.*;

/**
 * Created by omiftakhov on 16.12.2015.
 */
public class NumberConverter2Test {


    @org.junit.Test
    public void testToInt() throws Exception {

        assertEquals(1, NumberConverter2.toInt("1"));
        assertEquals(-1, NumberConverter2.toInt("-1"));
        assertEquals(0, NumberConverter2.toInt("0"));
        assertEquals(2147483647, NumberConverter2.toInt("2147483647"));
        assertEquals(-2147483648, NumberConverter2.toInt("-2147483648"));

    }

    @org.junit.Test
    public void testToStringInt() throws Exception {

        assertEquals("1", NumberConverter2.toString(1));
        assertEquals("-1", NumberConverter2.toString(-1));
        assertEquals("0", NumberConverter2.toString(0));
        assertEquals("2147483647", NumberConverter2.toString(2147483647));
        assertEquals("-2147483648", NumberConverter2.toString(-2147483648));

    }

    @org.junit.Test
    public void testToStringDouble() throws Exception {

    }
    @org.junit.Test
    public void testToDouble() throws Exception {


    }
}