package ua.batimyk.fridge;

import java.util.Arrays;

/**
 * Created by NB on 12/16/15.
 *
 */
public class Fridge {

    private byte[][] positions;

    public int getSize() {
        return positions.length * positions[0].length;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (byte[] xAxis : positions) {
            s.append('\n');
            for (byte handlerState : xAxis) {
                if (handlerState == 1) {
                    s.append("1");
                } else if (handlerState == -1) {
                    s.append("0");
                }
            }
        }
        return s.toString();
    }

    public Fridge() {
    }

    public Fridge(Fridge fridge) {
        this.positions = new Fridge(fridge.getPositions()).getPositions();
    }

    Fridge(byte[][] positions) {
        this.positions = new byte[positions.length][];

        for (int x = 0; x < positions.length; x++) {
            this.positions[x] = new byte[positions[0].length];
            System.arraycopy(positions[x], 0, this.positions[x], 0, positions[0].length);
        }
    }


    Fridge turnHandle(int x, int y) {

        for (int i = 0; i < positions.length; i++) {
            positions[i][x] *= -1;
        }
        for (int i = 0; i < positions[x].length; i++) {
            positions[y][i] *= -1;
        }
        positions[y][x] *= -1;

        return this;
    }

    public void setPositions(byte[][] positions) {
        this.positions = positions;
    }

    byte[][] getPositions() {
        return this.positions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        byte[][] otherFridgePos = ((Fridge) o).getPositions();

        return Arrays.deepEquals(otherFridgePos, positions);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(positions);
    }

    boolean isOpen() {

        for (byte[] yAxis : getPositions()) {
            for (byte handlerState : yAxis) {
                if (handlerState != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        byte[][] positions = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};

        Fridge fridge1 = new Fridge(positions);
        Fridge fridge2 = new Fridge(positions);

        System.out.println(fridge1 == fridge2);

        System.out.println(fridge1);
        System.out.println(fridge2.turnHandle(1, 0));
        System.out.println(fridge1);
        System.out.println(fridge2);
    }
}

