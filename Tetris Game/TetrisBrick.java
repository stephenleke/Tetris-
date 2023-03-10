import java.awt.*;
import java.util.Arrays;

public abstract class TetrisBrick {
    int[][] position; {
        position = new int[4][2];
    }
    public int orientation;
    int numSegments;
    private Color colorNum;

    public TetrisBrick(int col, int orient, int numseg, Color clr) {
        this.position = initPosition(col);
        this.orientation = orient;
        this.numSegments = numseg;
        this.colorNum = clr;
    }

    public abstract int[][] initPosition(int col);

    public void setColorNumber(Color clr) {
        colorNum = clr;
    }

    public int[][] getPosition() {
        return position;
    }

    public Color getColorNumber() {
        return colorNum;
    }

    public void moveLeft() {
        int seg = position.length - 1;
        if (seg < 0) {
            return;
        }
        do {
            position[seg][0] -= 1;
            seg--;
        } while (seg >= 0);
    }

    public void moveRight() {
        int seg = position.length - 1;
        if (seg > 0) {
            do {
                position[seg][0] += 1;
                seg--;
            } while (seg >= 0);
        }
    }

    public boolean moveDown() {
        int row = position.length - 1;
        if (row >= 0) {
            do {
                position[row][1] += 1;
                row--;
            } while (row >= 0);
        }
        return true;
    }

    public boolean moveUp() {
        int row = position.length - 1;
        if (row >= 0) {
            do {
                position[row][1] -= 1;
                row--;
            } while (row >= 0);
        }
        return true;
    }

    public int getBottomLine() {
        int bottomRow = Arrays.stream(position).mapToInt(position1 -> position1[1]).filter(position1 -> position1 >= 0).max().orElse(0);

        return bottomRow;
    }

    public abstract void rotate();

    public abstract void unrotate();
}