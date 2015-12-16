package Miftakhov.Alex.fridge;
/**
 * Created by omiftakhov on 14.12.2015.
 */

import java.util.*;

public class OpenFridge4x4 {
    /**************************************/
    static int[] arrayFirst = {0, 1, 1, 1};
    static int[] arraySecond = {0, 1, 1, 1};
    static int[] arrayThird = {1, 1, 1, 1};
    static int[] arrayForth = {0, 1, 1, 1};
    /**************************************/
    static int[][] array = new int[4][4];
    static int stepsToUnLockR = 0;
    static long date;

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
        for (int j = 0; j < 4; j++) {
            array[0][j] = arrayFirst[j];
            array[1][j] = arraySecond[j];
            array[2][j] = arrayThird[j];
            array[3][j] = arrayForth[j];
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
