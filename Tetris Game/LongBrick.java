import java.awt.*;

public class LongBrick extends TetrisBrick {
    public LongBrick(int col, int orient, int numseg, Color clr) {

        super(col, orient, numseg, clr);
        initPosition(col);
    }
    @Override
    public int[][] initPosition(int cols) {
        int startingColumn = 7;
        int position[][] = {{startingColumn, 0}, {startingColumn-1, 0}, {startingColumn-2, 0}, {startingColumn-3, 0}};
        return position;
    }

    public void rotate() {

    }
    public void unrotate() {

    }
}
