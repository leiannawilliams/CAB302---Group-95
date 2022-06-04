package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public abstract class menu extends JFrame{


    public static JMenuBar createMenuBar(){
        // CREATE MENU BAR
        JMenuBar menuBar = new JMenuBar();

        // FILE MENU
        JMenu fileMenu = new JMenu("File");
        JMenuItem mainMenu = fileMenu.add("Main Menu");
        JMenuItem newProject = fileMenu.add("New Project");
        JMenuItem viewProjects = fileMenu.add("View Projects");
        // Action Listener to view list of maze projects (this will direct the user to the maze list window)
        viewProjects.addActionListener(e -> mazeList.createMazeList());
        JMenuItem save = fileMenu.add("Save");
        JMenuItem export = fileMenu.add("Export");
        menuBar.add(fileMenu);

        // EDIT MENU
        JMenu editMenu = new JMenu("Edit");
        JMenuItem rename = editMenu.add("Rename Project");
        // Action Listener to rename project
        rename.addActionListener(e -> {
            String renameProject = JOptionPane.showInputDialog(null, "Rename Project");
        });
        JMenuItem undo = editMenu.add("Undo");
        JMenuItem delete = editMenu.add("Delete");
        menuBar.add(editMenu);

        // HELP MENU
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add("Getting started with Maze Editor");
        menuBar.add(helpMenu);
        return menuBar;
    }

    /**
     * Method to create title panel
     * @param str title
     * @return titlePnl
     */
    public static JPanel titlePanel(String str){
        JPanel titlePnl = new JPanel(new BorderLayout());
        JLabel title = new JLabel(str);
        title.setFont(new Font("Serif", Font.BOLD, 38));
        titlePnl.add(title, BorderLayout.CENTER);
        return titlePnl;
    }

    /**
     * Method to create metrics panel
     * @return metricsPnl
     */
    public static JPanel metricsPanel(){
        JPanel metricsPnl = new JPanel(new GridLayout(3,1));
        metricsPnl.setBorder(BorderFactory.createTitledBorder("Metrics"));
        ((TitledBorder) metricsPnl.getBorder()).setTitleFont(new Font("Serif", Font.BOLD, 20));
        metricsPnl.add(new JLabel("Percentage of cells that are reached by an optimal solution: 50%")); // temporary dummy data
        metricsPnl.add(new JLabel("Percentage of cells that are dead ends: 12%")); // temporary dummy data
        JCheckBox solutionCheckBox = new JCheckBox("Show Optimal Maze Solution");
        metricsPnl.add(solutionCheckBox);
        return metricsPnl;
    }
}