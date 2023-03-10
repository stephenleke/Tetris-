import java.awt.*;

public class ZeeBrick extends TetrisBrick{
    public ZeeBrick(int col, int orient, int numseg, Color clr) {

        super(col, orient, numseg, clr);
        initPosition(col);
    }
    @Override
    public int[][] initPosition(int cols) {
        int startingColumn = 7;
        int position[][] = {{startingColumn+1, 1}, {startingColumn, 1}, {startingColumn, 0}, {startingColumn-1, 0}};
        return position;
    }

    public void rotate() {

    }

    public void unrotate() {

    }
}
