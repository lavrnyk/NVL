import org.junit.Test;

import static org.junit.Assert.*;
import ua.batimyk.NumberConverter;


/**
 * Created by N on 12/13/15.
 */
public class NumberConverterTest {

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testToInt() throws Exception {
        assertEquals(234,NumberConverter.toInt("234"));
        assertEquals(-234,NumberConverter.toInt("-234"));
        assertEquals(0,NumberConverter.toInt("0"));
        assertEquals(252266262,NumberConverter.toInt("252266262"));
    }
}