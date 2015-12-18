package ua.com.omiftakhov.fridge;

import java.util.*;

/**
 * Created by omiftakhov on 16.12.2015.
 */
public class OpenFridge6x6 {
    /**************************************/
    private static int[] arrayFirst = {0, 0, 0, 0, 1, 0};
    private static int[] arraySecond = {0, 0, 0, 0, 1, 0};
    private static int[] arrayThird = {0, 0, 0, 0, 1, 0};
    private static int[] arrayFourth = {0, 0, 0, 0, 1, 0};
    private static int[] arrayFifth = {0, 0, 0, 0, 1, 0};
    private static int[] arraySixth = {0, 0, 0, 0, 1, 0};
    /**************************************/
    private static int[][] array = new int[6][6];
    private static int stepsToUnLockR = 0;
    private static long date;

    public static void main(String[] args) {
        System.out.println("Start resolving using recurtion");
        date = Calendar.getInstance().getTimeInMillis();
        System.out.println("Initial matrix :");
        enrichArray();
        FridgesManipulationMethods.printArray(array);
        resolveWithRecCalcSteps(array);
        FridgesManipulationMethods.resoilveWithRec(array);
        System.out.println("It tooks :" + (Calendar.getInstance().getTimeInMillis() - date) + "  - Milliseconds");
    }

    static void enrichArray() {
        for (int j = 0; j < 6; j++) {
            array[0][j] = arrayFirst[j];
            array[1][j] = arraySecond[j];
            array[2][j] = arrayThird[j];
            array[3][j] = arrayFourth[j];
            array[4][j] = arrayFifth[j];
            array[5][j] = arraySixth[j];
        }
    }


    private static void resolveWithRecCalcSteps(int[][] array) {
        int[] isResolved = FridgesManipulationMethods.maxWeightArrayElement(array);
        if (isResolved[0] == -1 && isResolved[1] == -1) {
            System.out.println("Steps to unlock: " + stepsToUnLockR);
            enrichArray();
        } else {
            FridgesManipulationMethods.switcharray(array, FridgesManipulationMethods.maxWeightArrayElement(FridgesManipulationMethods.switchedArrayWigth(array)));
            stepsToUnLockR++;
            resolveWithRecCalcSteps(array);
        }
    }
}


