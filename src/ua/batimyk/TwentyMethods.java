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

    public static char[][] toCharArray(int[][] array) {
        char[][] result = new char[array.length][];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result[i][j] = (char) array[i][j];
            }
        }
        return result;
    }

    public static void invert(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (-1) * array[i][j];
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

        for (int i = 0, j = 0; i < array.length; i++) {

            if (j == arrayToFind.length ) {
                return true;
            }

            if (array[i] != arrayToFind[j]) {
                j = 0;
            } else {
                j++ ;
            }
            System.out.println(i + " " + j + " " + array[i] + " " + arrayToFind[j] );


        }
        return false;
    }

    public static int index(int[] array, int value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int indexReversal(int[] array, int value) {

        return index(array, value) == -1 ? - 1 :  array.length - index(array, value) - 1 ;
    }

    public static int factorial(int value) {

        if (value == 0) {
            return 1;
        }
        return factorial(value - 1) * value;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? true : false;
    }

    public static String[] getIncluded(String[] array, String value) {
        //?not sure is it the best solution 		
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[n].contains(value)) {
                n++;
            } else {
                for (int j = n; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
            }
        }
        String[] str = new String[n];
        System.arraycopy(array, 0, str, 0, n);
        array = str;
        return str;
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

    public static boolean isHasDupValue(byte[] ab) {

        for (int i = 0; i < ab.length; i++) {
            for (int j = i + 1; j < ab.length; j++) {
                if (ab[i] == ab[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        char[] array = {'a', 'b', 'c', 'd','e' ,'e', 'f','f'};
        char[] array2 = {'e', 'f'};
        char[] array3 = {'b', 'd'};
        char[] array4 = {'f'};
        char[] array5 = {'a', 'b'};
        char[] array6 = {'a', 'b', 'd'};

        String[] strArr = {"abc", "def", "ghj", "rty", "sdfabcgh", "swe"};

        int[] iarray = {1, 4, 1001, 6, 78, -86, 887, 33, 1000, 0, 5};
        byte[] barray = {1, 5, 7, 8, 10, 35, 2, 4, 9, 0};
        byte[] barray2 = {1, 5, 7, 8, 10, 35, 2, 4, 9, 0, 0};

        int[][] arrayInt = {{65, 66, 67}, {67, 68}, {69, 66, 70}};


        System.out.println(include(array,array2));
      //  System.out.println(include(array,array));
      //  System.out.println(include(array,array5));
     //   System.out.println(include(array,array4));
     //   System.out.println(include(array,array3));

        //System.out.println(isHasDupValue(barray));
        //System.out.println(isHasDupValue(barray2));

        /*for (char[] x : to2dCharArray(arrayInt)) {	  
         for( char y : x ) System.out.print(y+" ");
         System.out.println("");
         }*/
	//printDouble3digit(1.324355d);
        //printDouble3digit(12222.324355d);
        //printDouble3digit(12222.32d);
        //sortDescending(iarray);
      //  sortConditional(iarray, true);
      //  for (int i : iarray) {
      //      System.out.println(i);
      //  }

	//printMultiples(iarray, 2);
        //for (String s : getIncluded(strArr,"bc")) System.out.println("return: "+s);
        //System.out.println(getFactorial(6));
        //System.out.println(getFactorial(5));
        //System.out.println(getFactorial(1));
        //System.out.println(getFactorial(0));
        //System.out.println(getFactorial(10));
	//System.out.println(isInclude(array,array ));
        //System.out.println(isInclude(array,array2 ));
        //System.out.println(isInclude(array,array3 ));
        //System.out.println(isInclude(array,array4 ));
        //System.out.println(isInclude(array,array5 ));
        //System.out.println(isInclude(array,array6 ));
        //System.out.println(isInclude(array6,array5 ));
	//System.out.println(isLeapYear(2000));
        //System.out.println(isLeapYear(1600));
        //System.out.println(isLeapYear(2002));
	//System.out.println(getIndex(iarray, 6));
        //System.out.println(getIndex(iarray, 5));		
        //System.out.println(getIndex(iarray, -86));	
        //System.out.println(getIndex(iarray, 2));	
	//System.out.println(getIndexFromEnd(iarray, 6));
        //System.out.println(getIndexFromEnd(iarray, 5));		
        //System.out.println(getIndexFromEnd(iarray, -86));	
        //System.out.println(getIndexFromEnd(iarray, 2));	
    }

}
