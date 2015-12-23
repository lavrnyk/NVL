package ua.com.omiftakhov.arraysManipulationAndCo;


import static org.junit.Assert.*;

/**
 * Created by omiftakhov on 16.12.2015.
*/
public class NumberConverterTest {


    @org.junit.Test
    public void testStringToInt() throws Exception {

        assertEquals(1, NumberConverter.toInt("1"));
        assertEquals(-1, NumberConverter.toInt("-1"));
        assertEquals(0, NumberConverter.toInt("0"));
        assertEquals(2147483647, NumberConverter.toInt("2147483647"));
        assertEquals(-2147483648, NumberConverter.toInt("-2147483648"));

    }

    @org.junit.Test
    public void testIntToString() throws Exception {

        assertEquals("1", NumberConverter.toStr(1));
        assertEquals("-1", NumberConverter.toStr(-1));
        assertEquals("0", NumberConverter.toStr(0));
        assertEquals("2147483647", NumberConverter.toStr(2147483647));
        assertEquals("-2147483", NumberConverter.toStr(-2147483));

    }

    @org.junit.Test
    public void testDoubleToString() throws Exception {
        assertEquals("234.0", NumberConverter.toStr(234d));
        assertEquals("-234.0", NumberConverter.toStr(-234d));
        assertEquals("-1234.5678", NumberConverter.toStr(-1234.5678));
        assertEquals("1234.5678", NumberConverter.toStr(1234.5678));
        assertEquals("0.0", NumberConverter.toStr(0d));
        assertEquals("0.0", NumberConverter.toStr(0.0d));
        assertEquals("2554.12345", NumberConverter.toStr(2554.12345));
        assertEquals("-2554.12345", NumberConverter.toStr(-2554.12345));
        assertEquals("-9999.9999", NumberConverter.toStr(-9999.9999));
        assertEquals("9999.9999", NumberConverter.toStr(9999.9999));

    }
    @org.junit.Test
    public void testStringToDouble() throws Exception {
        assertEquals(234.567, NumberConverter.toDouble("234.567"),0);
        assertEquals(-234.567, NumberConverter.toDouble("-234.567"),0);
        assertEquals(34566.67, NumberConverter.toDouble("34566.67"),0);
        assertEquals(-34566.568, NumberConverter.toDouble("-34566.568"),0);
        assertEquals(0d, NumberConverter.toDouble("0"),0);
        assertEquals(0.0, NumberConverter.toDouble("0.0"),0);
        assertEquals(0.01347, NumberConverter.toDouble("0.01347"),0);
        assertEquals(0.913498, NumberConverter.toDouble("0.913498"),0);
        assertEquals(252266.269, NumberConverter.toDouble("252266.269"),0);
        assertEquals(-837d, NumberConverter.toDouble("-837"),0);
        assertEquals(837d, NumberConverter.toDouble("837"),0);
        assertEquals(-999.0, NumberConverter.toDouble("-999.0"),0);
        assertEquals(999.0, NumberConverter.toDouble("999.0"),0);

    }
}