package ua.batimyk.fridge;

/**
 * Created by N on 04/25/16.
 * NVL
 */
public class FridgeNode {
    private Fridge fridge;
    private FridgeNode parentFridgeNode;

    private int x = 0;
    private int y = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FridgeNode that = (FridgeNode) o;

        return fridge != null ? fridge.equals(that.getFridge()) : that.fridge == null;

    }

    @Override
    public int hashCode() {
        return fridge != null ? fridge.hashCode() : 0;
    }

    public FridgeNode() {

    }

    FridgeNode(Fridge fridge) {
        this.fridge = fridge;

    }

    FridgeNode(FridgeNode parentFridgeNode, int x, int y) {
        this.parentFridgeNode = parentFridgeNode;
        this.fridge = new Fridge(parentFridgeNode.getFridge().getPositions()).turnHandle(x, y);
        this.x = x;
        this.y = y;
    }


    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    String getXY() {

        return "[" + x + "," + y + "]";
    }

    public void setX(int x) {
        this.x = x;
    }

    FridgeNode getParentFridgeNode() {
        return parentFridgeNode;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public Fridge getFridge() {
        return fridge;
    }

    @Override
    public String toString() {
        return x + "," + y + fridge.toString() + "\n";
    }

    public static void main(String[] args) {
        byte[][] positions = {{-1, -1}, {-1, -1}};
        byte[][] positions2 = {{-1, -1}, {-1, 1}};
        byte[][] positions3 = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
        byte[][] positions4 = {{-1, -1, -1, -1}, {-1, -1, -1, -1}, {-1, -1, -1, -1}, {-1, -1, -1, -1}};


        Fridge fridge = new Fridge(positions3);

        FridgeNode parentFridgeNode = new FridgeNode(fridge);
        FridgeNode fridgeNode = new FridgeNode(parentFridgeNode, 1, 1);
        FridgeNode fridgeNode2 = new FridgeNode(parentFridgeNode, 1, 1);

        System.out.println(fridgeNode.equals(fridgeNode2));
        System.out.println(fridgeNode == fridgeNode2);
        System.out.println(fridgeNode);
        System.out.println(fridgeNode.getParentFridgeNode());
    }
}
