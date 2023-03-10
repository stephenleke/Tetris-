import java.awt.*;
import java.util.Random;

public class TetrisGame {
    TetrisBrick fallingBrick;
    int[][] background;
    int state;
    int score;
    int rows_number = 20;
    int cols_number = 12;
    int randBrick = 0;

    public TetrisGame () {
        background = new int[this.cols_number][this.rows_number];
        spawnBrick();
    }

    public int initBoard(int rows, int cols) {
        int color = 0;
        color = background[cols][rows];
        return color;
    }
    public int fetchPosition(int rows_number, int cols_number) {
        return background[rows_number][cols_number];
    }

    public int fetchRows() {
        return rows_number;
    }

    public int fetchCols() {
        return cols_number;
    }

    public void setCols_number(int cols_number) {
        this.cols_number = cols_number;
    }

    public void setRows_number(int rows_number) {
        this.rows_number = rows_number;
    }

    public TetrisBrick getFallingBrick() {
        return fallingBrick;
    }

    public void drawFallingBrick(Graphics g, int start_x, int start_y, int cellSize)
    {
        int row = getFallingBrick().position.length - 1;
        if (row >= 0) {
            do {
                int brickStartX = (fallingBrick.position[row][0] * cellSize) + start_x;
                int brickStartY = (fallingBrick.position[row][1] * cellSize) + start_y;

                g.setColor(getFallingBrick().getColorNumber());
                g.fillRect(brickStartX, brickStartY, cellSize, cellSize);
                g.setColor(Color.BLACK);
                g.drawRect(brickStartX, brickStartY, cellSize, cellSize);
                row--;
            } while (row >= 0);
        }
    }

    public void makeMove(int cod) {
        if (cod != (0)) {
        } else {
            fallingBrick.moveDown();
            if(!validateMove()) {
                spawnBrick();
            }
        }

        if (cod == 2) {
            fallingBrick.rotate();
            if(!validateMove()) {
                spawnBrick();
            }
        }

        if (cod != (1)) {
        } else {
            fallingBrick.moveLeft();
            if(!validateMove()) {
                spawnBrick();
            }
        }

        if(!(cod != (-1))) {
            fallingBrick.moveRight();
            if(!validateMove()) {
                spawnBrick();
            }
        }
    }


    public boolean validateMove() {
        int numSegments =4;
        int[][] brickPosition = getFallingBrick().position;

        //checking down boundary
        if(fallingBrick.getBottomLine() >= rows_number) {
            return false;
        }
        //checking left and right boundary
        int seg = 0;
        if (seg < numSegments) {
            do {
                if (brickPosition[seg][0] == cols_number || (brickPosition[seg][0] < 0))
                    return false;
                seg++;
            } while (seg < numSegments);
        }
        //validating colors
        seg = 0;
        if (seg < numSegments) {
            do {
                int row = brickPosition[seg][0];
                int col = brickPosition[seg][1];

                if (background[row][col] <= 0) {
                    seg++;
                } else {
                    return false;
                }
            } while (seg < numSegments);
        }
        return true;
    }

    public void transferColor()
    {
        int numSegments = 4;
        int[][] pos = getFallingBrick().getPosition();

        int orangeCol = 2;
        int redCol = 3;
        int greenCol = 4;
        int yellowCol = 5;
        int magentaCol = 6;
        int cyanCol = 7;
        int blueCol = 8;

        int seg = numSegments - 1;
        if (seg >= 0) {
            do {
                int col = pos[seg][0];
                int row = pos[seg][1];

                if (randBrick != 0) {
                    if (randBrick == 1) {
                        background[col][row] = redCol;
                    } else if (randBrick == 2) {
                        background[col][row] = greenCol;
                    } else if (randBrick == 3) {
                        background[col][row] = yellowCol;
                    } else if (randBrick == 4) {
                        background[col][row] = magentaCol;
                    } else if (randBrick == 5) {
                        background[col][row] = cyanCol;
                    } else if (randBrick == 6) {
                        background[col][row] = blueCol;
                    }
                } else {
                    background[col][row] = orangeCol;
                }
                seg--;
            } while (seg >= 0);
        }
    }

    public void spawnBrick() {
        Random randomGen = new Random();
        int randBound = 7;
        randBrick = randomGen.nextInt(randBound);
        int orient = 0;
        int numseg = 4;

        if (randBrick == 0) {
            fallingBrick = new ElBrick(cols_number, orient, numseg, Color.ORANGE);
        } else if (randBrick == 1) {
            fallingBrick = new LongBrick(cols_number, orient, numseg, Color.RED);
        } else if (randBrick == 2) {
            fallingBrick = new JayBrick(cols_number, orient, numseg, Color.GREEN);
        } else if (randBrick == 3) {
            fallingBrick = new EssBrick(cols_number, orient, numseg, Color.YELLOW);
        } else if (randBrick == 4) {
            fallingBrick = new StackBrick(cols_number, orient, numseg, Color.MAGENTA);
        } else if (randBrick == 5) {
            fallingBrick = new ZeeBrick(cols_number, orient, numseg, Color.CYAN);
        } else if (randBrick == 6) {
            fallingBrick = new SquareBrick(cols_number, orient, numseg, Color.BLUE);
        }
    }

    public void newGame() {
        int col = cols_number - 1;
        if (col < 0) {
        } else {
            do {
                int row = rows_number - 1;
                if (row >= 0) {
                    do {
                        background[col][row] = 0;
                        row--;
                    } while (row >= 0);
                }
                col--;
            } while (col >= 0);
        }
        spawnBrick();
    }

    public String toString() {
        String stuff = "";
        return stuff;
    }
}
