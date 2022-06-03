package Maze;

import javax.swing.*;
import java.awt.*;

public class Drawing extends JPanel{

    int mazeSize;

    public Drawing(JTextField jtf)
    {
        try {
            this.mazeSize = Integer.parseInt(jtf.getText());
        }

        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "ERROR!  Invalid size value!");
        }
    } //constructor

    public Dimension getPreferredSize() {
        return new Dimension((mazeSize*10)+1,(mazeSize*10)+1);
    } //getPreferredSize - this method is used by the scroll pane to adjust its own size automatically

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

    @Override
    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        drawMaze(g);


    }//paintComponent() @Override method
}
