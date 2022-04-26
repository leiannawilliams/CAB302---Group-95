import javax.swing.*;
import java.awt.*;

public class guiComponents extends JFrame{
    static void createStartWindow(){
        JFrame startWindow = new JFrame("Maze Creator");
        startWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        startWindow.setPreferredSize(new Dimension(600, 500));

        /* Add components to start window */
        JButton startProjectBtn = new JButton("Start Project");
        JButton openProjectBtn = new JButton("Open Project");
        startWindow.add(new JLabel("Maze Editor"));
        startWindow.add(startProjectBtn);
        startProjectBtn.addActionListener(new EventHandler());
        /* startWindow.add(openProjectBtn); */

        startWindow.pack();
        startWindow.setVisible(true);
    }

    static void createMainWindow(){
        JFrame jframe = new JFrame("Maze Creator");
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setPreferredSize(new Dimension(600, 500));

        /* Create menu bar items */
        JMenuBar menuBar = new JMenuBar();
        /* File Menu */
        JMenu fileMenu = new JMenu("File");
        fileMenu.add("New Project");
        fileMenu.add("Open Project");
        fileMenu.add("Save");
        fileMenu.add("Export");
        menuBar.add(fileMenu);
        /* Edit Menu */
        JMenu editMenu = new JMenu("Edit");
        editMenu.add("Undo");
        editMenu.add("Delete");
        menuBar.add(editMenu);
        /* Help Menu */
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add("Getting started with Maze Editor");
        menuBar.add(helpMenu);

        jframe.setJMenuBar(menuBar);

        /* Content pane for maze editor */
        JTabbedPane mazeEditor = new JTabbedPane();
        /* Details tab contents */
        JPanel detailsPanel = new JPanel();
        detailsPanel.add(new JLabel("Project Name: "));
        detailsPanel.add(new JTextField(6));
        detailsPanel.add(new JLabel("Creator: "));
        detailsPanel.add(new JTextField(6));
        /* Style tab contents */
        JPanel stylePanel = new JPanel();
        stylePanel.add(new JLabel("Start image: "));
        stylePanel.add(new JButton("Browse"));
        stylePanel.add(new JLabel("End image: "));
        stylePanel.add(new JButton("Browse"));
        /* Add tabbed panes */
        mazeEditor.add("Details", detailsPanel);
        mazeEditor.add("Style", stylePanel);

        jframe.add(mazeEditor);

        /* Content panel for viewing maze */
        JPanel mazePanel = new JPanel(new GridLayout(6, 2));

        jframe.pack();
        jframe.setVisible(true);
    }
}
