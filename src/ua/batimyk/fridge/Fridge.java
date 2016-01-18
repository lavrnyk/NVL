package ua.batimyk.fridge;

/**
 * Created by N on 12/16/15.
 */
public class Fridge {

    private byte[][] positions = {
            {1, 1, 1, 1}
            , {1, 1, 1, 1}
            , {1, 1, 1, 1}
            , {1, 1, 1, 1}
    };

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

    public Fridge(byte[][] positions) {
        this.positions = positions;
    }


    public Fridge turnHandle(int x, int y) {
        for (int i = 0; i < this.positions.length; i++) {
            this.positions[x][i] *= -1;
        }
        for (int i = 0; i < this.positions[x].length; i++) {
            this.positions[i][y] *= -1;
        }
        this.positions[x][y] *= -1;

        return Fridge.this;
    }

    public void setPositions(byte[][] positions) {
        this.positions = positions;
    }

    public byte[][] getPositions() {
        return this.positions;
    }

    public boolean isOpen() {

        for (byte[] yAxis : getPositions()) {
            for (byte handlerState : yAxis) {
                if (handlerState != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

