package ua.batimyk;

import org.junit.Test;

import static org.junit.Assert.*;
import ua.batimyk.NumberConverter;


/**
 * Created by N on 12/13/15.
 */
public class NumberConverterTest {

    @Test
    public void testToString() throws Exception {
        int[] i = {234,-234};
        assertEquals("234",NumberConverter.toString(i[0]));
        assertEquals("-234",NumberConverter.toString(i[1]));
     //   assertEquals("-34566",NumberConverter.toString(-34566));
     //   assertEquals("34566",NumberConverter.toString(34566));
        assertEquals("0",NumberConverter.toString(0));
        assertEquals("252266262",NumberConverter.toString(252266262));
    }

    @Test
    public void testToInt() throws Exception {
        assertEquals(234,NumberConverter.toInt("234"));
        assertEquals(-234,NumberConverter.toInt("-234"));
        assertEquals(34566,NumberConverter.toInt("34566"));
        assertEquals(-34566,NumberConverter.toInt("-34566"));
        assertEquals(0,NumberConverter.toInt("0"));
        assertEquals(252266269,NumberConverter.toInt("252266269"));
    }
}