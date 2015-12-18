package ua.com.omiftakhov.fridge;

/**
 * Created by omiftakhov on 16.12.2015.
 */
public class FridgesManipulationMethods {
    static void printArray(int[][] array) {
        String prefix = "    ";
        String axis = "-------";
        System.out.println("i| ");
        for (int i = 0; i < array.length; i++) {
            prefix = prefix + i + " ";
            axis = axis + "--";
            System.out.print(i + "|  ");
            for (int j = 0; j < array[i].length; j++) {
                if (j != 3) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.println(array[i][j] + " ");
                }
            }
        }
        System.out.println(axis);
        System.out.println(prefix + "  j");
    }

    static void printArray(int[][] array, int[] index) {
        String prefix = "    ";
        String axis = "-------";
        System.out.println("i| ");
        for (int i = 0; i < array.length; i++) {
            prefix = prefix + i + " ";
            axis = axis + "--";
            System.out.print(i + "|  ");
            for (int j = 0; j < array[i].length; j++) {
                if (j != 3) {
                    if (i == index[0] && j == index[1]) {
                        System.out.print(array[i][j] + "* ");
                    } else {
                        System.out.print(array[i][j] + " ");
                    }
                } else {
                    if (i == index[0] && j == index[1]) {
                        System.out.println(array[i][j] + "* ");
                    } else {
                        System.out.println(array[i][j]);
                    }
                }
            }
        }
        System.out.println(axis);
        System.out.println(prefix + "  j");
    }


    static int[][] switcharray(int[][] array, int[] axis) {
        int[][] result = array;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == axis[1] || i == axis[0])
                    result[i][j] = switchSingle(array[i][j]);
            }
        }
        return result;
    }

    static int switchSingle(int i) {
        return (i == 0) ? 1 : 0;
    }

    static int[][] switchedArrayWigth(int[][] array) {
        int[][] result = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result[i][j] = array[i][j];
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                int weigth = 0;
                for (int x = 0; x < result.length; x++) {
                    weigth = weigth + array[x][j];
                }
                for (int x = 0; x < result.length; x++) {
                    weigth = weigth + array[i][x];
                }
                result[i][j] = weigth - result[i][j];
            }
        }
        return result;
    }

    static int[] maxWeightArrayElement(int[][] array) {
        int[] result = {-1, -1};
        int someInt = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0 && array[i][j] % 2 == 1 && array[i][j] >= someInt) {
                    someInt = array[i][j];
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    static void resoilveWithRec(int[][] array) {
        int[] isResolved = maxWeightArrayElement(array);
        if (isResolved[0] == -1 && isResolved[0] == -1) {
            printArray(array);
            System.out.println("Fridge is resolved and opened!!!");
        } else {
            printArray(array, maxWeightArrayElement(switchedArrayWigth(array)));
            switcharray(array, maxWeightArrayElement(switchedArrayWigth(array)));
            resoilveWithRec(array);
        }
    }


}
