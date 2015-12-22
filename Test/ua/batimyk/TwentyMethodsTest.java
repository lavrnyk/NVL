package ua.batimyk;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by N on 12/14/15.
 */
public class TwentyMethodsTest {

    @Test
    public void testPrint() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        char[] array = {'a','b','D','e','1', '@', '7'};
        System.setOut(new PrintStream(out));
        TwentyMethods.print(array);
        assertEquals("abDe1@7", out.toString());

    }

    @Test
    public void testPrint2dArray() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String[][] array = {
            {"aad[d","ttr],r","ryryrs"}
           ,{"sfsfsa", "ffaffaf"}
           ,{"abnghghg","3534dw3r","69^e43","4232ev"}
        };
        System.setOut(new PrintStream(out));
        TwentyMethods.print(array);
        assertEquals(String.format(Arrays.deepToString(array).replaceAll("]?, \\[?","%n").replaceAll("^\\[\\[|\\]\\]$","")+"%n"), out.toString());

    }

    @Test
    public void testInvert() throws Exception {
        int[][] array = {{1, -2, -3, -7, -8, 0, 100, 1012, -2}
                , {-10, 20, 30, 70, 80, 0, -10, -112, 20}
        };
        int[][] arrayInverted = {{-1, 2, 3, 7, 8, 0, -100, -1012, 2}
                , {10, -20, -30, -70, -80, 0, 10, 112, -20}
        };

        TwentyMethods.invert(array);

        assertArrayEquals(array, arrayInverted);

    }

    @Test
    public void testMax() throws Exception {
        assertEquals(10, TwentyMethods.max(10, 0));
        assertEquals(0, TwentyMethods.max(-10, 0));
        assertEquals(-5, TwentyMethods.max(-10, -5));
        assertEquals(0, TwentyMethods.max(0, 0));
        assertNotEquals(-10, TwentyMethods.max(-10, -5));
    }

    @Test
    public void testMax3() throws Exception {
        assertEquals(10, TwentyMethods.max(10, 0, 5));
        assertEquals(0, TwentyMethods.max(-10, 0, -5));
        assertEquals(-5, TwentyMethods.max(-10, -100, -5));
        assertEquals(0, TwentyMethods.max(0, 0, 0));
        assertNotEquals(-10, TwentyMethods.max(-10, -5, -11));
    }

    @Test
    public void testMax5() throws Exception {
        assertEquals(10, TwentyMethods.max(10, 0, 5, 8, 9));
        assertEquals(0, TwentyMethods.max(-10, 0, -5, -8, -9));
        assertEquals(-5, TwentyMethods.max(-10, -100, -5, -15, -5));
        assertEquals(0, TwentyMethods.max(0, 0, 0, 0, -1));
        assertNotEquals(-1, TwentyMethods.max(0, 0, 0, 0, -1));
    }

    @Test
    public void testToString() throws Exception {
        char[] array = {'a', 'b', 'c', 'd', 'e'};
        assertEquals("abcde", TwentyMethods.toString(array));
    }

    @Test
    public void testToChar() throws Exception {
        int[][] arrayOfInt = {
                {53, 54}
                , {51, 52, 55}
                , {35, 36, 37, 38}
        };
        char[][] arrayOfChar = {
                {'5', '6'}
                , {'3', '4', '7'}
                , {'#', '$', '%', '&'}
        };

        assertArrayEquals(arrayOfChar, TwentyMethods.toChar(arrayOfInt));
    }

    @Test
    public void testContains() throws Exception {
        char[][] array = {
                {'a', 'b', 'c', 'd', 'e', 'e', 'f'}
                , {'a', 'a', 'b', 'b', 'c'}
        };
        char[][] arrayToFind = {
                {'e', 'e', 'f'}
                , {'a', 'c'}
                , {'b', 'b'}
                , {'a', 'b'}
        };

        assertEquals(true, TwentyMethods.contains(array[0], arrayToFind[0]));
        assertEquals(true, TwentyMethods.contains(array[0], array[0]));
        assertEquals(true, TwentyMethods.contains(array[1], array[1]));
        assertEquals(true, TwentyMethods.contains(array[1], arrayToFind[2]));
        assertEquals(true, TwentyMethods.contains(array[0], arrayToFind[3]));
        assertEquals(false, TwentyMethods.contains(array[0], arrayToFind[1]));
        assertEquals(false, TwentyMethods.contains(array[1], arrayToFind[1]));
    }

    @Test
    public void testIndexOf() throws Exception {
        int[] array = {10, 20, 30, 40, 10};
        assertEquals(0, TwentyMethods.indexOf(array, 10));
        assertEquals(3, TwentyMethods.indexOf(array, 40));
    }

    @Test
    public void testLastIndexOf() throws Exception {
        int[] array = {10, 20, 30, 40, 10, 50};
        assertEquals(3, TwentyMethods.lastIndexOf(array, 40));
        assertEquals(4, TwentyMethods.lastIndexOf(array, 10));
    }

    @Test
    public void testFactorial() throws Exception {
        assertEquals(1, TwentyMethods.factorial(0));
        assertEquals(1, TwentyMethods.factorial(1));
        assertEquals(2, TwentyMethods.factorial(2));
        assertEquals(3628800, TwentyMethods.factorial(10));
    }

    @Test
    public void testIsLeapYear() throws Exception {
        assertEquals(true, TwentyMethods.isLeapYear(2000));
        assertEquals(false, TwentyMethods.isLeapYear(2002));
        assertEquals(true, TwentyMethods.isLeapYear(2016));
        assertEquals(true, TwentyMethods.isLeapYear(1600));
        assertEquals(false, TwentyMethods.isLeapYear(1700));
    }

    @Test
    public void testGetIncluded() throws Exception {
        String[] array = {"abcde", "dfgh", "frdsfs", "rty", "sdrdsf", "cvbnm", "addarf"};
        String[] arrayChecking = {"frdsfs", "sdrdsf"};
        String[] emptyArray = {};

        assertArrayEquals(arrayChecking, TwentyMethods.getIncluded(array, "ds"));
        assertArrayEquals(emptyArray, TwentyMethods.getIncluded(array, "ssssss"));
    }

    @Test
    public void TestSortAscending() throws Exception {
        int[] array = {5, -1, 0, 4, 10, -100, 3, 5, 64, 3};
        int[] arraySorted = {-100, -1, 0, 3, 3, 4, 5, 5, 10, 64};

        TwentyMethods.sortAscending(array);

        assertArrayEquals(arraySorted, array);
    }

    @Test
    public void TestSortDescending() throws Exception {
        int[] array = {5, -1, 0, 4, 10, -100, 3, 5, 64, 3};
        int[] arraySorted = {64, 10, 5, 5, 4, 3, 3, 0, -1, -100};

        TwentyMethods.sortDescending(array);

        assertArrayEquals(arraySorted, array);
    }

    @Test
    public void TestSortConditional() throws Exception {
        int[] array = {5, -1, 0, 4, 10, -100, 3, 5, 64, 3};
        int[] arraySortedDesc = {64, 10, 5, 5, 4, 3, 3, 0, -1, -100};
        int[] arraySortedAsc = {-100, -1, 0, 3, 3, 4, 5, 5, 10, 64};

        TwentyMethods.sortConditional(array, true);
        assertArrayEquals(arraySortedDesc, array);


        TwentyMethods.sortConditional(array, false);
        assertArrayEquals(arraySortedAsc, array);

    }

    @Test
    public void hasDupValue() throws Exception {
        byte[] array = {2,4,6,7,8,9,11,3,7};
        byte[] array2 = {11,22,34,53,21,1,2};

        assertEquals(true,TwentyMethods.hasDupValue(array));
        assertEquals(false,TwentyMethods.hasDupValue(array2));
    }

}