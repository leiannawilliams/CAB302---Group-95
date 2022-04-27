import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Maze{
    int col = 10;
    int rows = 10;
    int startPos = 0;
    int finishPos = 50;
    ArrayList<Integer> walls = null;

    public static void drawGrid(Graphics grid){
        grid.setColor(Color.BLACK);
        grid.drawLine(0, 0, 200, 10);
    }

    public static void testMaze(){
        JFrame testMazeFrame = new JFrame("Test Maze");
        testMazeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        testMazeFrame.setPreferredSize(new Dimension(1500, 800));

        // Maze
        JPanel mazePanel = new JPanel();
        testMazeFrame.add(mazePanel);

        testMazeFrame.pack();
        testMazeFrame.setVisible(true);
    }
}
