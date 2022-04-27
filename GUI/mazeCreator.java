package GUI;

import javax.swing.*;
import java.awt.*;

public class mazeCreator extends menu {

    public static void createMazeCreator(){

        JFrame mazeCreatorFrame = new JFrame("Maze Creator");
        mazeCreatorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mazeCreatorFrame.setPreferredSize(new Dimension(600, 500));

        // Adding menu bar to frame
        mazeCreatorFrame.setJMenuBar(menu.createMenuBar());

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

        mazeCreatorFrame.add(mazeEditor);

        // Content panel for viewing maze
        JPanel mazePanel = new JPanel(new GridLayout(6, 2));

        mazeCreatorFrame.pack();
        mazeCreatorFrame.setLocationRelativeTo(null);
        mazeCreatorFrame.setVisible(true);

    }

}