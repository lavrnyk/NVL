package ua.batimyk.fridge;


import java.util.*;

/**
 * Created by N on 12/21/15.
 */
public class FridgeSolverSmall {

    private List<FridgeNode> fridgeNodes = new ArrayList<>();
    private List<FridgeNode> solvedFridgeNodes = new ArrayList<>();


    private List<FridgeNode> turnAllHandlers(FridgeNode parentFridgeNode) {
        List<FridgeNode> fridgeNodes = new ArrayList<>();

        for (int y = 0; y < parentFridgeNode.getFridge().getPositions().length; y++) {
            for (int x = 0; x < parentFridgeNode.getFridge().getPositions()[y].length; x++) {
                FridgeNode fridgeNode = new FridgeNode(parentFridgeNode, x, y);
                fridgeNodes.add(fridgeNode);
            }
        }
        return fridgeNodes;
    }

    private void iterateFridge(FridgeNode fridgeNode) {

        fridgeNodes.add(fridgeNode);

        if (fridgeNode.getFridge().isOpen()) {
            solvedFridgeNodes.add(fridgeNode);
        } else {
            for (FridgeNode fnode : turnAllHandlers(fridgeNode)) {

                if (fnode.getFridge().isOpen()) {
                    solvedFridgeNodes.add(fnode);
                    //System.out.println(fridgeNodes.size() - 1);
                    //System.out.println("Open!");
                } else if (!fridgeNodes.contains(fnode)) {
                    iterateFridge(fnode);
                }
            }
        }
    }

    private List<FridgeNode> getSolvedFridges(FridgeNode firstFridgeNode) {
        iterateFridge(firstFridgeNode);
        return solvedFridgeNodes;

    }

    private List<FridgeNode> getStateChangeSequence(FridgeNode lastFridgeNode, FridgeNode firstFridgeNode) {
        List<FridgeNode> fridgesStateChangeSequence = new ArrayList<>();

        while (!lastFridgeNode.equals(firstFridgeNode)) {
            fridgesStateChangeSequence.add(lastFridgeNode);
            lastFridgeNode = lastFridgeNode.getParentFridgeNode();
        }
        Collections.reverse(fridgesStateChangeSequence);

        return fridgesStateChangeSequence;

    }

    public void printAllSolutions(FridgeNode firstFridgeNode) {
        List<FridgeNode> solvedFridgeNodes = getSolvedFridges(firstFridgeNode);

        for (int i = 0; i < solvedFridgeNodes.size(); i++) {
            int turnCount = getStateChangeSequence(solvedFridgeNodes.get(i), firstFridgeNode).size();
            System.out.println("Solution #:" + i + ", turns: " + turnCount);
            for (FridgeNode fn : getStateChangeSequence(solvedFridgeNodes.get(i), firstFridgeNode)) {
                System.out.println(fn);
            }
        }
    }

    public List<String> getMinTurnSolutions(FridgeNode firstFridgeNode) {
        List<FridgeNode> solvedFridgeNodes = getSolvedFridges(firstFridgeNode);
        List<String> turnChain = new ArrayList<>();

        int minTurnIndex = 0;
        int minTurnCount = getStateChangeSequence(solvedFridgeNodes.get(minTurnIndex), firstFridgeNode).size();

        for (int i = 1; i < solvedFridgeNodes.size(); i++) {
            int turnCount = getStateChangeSequence(solvedFridgeNodes.get(i), firstFridgeNode).size();
            if (minTurnCount > turnCount) {
                minTurnCount = turnCount;
                minTurnIndex = i;
            }
        }

        int i = 1;
        for (FridgeNode fn : getStateChangeSequence(solvedFridgeNodes.get(minTurnIndex), firstFridgeNode)) {
            turnChain.add(i++ + ": " + fn.getXY());
        }

        return turnChain;
    }

    public static void main(String[] args) {

        byte[][] positions = {{-1, -1}, {-1, -1}};
        byte[][] positions2 = {{-1, -1}, {-1, 1}};
        byte[][] positions23 = {{-1, -1}, {-1, 1}, {-1, -1}};
        byte[][] positions32 = {{-1, -1, -1}, {-1, -1, -1}};
        byte[][] positions3 = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
        byte[][] positions3_1turn = {{1, -1, 1}, {-1, -1, -1}, {1, -1, 1}};
        byte[][] positions4 = {{-1, -1, -1, -1}, {-1, -1, -1, -1}, {-1, -1, -1, -1}, {-1, -1, -1, -1}};
        byte[][] positions3Open = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        byte[][] positions4Open = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        byte[][] positions4_1turn = {{1, -1, 1, 1}, {1, -1, 1, 1}, {-1, -1, -1, -1}, {1, -1, 1, 1}};
        byte[][] initPositions = {{1, 1, -1, 1}, {1, 1, -1, 1}, {-1, -1, 1, -1}, {1, 1, 1, -1}};
        FridgeSolverSmall fridgeSolverSmall = new FridgeSolverSmall();
        FridgeNode firstFridgeNode = new FridgeNode(new Fridge(initPositions));

        //fridgeSolverSmall.printAllSolutions(firstFridgeNode);

        for(String s : fridgeSolverSmall.getMinTurnSolutions(firstFridgeNode)) {
            System.out.println(s);
        }
    }
}
