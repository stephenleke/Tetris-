import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TetrisDisplay extends JPanel {
    private TetrisGame game;
    private int start_y = 40;
    private int start_x = 40;
    int cell_size = 30;

    private static int delay = 190;
    private Color[] colors = {Color.WHITE, Color.BLACK, Color.ORANGE, Color.RED, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.BLUE};
    public TetrisDisplay(TetrisGame gam) {
        game = gam;
        Timer  counter;
        counter = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processMove();
                if(!game.validateMove()) {
                    game.fallingBrick.moveUp();
                    game.transferColor();
                    game.spawnBrick();
                }
                repaint();
            }
        });
        counter.start();

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                translateKey(e);
            }
        });
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(true);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        int x;
        int y = start_y;
        //drawing and painting the 12 X 20 board
        for (int row = 0; row < game.fetchRows(); row++) {
            x = start_x;
            for (int col = 0; col < game.fetchCols(); col++) {
                g.setColor(colors[0]);
                g.fillRect(x, y, cell_size, cell_size);
                x += cell_size;
            }
            y += cell_size;
        }

        g.setColor(colors[1]);
        game.drawFallingBrick(g, start_x, start_y, cell_size);
        //drawing the borders of the board
        g.fillRect(start_x - cell_size, start_y, cell_size, game.fetchRows() * cell_size);
        g.fillRect(start_x + game.fetchCols() * cell_size, start_y, cell_size, game.fetchRows() * cell_size);
        g.fillRect(start_x - cell_size, start_y + game.fetchRows() * cell_size, (game.fetchCols() + 2) * (cell_size), cell_size);

        for(int row = game.fetchRows() - 1; row >= 0; row--) {
            for(int col = game.fetchCols() - 1; col >= 0; col--) {
                int cellColor = game.initBoard(row, col);
                if (cellColor <= 0) {
                    continue;
                }
                g.setColor(colors[cellColor]);
                g.fillRect(start_x + col*cell_size, start_y + row*cell_size, cell_size, cell_size);
                g.setColor(colors[1]);
                g.drawRect(start_x + col*cell_size, start_y + row*cell_size, cell_size, cell_size);
            }
        }
    }

    public void processMove() {
        game.fallingBrick.moveDown();
    }

    public void translateKey(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                game.makeMove(0);
                break;
            default:
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> game.makeMove(1);
                }
                break;
        }
        repaint();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT -> game.makeMove(-1);
        }
        repaint();
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            game.makeMove(2);
        }
        repaint();
    }
}
