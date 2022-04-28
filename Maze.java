import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Maze{
    int col = 10;
    int rows = 10;
    int startPos = 0;
    int finishPos = 50;
    ArrayList<Integer> walls = null;

    /**
     * The Maze class consists of all the required parameters to create the maze.
     * @width width of the maze as an integer.
     * @height height of the maze as an integer.
     * @col number of column cells in the maze with a maximum of 100 cells.
     * @rows number of row cells in the maze with a maximum of 100 cells.
     * @neighbours ?
     * @visitedCells ?
     */

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
