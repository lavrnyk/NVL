package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class TwentyMethods {
    public static void main(String[] args) {
    }

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
// ??
    public static char[][] toChar (int[][] array) {
        char[][] resultArray = new char[array.length][];
        for (int i = 0; i < array.length; i++) {
            char[] result = new char[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                result[j] = (char)array[i][j];
            }
            resultArray[i] = result;
        }
        return resultArray;
    }


    public static int[][] invert (int[][] array) {
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] *=-1;
            }
        }
        return array;
    }

    public static int max(int a, int b){
        return (a > b) ? a : b;

    }

    public static int max(int a, int b,int c){
        return max(max(a, b), c);

    }

    public static int max(int a, int b,int c,int d,int e){
        return max(max(a, b, c), max(d,e));
    }

    public static String toString(char[] chars){
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            result += chars[i];
        }
        return result;
    }

    public static boolean isFirstContainsSecond(char[] first, char[] second) {
        boolean result = false;
        for (int i = 0, j = 0; i < first.length && j < second.length ; i++) {
            if (first.length-i < second.length-j) {return false;}
            if (first[i] == second[j]){
                result = true;
                j++;
            }
            else {
                j = 0;
                result = false;
            }
        }
        return result;
    }

    public static int indexOf(int[] array, int value){
        for(int i = 0; i < array.length; i++){
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int lastIndexOf (int[] array, int value){
        for(int i = array.length-1; i >= 0; i--){
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
        return (value%400 == 0 || (value%4 == 0 && value%100 != 0));
    }
    // to check
    public static String[] StringContainsValue (String[] array,String value ) {
        int countMatches = 0;
        String[] temp = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i].contains(value)) {
                temp[countMatches] = array[i];
                countMatches++;
            }
        }
        if (countMatches == 0) {
            return new String[0];//null;
        } else {
            String[] result = new String[countMatches];
            System.arraycopy(temp, 0, result, 0, countMatches);
            return result;
        }
    }

    public static void isMultipleOfValue (int[] array, int value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] % value == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }
    public static double truncatedTo3decimalPlaces(double value){
        DecimalFormat df = new DecimalFormat("#.000");
        return System.out.printf(value, df);
        //Math.floor(value * 1000.0)/ 1000.0;

    }

    public static void sortAscending(int[] array){
        for(int i = array.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( array[j] > array[j+1] ){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public static void sortDescending(int[] array){
        for(int i = array.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( array[j] < array[j+1] ){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void sort(int[] array, boolean desc){
        if (desc) {sortDescending(array);
        }
        sortAscending(array);
        //b ? sortDescending(array) : sortAscending(array);
    }
    // one loop, one array
    public static boolean isDuplicateElements(byte[] array){
        for(byte b = 0; b < array.length; b++){
            for (int c = b+1; c < array.length; c++){
                if (array[b] == array[c]){
                    return true;
                }
            }
        }
        return false;
    }

    //Just to print
    public static void print(char[][] array) {
        for (char[] string : array) {
            for (char value : string) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void print(int[][] array) {
        for (int[] string : array) {
            for (int value : string) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void print(String[] array) {
        for (String string : array) {
            System.out.print(string + " ");
        }
    }

    public static void print(ArrayList<Integer> array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    public static void print(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
    }


    //
}