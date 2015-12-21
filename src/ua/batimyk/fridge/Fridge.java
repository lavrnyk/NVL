package ua.batimyk.fridge;

/**
 * Created by N on 12/16/15.
 */
public class Fridge {

    private int[][] positions = {
              {1, 1, 1, 1}
            , {1, 1, 1, 1}
            , {1, 1, 1, 1}
            , {1, 1, 1, 1}
    };


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int[] yAxis : positions) {
            s.append('\n');
            for (int handlerState : yAxis) {
                if(handlerState == 1) s.append("1");
                else if (handlerState == -1) s.append("0");
            }
        }
        return s.toString();
    }

    public Fridge() {
    }

    public Fridge(int[][] positions) {
        this.positions = positions;
    }


    public void turnHandle(int x, int y) {
        for (int i = 0; i < this.positions.length; i++) {
            this.positions[x][i] *= -1;
        }
        for (int i = 0; i < this.positions[x].length; i++) {
            this.positions[i][y] *= -1;
        }
        this.positions[x][y] *= -1;
    }

    public void setPositions(int[][] positions) {
        this.positions = positions;
    }

    public int[][] getPositions() {
        return this.positions;
    }

    public boolean isOpen () {

        for (int[] yAxis : getPositions()) {
            for (int handlerState : yAxis) {
                if(handlerState != 1) return false;
            }
        }
        return true;
    }
}

