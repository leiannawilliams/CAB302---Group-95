package GUI;

import javax.swing.*;
import java.awt.*;

public class mainWindow extends menu {

    public static void createMainWindow() {
        JFrame mainWindow = new JFrame("Maze Creator");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setPreferredSize(new Dimension(600, 500));

        // Adding menu bar to frame
        mainWindow.setJMenuBar(menu.createMenuBar());

        //Creating main window label and buttons
        mainWindow.add(new JLabel("Maze Editor"));
        JButton startProjectBtn = new JButton("Start Project");
        mainWindow.add(startProjectBtn);
        JButton openProjectBtn = new JButton("Open Project");
        mainWindow.add(openProjectBtn);
        //startProjectBtn.addActionListener(new EventHandler());

        mainWindow.pack();
        mainWindow.setVisible(true);

    }

}