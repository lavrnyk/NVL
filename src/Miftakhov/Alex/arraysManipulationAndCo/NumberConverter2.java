package Miftakhov.Alex.arraysManipulationAndCo;

/**
 * Created by omiftakhov on 16.12.2015.
 */
public class NumberConverter2 {
    public static void main(String[] args) {

    }


        public static int toInt(String str) {
            int rank;
            int num;
            int limit;
            int result = 0;
            boolean positive = true;
            int i = 0;
            if (str == null) {
                throw new NumberFormatException("null");
            }

            int size = str.length();
            if (size == 0) {
                throw new NumberFormatException("size is 0: for " + str);
            }

            char firstChar = str.charAt(0);
            if (firstChar == '-') {
                positive = false;
                i++;
            }
            if (positive) {
                limit = Integer.MAX_VALUE * (-1);
            } else {
                limit = Integer.MIN_VALUE;
            }
            while (i < size) {
                int digit;
                digit = Character.digit(str.charAt(i++), 10);
                rank = size - i;
                if (rank != 0) {
                    num = digit * pow(10, rank);
                } else num = digit;

                if (limit > (result + num) * (-1)) {
                    throw new NumberFormatException("Integer limit:" + str);
                }
                result += num;
            }
            return positive ? result : -result;
        }


        public static String toString(int num) {

            if (num == Integer.MIN_VALUE) {
                return "-2147483648";
            }

            int buf = num;
            if (num < 0) {
                buf = num * (-1);
            }
            StringBuilder b = new StringBuilder();
            while (buf != 0) {
                b.insert(0, (char) ('0' + buf % 10));
                buf /= 10;
            }
            if (num < 0) {
                b.insert(0, '-');
            }
            if (num == 0) {
                b.insert(0, '0');
            }
            return b.toString();
        }

        public static String toString(double num) {

            return "";
        }

        public static double toDouble(String str) {
            String strBefore,strAfter;
            if (str == null) {
                throw new NumberFormatException("null");
            }
            int size=str.length();
            if (str.indexOf('.')>0) {
                strBefore = str.substring(0, str.indexOf('.'));
                strAfter = str.substring(str.indexOf('.')+1, size - (str.indexOf('.')+1));
            } else{
                strBefore=str;
                strAfter="";
            }


            int rank;
            double num;
            double limit;
            double result = 0;
            boolean positive = true;
            int i = 0;
            if (size == 0) {
                throw new NumberFormatException("size is 0: for " + str);
            }
            char firstChar = str.charAt(0);
            if (firstChar == '-') {
                positive = false;
                i++;
            }
            if (positive) {
                limit = Double.MAX_VALUE * (-1);
            } else {
                limit = Double.MIN_VALUE;
            }
            while (i < strBefore.length()) {
                double digit;
                digit = Character.digit(str.charAt(i++), 10);
                rank = strBefore.length() - i;
                if (rank != 0) {
                    num = digit * pow(10, rank);
                } else num = digit;

                result += num;
            }
            i = 0;
            while (i < strAfter.length()) {
                double digit;
                rank = strAfter.length() - i;
                digit = Character.digit(str.charAt(i++), 10);
                if (rank != 0) {
                    num = digit / pow(10, rank);
                } else num = digit;
                result += num;
            }
            return positive ? result : -result;
        }


        public static int pow(int a, int n) {
            int b = a;
            for (int i = 1; i < n; i++) {
                b *= a;
            }
            return b;
        }



}
