package Maze;

/* Maze generation algorithm
 * Andras Szabo. (2019). Retrieved from: https://github.com/bandi22/java-swing-maze
 */

import javax.swing.*;
import java.awt.*;

public class Drawing extends JPanel{

    int mazeSize; // Size of maze

    /**
     * Class constructor which retrieves size input needed to generate the maze
     * @param jtf size of maze specified by user input
     */
    public Drawing(JTextField jtf)
    {
        try {
            // Retrieve size of maze from user input
            this.mazeSize = Integer.parseInt(jtf.getText());
        }

        catch (Exception e)
        {
            // Show error message if user tries to generate maze without first specifying the size
            JOptionPane.showMessageDialog(this, "ERROR!  Invalid size value!");
        }
    }

    /**
     * Method used by the scroll pane to adjust its own dimensions
     * @return new dimensions of scroll pane
     */
    public Dimension getPreferredSize() {
        return new Dimension((mazeSize*10)+1,(mazeSize*10)+1);
    }

    /**
     * Method to draw the maze
     * @param g graphics
     */
    public void drawMaze (Graphics g)
    {
        Grid grid = new Grid();
        grid.generate(mazeSize);
        grid.createMaze(grid);

        for (int i = 0; i < grid.cells.length; i++) {
            //west
            if (grid.cells[i].wallW == true)
            {
                g.drawLine((grid.cells[i].x*10), (grid.cells[i].y*10), (grid.cells[i].x*10)+10, (grid.cells[i].y*10));
            }
            //south
            if (grid.cells[i].wallS == true)
            {
                g.drawLine((grid.cells[i].x*10)+10, (grid.cells[i].y*10), (grid.cells[i].x*10)+10, (grid.cells[i].y*10)+10);
            }
            //east
            if (grid.cells[i].wallE == true)
            {
                g.drawLine((grid.cells[i].x*10)+10, (grid.cells[i].y*10)+10, (grid.cells[i].x*10), (grid.cells[i].y*10)+10);
            }
            //north
            if (grid.cells[i].wallN == true)
            {
                g.drawLine((grid.cells[i].x*10), (grid.cells[i].y*10)+10, (grid.cells[i].x*10), (grid.cells[i].y*10));
            }
        } //for

    } //drawMaze

    /**
     * Method which is invoked to start drawing the maze on the scrollPanel
     * @param g graphics component
     */
    @Override
    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        drawMaze(g);


    }
}
