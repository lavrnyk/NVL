package Miftakhov.Alex.arraysManipulationAndCo;

import java.util.*;

/**
 * Created by omiftakhov on 07.12.2015.
 */
public class ArraysManipulation {
    public static void main(String[] args) {
        int[] intArrayFirst = {61, 65, 70, 72, 65, 63, 65};
        int[] intArraySecond = {61, 65, 74};
        int[] resultArrey;
        int[][] intArrays = {intArrayFirst, intArraySecond};
        byte[] byteArrayNegative = {-15,0,5,8,15,3};
        byte[] byteArrayPositive = {-15,0,5,8,-15,8};

        String[] stringArray = {"sdf", "sdvzd", "htyj", "rtjr", "rtj", "ryuu"};
        String[] stringArry = {"ads", "sf", "dsfs", "sdf", "sdfsd", "sdf"};
        String[][] stringArrays = {stringArray, stringArry};

        char[] charArray = {'Z', 'x', 'Y', 'A', 'b'};
        char[] charArry = {'A', 'r', 'B', 'd', '+'};
        char[] comparedCharArray = {'x', 'Y', 'A'};
        char[][] charArrays = new char[2][];
        charArrays[0] = charArray;
        charArrays[1] = charArry;

        System.out.println("#1 Begin");
        printArray(charArray);

        System.out.println("#2 Begin");
        printArray(stringArrays);

        System.out.println("#3 Begin");
        printArray(intArrayToCharArray(intArrays));

        System.out.println("#4 Begin");
        printArray(invertIntArray(intArrays));

        System.out.println("#5 Begin (6,5);(7,8)");
        System.out.println(isBigger(6, 5));
        System.out.println(isBigger(7, 8));

        System.out.println("#6 Begin 1,56,12");
        System.out.println(isBigger(1, 56, 12));

        System.out.println("#7 Begin 1,56,12,99,17");
        System.out.println(isBigger(1, 56, 12, 99, 17));

        System.out.println("#8 Begin {'Z', 'x', 'Y', 'A', 'b'}");
        System.out.println(charToString(charArray));

        System.out.println("#9 Begin!");
        System.out.println("Must be TRUE: " + isCharArrayPartOfCharArray(charArray, comparedCharArray));
        System.out.println("Must be FALSE: " + isCharArrayPartOfCharArray(charArray, charArry));


        System.out.println("#10 Begin");
        System.out.println(indexOfArrayFromBegin(intArrayFirst, 65));
        System.out.println(indexOfArrayFromBegin(intArrayFirst, -65));

        System.out.println("#11 Begin");
        System.out.println(indexOfArrayFromEnd(intArrayFirst, 65));
        System.out.println(indexOfArrayFromEnd(intArrayFirst, -65));

        System.out.println("#12 Begin");
        System.out.println("Factorial of 0: " + factorialOf(0));
        System.out.println("Factorial of 7: " + factorialOf(7));
        System.out.println("Factorial of -1: " + factorialOf(-1));

        System.out.println("#13 Begin");
        System.out.println("2000? Expected: true --- " + isLeapYear(2000));
        System.out.println("2100? Expected: false --- " + isLeapYear(2100));

        System.out.println("#14 Begin");
        printArray(isStringLikeString(stringArray, "sd"));

        System.out.println("#15 Begin");
        isArraysIntsMultiples(intArrayFirst, 5);

        System.out.println("#16 Begin");
        doubleTrim(3.15756345345);
        doubleTrim(3.1575635345, 5);

        System.out.println("#17 Begin");
        printArray(intArrayFirst);
        printArray(intArraySort(intArrayFirst));

        System.out.println("#18 Begin");
        printArray(intArrayFirst);
        printArray(intArrayReverseSort(intArrayFirst));

        System.out.println("#19 Begin");
        printArray(intArrayFirst);
        printArray(intArraySortUniversal(intArrayFirst, false));
        printArray(intArrayFirst);
        printArray(intArraySortUniversal(intArrayFirst, true));

        System.out.println("#20 Begin");
        System.out.println("Expected - FALSE: "+isIncludeDupicates(byteArrayNegative));
        System.out.println("Expected - TRUE: "+isIncludeDupicates(byteArrayPositive));

    }

