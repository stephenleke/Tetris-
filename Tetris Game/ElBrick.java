import java.awt.*;

public class ElBrick extends TetrisBrick {
    public ElBrick(int col, int orient, int numseg, Color clr) {

        super(col, orient, numseg, clr);
        initPosition(col);
    }

    @Override
    public int[][] initPosition(int cols) {
        int startingColumn = 7;
        int position[][] = {{startingColumn, 0}, {startingColumn, 1}, {startingColumn - 1, 1}, {startingColumn - 2, 1}};
        return position;
    }

    public void rotate() {

    }

    @Override
    public void unrotate() {

    }
}
