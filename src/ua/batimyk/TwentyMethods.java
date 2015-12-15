package ua.batimyk;

public class TwentyMethods {

    public static void print(char[] array) {
        for (char c : array) {
            System.out.println(c);
        }
    }

    public static void print(String[][] array) {
        for (String[] outerArray : array) {
            for (String s : outerArray) {
                System.out.println(s);
            }
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

    public static void invert(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] *= -1;
            }
        }
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    public static int max(int a, int b, int c, int d, int e) {
        return max(max(a, b, c), max(d, e));
    }

    public static String toString(char[] array) {
        String s = "";
        for (char c : array) {
            s += c;
        }
        return s;
    }

    public static boolean include(char[] array, char[] arrayToFind) {

        for (int i = 0, j = 0; i < array.length; i++, j++) {

            if (array[i] != arrayToFind[j]) {
                i -= j;
                j = -1;
            }
            if (j == arrayToFind.length - 1) return true;
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

    public static int indexOfReversal(int[] array, int value) {

        return indexOf(array, value) == -1 ? -1 : array.length - indexOf(array, value) - 1;
    }

    public static int factorial(int value) {

        if (value == 0) {
            return 1;
        }
        return factorial(value - 1) * value;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static String[] getIncluded(String[] array, String value) {

        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[n].contains(value)) {
                n++;
            } else {
                int j = n;
                while (j < array.length - 1) {
                    array[j] = array[j + 1];
                    j++;
                }
            }
        }
        String[] arrayOfMatched = new String[n];

        int i = 0;
        while (i < arrayOfMatched.length) {
            arrayOfMatched[i] = array[i];
            i++;
        }

        array = arrayOfMatched;
        return array;
    }

    public static void printMultiples(int[] array, int value) {
        for (int x : array) {
            if (x % value == 0) {
                System.out.println(x);
            }
        }
    }

    public static void print3(double d) {

        System.out.println(String.format("%.3f", d));
    }

    public static void sortAscending(int[] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int b = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = b;
                }
            }
        }
    }

    public static void sortDescending(int[] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int b = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = b;
                }
            }
        }
    }

    public static void sortConditional(int[] array, boolean desc) {
        if (desc) {
            sortDescending(array);
        } else {
            sortAscending(array);
        }
    }

    public static boolean hasDupValue(byte[] ab) {
        //two arrays
        for (int i = 0; i < ab.length; i++) {
            for (int j = i + 1; j < ab.length; j++) {
                if (ab[i] == ab[j]) {
                    return true;
                }
            }
        }
        return false;
    }



}
