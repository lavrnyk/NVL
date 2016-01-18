package ua.batimyk.fridge;

import java.util.*;

/**
 * Created by N on 12/16/15.
 */
public class FridgeSolver {

    private int curStateNumber;

    // keeps track of all seen states to prevent double seeing them again
    // possible optimisation - store some hash value as Arrays.deepHash()
    private Set<String> statesSeen = new HashSet<>();

    // keeps track of possibly eligible states
    private Queue<Fridge> states = new LinkedList<>();

    public Fridge findFirstSolution(Fridge state) {
        statesSeen.add(state.toString());
        states.add(state);
        while (!states.isEmpty()) {
            Fridge curState = states.poll();
            if (curStateNumber % 10000 == 0) {
                System.out.println("Looking at " + curStateNumber + "th state");
            }
            curStateNumber++;
            for (int x = 0; x < curState.getPositions().length; x++) {
                for (int y = 0; y < curState.getPositions()[0].length; y++) {
                    Fridge newState = curState.turnHandle(x, y);
                    if (statesSeen.contains(newState.toString())) { // newState has already been seen, skipping
                        continue;
                    }
                    if (newState.isOpen()) {
                        System.out.println("Looked at " + curStateNumber + " states.");
                        return newState;
                    } else {
                        states.add(newState);
                    }
                }
            }
        }
        System.out.println("Looked at " + curStateNumber + " states.");
        return null;
    }

    public static void main(String[] args) {
        byte[][] initPositions = {
                {1, 1, -1, 1}
                , {1, 1, -1, 1}
                , {-1, -1, 1, -1}
                , {1, 1, 1, -1}
        };

        byte[][] initPosForOneMove = {
                {1, 1, -1, 1}
                , {1, 1, -1, 1}
                , {-1, -1, -1, -1}
                , {1, 1, -1, 1}
        };

        Fridge fridge = new Fridge(initPosForOneMove);
        FridgeSolver solveFridge = new FridgeSolver();
        solveFridge.findFirstSolution(fridge);

    }
}
