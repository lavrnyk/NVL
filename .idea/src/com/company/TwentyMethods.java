package ua.lavrenov;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TwentyMethods {

    public static void print(char[] array) {
        for (char value : array) {
            System.out.print(value + " ");
        }
    }

    public static void print(String[][] array) {
        for (String[] string : array) {
            for (String value : string) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static char[][] toChar(int[][] array) {
        char[][] result = new char[array.length][];
        for (int i = 0; i < array.length; i++) {
            result[i] = new char[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                result[i][j] = (char) array[i][j];
            }
        }
        return result;
    }


    public static int[][] invert(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] *= -1;
            }
        }
        return array;
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;

    }

    public static int max(int a, int b, int c) {
        return max(max(a, b), c);

    }

    public static int max(int a, int b, int c, int d, int e) {
        return max(max(a, b, c), max(d, e));
    }

    public static String toString(char[] chars) {
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            result += chars[i];
        }
        return result;
    }

    public static boolean isContainsSecond(char[] first, char[] second) {
        for (int i = 0, j = 0; i < first.length && j < second.length; i++,j++) {
            if (first[i] != second[j]) {
                i -= j;
                j = -1;//0;
            }
            if (j == second.length -1 ){
                return true;
            }
        }
        return false;
    }

    public static int indexOf(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int lastIndexOf(int[] array, int value) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int factorial(int value) {
        return (value == 0) ? 1 : value * factorial(value - 1);
    }

    public static boolean isLeapYear(int value) {
        return (value % 400 == 0 || (value % 4 == 0 && value % 100 != 0));
    }

    // to check rewrite without arrayCopy
    public static String[] StringContainsValue(String[] array, String value) {
        int countMatches = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].contains(value)) {
                array[countMatches] = array[i];
                countMatches++;
            }
        }
        if (countMatches == 0) {
            return new String[0];
        } else {
            String[] result = new String[countMatches];
            for (int i = 0; i < countMatches; i++) {
                result[i] = array[i];
            }
            return result;
        }
    }

    public static void printMultiplies(int[] array, int value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] % value == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    public static void printfTo3decimalPlaces(double value) {
        DecimalFormat df = new DecimalFormat("#.000");
        df.setRoundingMode(RoundingMode.FLOOR);
        // System.out.printf("%.3f",value);//
        System.out.println(df.format(value));

    }

    public static void sortAscending(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void sortDescending(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void sort(int[] array, boolean desc) {
        if (desc) {
            sortDescending(array);
        }
        else {
            sortAscending(array);
        }
    }

    public static boolean isDuplicate(byte[] array) {
        boolean[] temp = new boolean[256];
        for (byte value : array) {
            if (temp[value+128] == true) {
                return true;
            }
            else {
                temp[value+128] = true;
            }
        }
        return false;
    }

}