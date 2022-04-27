package GUI;

import javax.swing.*;

public abstract class menu extends JFrame{


    public static JMenuBar createMenuBar(){
        // CREATE MENU BAR
        JMenuBar menuBar = new JMenuBar();
        // File Menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.add("Main Menu");
        fileMenu.add("New Project");
        fileMenu.add("View Projects");
        fileMenu.add("Save");
        fileMenu.add("Export");
        menuBar.add(fileMenu);
        // Edit Menu
        JMenu editMenu = new JMenu("Edit");
        editMenu.add("Undo");
        editMenu.add("Delete");
        menuBar.add(editMenu);
        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add("Getting started with Maze Editor");
        menuBar.add(helpMenu);
        return menuBar;
    }
}