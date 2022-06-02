package GUI;

import javax.swing.*;

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
        viewProjects.addActionListener(e -> {
            mazeList maze_list = new mazeList();
            maze_list.createMazeList();
        });
        JMenuItem save = fileMenu.add("Save");
        JMenuItem export = fileMenu.add("Export");
        menuBar.add(fileMenu);

        // EDIT MENU
        JMenu editMenu = new JMenu("Edit");
        JMenuItem undo = editMenu.add("Undo");
        JMenuItem delete = editMenu.add("Delete");
        menuBar.add(editMenu);

        // HELP MENU
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add("Getting started with Maze Editor");
        menuBar.add(helpMenu);
        return menuBar;
    }
}