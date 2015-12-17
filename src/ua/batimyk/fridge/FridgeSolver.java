package ua.batimyk.fridge;

import java.util.ArrayList;

/**
 * Created by N on 12/16/15.
 */
public class FridgeSolver {

    public Fridge iterateFridge(int startX, int startY, Fridge fridge) {
        int count = 0;
        for (int x = 0; x < fridge.getPositions().length; x++) {

            for (int y = 0; y < fridge.getPositions()[x].length; y++) {
                if (x == startX && y == startY) {
                    continue;
                }
                fridge.turnHandle(x, y);
                if (fridge.isOpen()) {
                    System.out.println("Solved!");
                    //System.out.println("[" + x + "," + y +"]");
                    return fridge;
                } else {
                    fridge.turnHandle(x, y);
                }
            }
        }

        return fridge;
    }

    public static void main(String[] args) {
        int[][] initPositions = {
                {1, 1, -1, 1}
                , {1, 1, -1, 1}
                , {-1, -1, 1, -1}
                , {1, 1, 1, -1}
        };

        int[][] initPosForOneMove = {
                {1, 1, -1, 1}
                , {1, 1, -1, 1}
                , {-1, -1, -1, -1}
                , {1, 1, -1, 1}
        };

        Fridge fridge = new Fridge(initPositions);
        FridgeSolver solveFridge = new FridgeSolver();
        // System.out.println(solveFridge.iterateFridge(0, 0, fridge));
        // fridge.setPositions(initPosForOneMove);
        //System.out.println(solveFridge.iterateFridge(0, 0, fridge));


            for (int x = 0; x < fridge.getPositions().length; x++) {
                for (int y = 0; y < fridge.getPositions()[x].length; y++) {
                    while(!fridge.isOpen())
                    {
                        fridge.turnHandle(x,y);
                        fridge = solveFridge.iterateFridge(x, y, fridge);
                        System.out.println(fridge);
                        continue;
                    }
                }
            }

            System.out.println(fridge);

        }

}
