package GUI;

import javax.swing.*;
import java.awt.*;

public class mazeCreator extends menu{

    public static void createMazeCreator(){

        JFrame mazeCreator = new JFrame("Maze Creator");
        mazeCreator.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mazeCreator.setPreferredSize(new Dimension(600, 500));

        // Content pane for maze editor
        JTabbedPane mazeEditor = new JTabbedPane();

        // Details tab contents
        JPanel detailsPanel = new JPanel();
        detailsPanel.add(new JLabel("Project Name: "));
        detailsPanel.add(new JTextField(6));
        detailsPanel.add(new JLabel("Creator: "));
        detailsPanel.add(new JTextField(6));

        // Style tab contents
        JPanel stylePanel = new JPanel();
        stylePanel.add(new JLabel("Start image: "));
        stylePanel.add(new JButton("Browse"));
        stylePanel.add(new JLabel("End image: "));
        stylePanel.add(new JButton("Browse"));

        // Add tabbed panes
        mazeEditor.add("Details", detailsPanel);
        mazeEditor.add("Style", stylePanel);

        mazeCreator.add(mazeEditor);

        // Content panel for viewing maze
        JPanel mazePanel = new JPanel(new GridLayout(6, 2));

        mazeCreator.pack();
        mazeCreator.setVisible(true);

    }
}