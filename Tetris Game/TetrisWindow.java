import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TetrisWindow extends JFrame {
    private TetrisGame game;
    private TetrisDisplay display;

    private int win_width = 432;
    private int win_height = 721;

    public TetrisWindow() {
        this.setTitle("Tetris");
        this.setSize(win_width, win_height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        game = new TetrisGame();
        display = new TetrisDisplay(game);
        this.add(display);
        initMenu();
        this.setVisible(true);
    }

    public void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu men1 = new JMenu("Board size");
        menuBar.add(men1);
        JMenu men2 = new JMenu("new game");
        menuBar.add(men2);
        JMenu men3 = new JMenu("save game");
        menuBar.add(men3);
        JMenu men4 = new JMenu("scores");
        menuBar.add(men4);

        JMenuItem item1  = new JMenuItem("new size");
        men1.add(item1);
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JMenuItem item2  = new JMenuItem("new size2");
        men1.add(item2);
        JMenuItem item3  = new JMenuItem("Delete high scores");
        men4.add(item3);
        JMenuItem item4  = new JMenuItem("Display high scores");
        men4.add(item4);
        JMenuItem item5  = new JMenuItem("Start new game");
        men2.add(item5);
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.newGame();
            }
        });
    }
    public static void main(String[] args) {
        new TetrisWindow();
    }
}
