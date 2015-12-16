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
        int ir = 0;
        int sign = 1;
        int initPos = 0;

        if (value.charAt(0) == '-') {
            sign = -1;
            initPos = 1;
        }

        int weight = (int)Math.pow(10, value.length() - initPos - 1);

        for (int i = initPos; i < value.length(); i++) {
            int digit = (value.charAt(i) - 48) * weight;
            ir += digit;
            weight /= 10;
        }
        
        return sign * ir;
    }

    //3. Double to String converter
    public static String toString(double value) {

        StringBuilder s = new StringBuilder();

        if (value < 0) {
            value *= -1;
            s.append("-");
        }

        if (value == 0.0) return "0.0";

        long n = (long) Math.log10(value);
        long weight = (long) Math.pow(10, n);

        for (int i = 0; i <= n; i++) {
            int digit = (int)(value % (10 * weight) / weight);
            s.append(digit);
            weight /= 10;
        }

        double fractionWeight = 10;
        double fraction   = value % 1;

        s.append(".");

        int i = 0;
        double remainder = (fraction % 1) * 10;
        long precision =  16 - n;

        if (remainder == 0.0) s.append("0");

        while(remainder > 1/Math.pow(10,n) && i <= precision  )
        {
            int digit = (int)(remainder % 10);
            fractionWeight *= 10;
            s.append(digit);
            remainder = (fraction * fractionWeight) % 10;
            i++;
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

        long weight = (long)Math.pow(10, value.length() - initPos - 1);

        for (int i = initPos; i < value.length(); i++) {
            if(value.charAt(i) == '.') {
               dotPos = i;
            }
            else {

                long digit = (value.charAt(i) - 48) * weight;
                ir += digit;
                weight /= 10;
            }
        }

        return sign * ir / (long)Math.pow(10, value.length() - dotPos) ;
    }

    public static void main(String[] args) {
        //System.out.println(245.7553633632647774754848448484);
        //System.out.println(24.7553633632647774754848448484);
        //System.out.println(2.7553633632647774754848448484);
        //System.out.println(0.7553633632647774754848448484);
        //System.out.println(1.7553633632647774754848448484);
        //System.out.println(Math);

       ///* System.out.println(2345.1d % 1);

        System.out.println(2345d);
        System.out.println(toString(2345.0));
        System.out.println(2345.1234567890123456789);
        System.out.println(toString(2345.1234567890123456789));
        System.out.println(2345.678901);
        System.out.println(toString(2345.678901));

        System.out.println(1234.0001);
        System.out.println(toString(1234.0001));
        System.out.println(2345.123456789);
        System.out.println(toString(2345.123456789));

        System.out.println( 1110.001 % 1);
    }
}
