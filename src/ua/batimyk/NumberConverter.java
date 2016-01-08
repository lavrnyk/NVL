package ua.batimyk;



public class NumberConverter {

    //1. Integer to String converter
    public static String toString(int value) {

        StringBuilder s = new StringBuilder();

        if (value < 0) {
            value *= -1;
            s.append("-");
        }

        if (value == 0) return "0";

        int n = (int) Math.log10(value);
        int weight = (int) Math.pow(10, n);

        for (int i = 0; i <= n; i++) {
            int digit = (value % (10 * weight)) / weight;
            s.append(digit);
            weight /= 10;
        }

        return s.toString();
    }

    //2. String to Integer converter
    public static int toInt(String value) {
        int result = 0;
        int sign = 1;
        int initPos = 0;

        if (value.charAt(0) == '-') {
            sign = -1;
            initPos = 1;
        }

        int weight = (int) Math.pow(10, value.length() - initPos - 1);

        for (int i = initPos; i < value.length(); i++) {
            int digit = (value.charAt(i) - 48) * weight;
            result += digit;
            weight /= 10;
        }

        return sign * result;
    }

    //3. Double to String converter
    public static String toString(double value) {

        StringBuilder s = new StringBuilder();

        if (value < 0) {
            value *= -1;
            s.append("-");
        }

        if (value == 0.0) s.append("0");


        long n = (long) Math.log10(value);
        long weight = (long) Math.pow(10, n);

        for (int i = 0; i <= n; i++) {
            int digit = (int) (value % (10 * weight) / weight);
            s.append(digit);
            weight /= 10;
        }

        double remainder = (value % 1);


        if (remainder != 0.0) {
            s.append(".");

            double precision = (10e-13) * Math.pow(10, n);


            while(remainder > 0.01 && remainder > precision )
            {

                remainder *= 10 + precision;
                int digit = (int) (remainder);

                remainder -= digit ;

                s.append(digit);

            }
        } else {
            s.append(".0");
        }
        return s.toString();
    }

    //4. String to Double converter
    public static double toDouble(String value) {

        long ir = 0;
        int initPos = 0;
        int dotPos = value.length();
        double sign = 1;


        if (value.charAt(0) == '-') {
            sign = -1;
            initPos = 1;
        }

        long weight = (long) Math.pow(10, value.length() - initPos - 1);

        for (int i = initPos; i < value.length(); i++) {
            if (value.charAt(i) == '.') {
                dotPos = i;
            } else {

                long digit = (value.charAt(i) - 48) * weight;
                ir += digit;
                weight /= 10;
            }
        }

        return sign * ir / (long) Math.pow(10, value.length() - dotPos);
    }

    public static void main(String[] args) {
        System.out.println(toString(1.123456087));
        System.out.println(toString(123.00001));
        System.out.println(toString(2554.12346));

    }
}