    //1
    static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void printArray(byte[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //
    static void printArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" array[" + i + "][" + j + "]: " + array[i][j]);
            }
            System.out.println();
        }
    }

    //2
    static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" array[" + i + "][" + j + "]: " + array[i][j]);
            }
            System.out.println();
        }
    }

    static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.print(" array[" + i + "]: " + array[i]);
                System.out.println();
            }
        }
    }

    static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" array[" + i + "][" + j + "]: " + array[i][j]);
            }
            System.out.println();
        }
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(" array[" + i + "]: " + array[i]);
        }
        System.out.println();
    }



    //3
    static char[][] intArrayToCharArray(int[][] array) {
        char[][] result = new char[array.length][];
        for (int i = 0; i < array.length; i++) {
            char[] charTemp = new char[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                charTemp[j] = (char) (array[i][j] + 50);
            }
            result[i] = charTemp;
        }
        return result;
    }

    //4
    static int[][] invertIntArray(int[][] array) {
        int[][] result = new int[array.length][0];
        for (int i = 0; i < array.length; i++) {
            int[] intTemp = new int[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                intTemp[j] = -1 * array[i][j];
            }
            result[i] = intTemp;
        }
        return result;
    }

    //5
    static int isBigger(int a, int b) {
        return (a > b) ? a : b;
    }

    //6
    static int isBigger(int a, int b, int c) {
        return (isBigger(a, b) > c) ? isBigger(a, b) : c;
    }

    //7
    static int isBigger(int a, int b, int c, int d, int e) {
        return (isBigger(a, b, c) > isBigger(d, e)) ? isBigger(a, b, c) : isBigger(d, e);
    }

    //8
    static String charToString(char[] array) {
        String result = new String();
        for (int i = 0; i < array.length; i++) {
            result = result + array[i];
        }
        return result;
    }

    //9
    static boolean isCharArrayPartOfCharArray(char[] arrayParent, char[] arrayPaired) {
        boolean result = false;
        int j = 0;
        for (int i = 0; i < arrayParent.length && j < arrayPaired.length; i++) {
            if (arrayPaired[j] == arrayParent[i]) {
                j++;
            }
        }
        if (j == arrayPaired.length) {
            result = true;
        }
        return result;
    }

    //10
    static int indexOfArrayFromBegin(int[] array, int indx) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == indx) {
                result = i;
                break;
            }
        }
        return result;
    }

    //11
    static int indexOfArrayFromEnd(int[] array, int indx) {
        int result = -1;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] == indx) {
                result = i;
                break;
            }
        }
        return result;
    }

    //12
    static String factorialOf(int var) {
        String result = "";
        if (var > 0) {
            for (int i = var - 1; i > 0; i--) {
                var = var * i;
                result = "" + var;
            }
        } else if (var == 0) {
            var = 1;
            result = "" + var;
        } else {
            result = "Error of input param";
        }
        return result;
    }

    //13
    static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }

    //14
    static String[] isStringLikeString(String[] stringArray, String matching) {
        String[] result = new String[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].contains(matching)) {
                //System.out.println(stringArray[i] + " %like% " + matching);
                //return stringArray[i];
                result[i] = stringArray[i];
            }
        }
        return result;
    }

    //15
    static void isArraysIntsMultiples(int[] array, int multiple) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % multiple == 0) {
                System.out.print(array[i] + " ");
            }

        }
        System.out.println();
    }

    //16
    static void doubleTrim(double num) {
        String temp = String.valueOf(num);
        int indx = temp.indexOf("");
        temp = temp.substring(0, indx + 4);

        System.out.println(temp);

    }

    static void doubleTrim(double num, int shift) {
        String temp = String.valueOf(num);
        int indx = temp.indexOf("");
        temp = temp.substring(0, indx + shift + 1);

        System.out.println(temp);

    }

    static double stringToDouble(String in) {
        return Double.parseDouble(in);

    }

    //17
    static int[] intArraySort(int[] input) {
        int tempint;
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                tempint = 0;
                if (input[i] == isBigger(input[j], input[i])) {
                    tempint = input[i];
                    input[i] = input[j];
                    input[j] = tempint;
                }
            }
        }
        return input;
    }

    //18
    static int[] intArrayReverseSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                if (input[i] != isBigger(input[j], input[i])) {
                   int tempint = input[i];
                    input[i] = input[j];
                    input[j] = tempint;
                }
            }
        }
        return input;
    }
    static byte[] intArrayReverseSort(byte[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                if (input[i] != isBigger(input[j], input[i])) {
                   byte tempint = input[i];
                    input[i] = input[j];
                    input[j] = tempint;
                }
            }
        }
        return input;
    }

    //19
    static int[] intArraySortUniversal(int[] input, boolean isstreight) {
        int[] result = new int[input.length];
        if (isstreight == true) {
            result = intArrayReverseSort(input);
        } else {
            result = intArraySort(input);
        }
        return result;
    }

    //20
    static boolean isIncludeDupicates(byte[] input) {
        boolean result = false;
        byte[] resultArray = intArrayReverseSort(input);
        for (int i = 0; i < resultArray.length-1; i++) {
             if (input[i] == input[i+1]) {
                 result = true;
                }
            }
        return result;
    }



    /*static int[] intersec(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length + secondArray.length];
        int count = 0;
        boolean[] existsInSecond = new boolean[firstArray.length];
        boolean[] existsInFirst = new boolean[secondArray.length];
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < secondArray.length; j++) {
                if (firstArray[i] == secondArray[j]) {
                    existsInSecond[i] = true;
                }
            }
            if (!existsInSecond[i]) {
                result[count++] = firstArray[i];//System.out.println(firstArray[i]);
            }
        }
        for (int j = 0; j < secondArray.length; j++) {
            for (int i = 0; i < firstArray.length; i++) {
                if (firstArray[i] == secondArray[j]) {
                    existsInFirst[j] = true;
                }
            }
            if (!existsInFirst[j]) {
                result[count++] = secondArray[j];//System.out.println(secondArray[j]);
            }
        }
        return result;
    }*/

    static int[] generateIntArray(int x, int lower, int higher) {
        int[] resultArray = new int[x];
        Random random = new Random();
        for (int i = 0; i < x; i++) {
            resultArray[i] = lower + random.nextInt(higher - lower);
            //System.out.println(resultArray[i]);
        }
        return resultArray;
    }
}
