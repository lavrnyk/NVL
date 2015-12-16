package ua.batimyk;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by N on 12/13/15.
 */
public class NumberConverterTest {

    @Test
    public void testToString() throws Exception {

        assertEquals("234", NumberConverter.toString(234));
        assertEquals("-234", NumberConverter.toString(-234));
        assertEquals("-34568", NumberConverter.toString(-34568));
        assertEquals("34568", NumberConverter.toString(34568));
        assertEquals("10000", NumberConverter.toString(10000));
        assertEquals("0", NumberConverter.toString(0));
        assertEquals("252266267", NumberConverter.toString(252266267));
        assertEquals("9999", NumberConverter.toString(9999));
        assertEquals("-9999", NumberConverter.toString(-9999));
    }

    @Test
    public void testToInt() throws Exception {
        assertEquals(234, NumberConverter.toInt("234"));
        assertEquals(100, NumberConverter.toInt("100"));
        assertEquals(-234, NumberConverter.toInt("-234"));
        assertEquals(34566, NumberConverter.toInt("34566"));
        assertEquals(-34566, NumberConverter.toInt("-34566"));
        assertEquals(0, NumberConverter.toInt("0"));
        assertEquals(252266269, NumberConverter.toInt("252266269"));
        assertEquals(99999, NumberConverter.toInt("99999"));
        assertEquals(-99999, NumberConverter.toInt("-99999"));
    }

    @Test
    public void testToDouble() throws Exception {

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

    @Test
    public void testToStringDouble() throws Exception {

        assertEquals("234.0", NumberConverter.toString(234d));
        assertEquals("-234.0", NumberConverter.toString(-234d));
        assertEquals("-1234.5678", NumberConverter.toString(-1234.5678));
        assertEquals("1234.5678", NumberConverter.toString(1234.5678));
        assertEquals("0.0", NumberConverter.toString(0d));
        assertEquals("0.0", NumberConverter.toString(0.0d));
        assertEquals("1234.0001", NumberConverter.toString(1234.0001));
        assertEquals("-1234.0001", NumberConverter.toString(-1234.0001));
        assertEquals("-9999.9999", NumberConverter.toString(-9999.9999));
        assertEquals("9999.9999", NumberConverter.toString(9999.9999));

    }
}