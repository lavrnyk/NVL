package ua.com.omiftakhov.arraysManipulationAndCo;

import java.math.*;


/**
 * Created by omiftakhov on 09.12.2015.
 */
public class NumberConverter {
    public static void main(String[] args) {
        int integer = -123;
        double duble = -2554.12345;
        double zeros = 0.0000;
        double zeros2 = -0.0000;
        String str = "456";
        String str2 = "1.23";
        String str3 = "-1.23";

        System.out.println("a) int to String");
        System.out.println(toStr(integer));
        System.out.println(toStr(2147483647));
        System.out.println("b) String to int");
        System.out.println(toInt(str));
        System.out.println("c) double to String");
        System.out.println(toStr(zeros));
        System.out.println(toStr(zeros2));
        System.out.println(toStr(duble));
        System.out.println("d) string to double");
        System.out.println(toDouble(str2));
        System.out.println(toDouble(str3));
        System.out.println(toDouble(str));

    }

    //1
    static String toStr(int income) {
        String result = "";
        String str = "";
        boolean isNegative = false;

        if (income < 0) {
            isNegative = true;
        }

        if (income == 0) {
            return "0";
        }

        //System.out.println(isNegative);
       // System.out.println(income);

        income = Math.abs(income);
        while (income > 0) {
            result = result + income%10;
            income = (income - income%10)/10;
            str = result;
        }
        result = "";
        for (int i = str.length() -1; i >= 0; i--) {
            result = result + str.charAt(i);
        }

        if (isNegative) {
            result = "-" + result;
        }
        return result;
    }

    //2
    static int toInt(String income) {
        int i = 0;
        int result = 0;
        boolean otricatelnoe = false;

        if (income.charAt(0) == '-') {
            otricatelnoe = true;
            i = 1;
        }

        while (i < income.length()) {
            result = result * 10;
            result = result + income.charAt(i++) - '0';//456
        }
        if (otricatelnoe)
            result = -result;
        return result;
    }
    //3
    public static String toStr(double income) {
        String result = "";
        boolean isNegative = false;
        if (Double.compare(income, 0.0) < 0) {
            isNegative = true;
        }
        if (income == 0.0) {
            if (isNegative) {
                result = "-0.0";
            } else {
                result = "0.0";
            }
            return result;
        }
        income = Math.abs(income);

        long log = (long) Math.log10(income);
        long weight = (long) Math.pow(10, log);

        for (int i = 0; i <= log; i++) {
            int digit = (int) ((income % (10 * weight)) / weight);
            result = result + digit;
            weight /= 10;
        }

        double mantice = (income % 1);

        if (mantice == .0) {
            result = result + (".0");
        } else {
            result = result + ".";
            mantice = mantice * 10;

            while ((int) mantice % 10 != 0.0) {
                int digit = (int) mantice % 10;
                //System.out.println(digit);
                result = result + digit;
                mantice = (mantice - digit) * 10;
            }
        }
        if (isNegative) {
            result = "-" + result;
        }
        return result;
    }
    //4
    public static double toDouble(String value) {
        long itterator = 0;
        double result = 0;
        int startFrom = 0;
        int dotPos = value.length();
        double sign = 1;

        if (value.charAt(0) == '-') {
            sign = -1;
            startFrom = 1;
        }

        long weight = (long) Math.pow(10, value.length() - startFrom - 1);

        for (int i = startFrom; i < value.length(); i++) {
            if (value.charAt(i) == '.') {
                dotPos = i;
            } else {
                long digit = (value.charAt(i) - 48) * weight;
                itterator += digit;
                weight /= 10;
            }
        }
        result = sign * itterator / (long) Math.pow(10, value.length() - dotPos);
        return result;
    }
}
