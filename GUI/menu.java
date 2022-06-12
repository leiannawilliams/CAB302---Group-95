package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import static GUI.mainWindow.mainWindowFrame;
import static GUI.mainWindow.project;
import static GUI.standardMazeCreator.*;

public abstract class menu extends JFrame{

    public static int generateInt = 0;
    /**
     * Method to create the file menu bar
     * @return menuBar
     */
    public static JMenuBar createMenuBar(){
        
        // CREATE MENU BAR
        JMenuBar menuBar = new JMenuBar();

        // FILE MENU
        JMenu fileMenu = new JMenu("File");
        JMenuItem mainMenu = fileMenu.add("Main Menu");
        // Action Listener to open main window frame
        mainMenu.addActionListener( e -> mainWindowFrame.setVisible(true));
        JMenuItem viewProjects = fileMenu.add("View Projects");
        // Action Listener to view list of maze projects (this will direct the user to the maze list window)
        viewProjects.addActionListener(e -> mazeList.createMazeList());
        JMenuItem save = fileMenu.add("Save");
        JMenuItem export = fileMenu.add("Export");
        // Action listener to export maze as image file
        export.addActionListener(e -> {
            if (generateInt == 0){
                JOptionPane.showMessageDialog(null, "Error: Please generate a new maze first.");
            }
            if (generateInt == 1){
                JFileChooser jfc = new JFileChooser();
                jfc.setFileFilter(new FileNameExtensionFilter("Image (jpeg, jpg, png)", "jpeg", "jpg", "png"));

                jfc.setDialogTitle("Save maze as image");
                int saveResult = jfc.showSaveDialog(export);

                BufferedImage componentImage = new BufferedImage(mazePane.getWidth(), mazePane.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = componentImage.createGraphics();
                mazePane.paint(g2d);

                File imageFile = jfc.getSelectedFile();
                File imageFileJPG = new File(imageFile.toString()+".jpg");

                try
                {
                    if (saveResult == JFileChooser.APPROVE_OPTION)
                    {
                        ImageIO.write(componentImage, "jpg", imageFileJPG);
                    }

                }
                catch (IOException ioe)
                {
                    JOptionPane.showMessageDialog(jfc, "I/O Error!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "No mazes to export!");
            }
        });
        menuBar.add(fileMenu);
        // Catches SQLException to save the current project to the mazeList table of the database
        save.addActionListener(e -> {
            try {
                Project.Project.updateDatabase(project.getTitle(), project.getAuthor(), project.setCreationDate(), project.setLastEdit());
            } catch (SQLException ex) {
                return;
            }
        });

        // EDIT MENU
        JMenu editMenu = new JMenu("Edit");
        JMenuItem rename = editMenu.add("Rename Project");
        // Action Listener to rename project
        rename.addActionListener(e -> {
            String renameProject = JOptionPane.showInputDialog(null, "Rename Project");
            project.setTitle(renameProject);
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
     * @param str type of maze creator - standard or simple
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
     * Method to create the details panel
     * @return detailsPnl
     */
    public static JPanel detailsPanel(){
        JPanel detailsPnl = new JPanel(new GridLayout(4,2));
        detailsPnl.setBorder(BorderFactory.createTitledBorder("Details"));
        ((TitledBorder) detailsPnl.getBorder()).setTitleFont(new Font("Serif", Font.BOLD, 20));
        detailsPnl.add(new JLabel("Project Title: "));
        JTextField titleField = new JTextField(14);
        titleField.setText(project.getTitle());
        titleField.setEditable(false);
        detailsPnl.add(titleField);
        detailsPnl.add(new JLabel("Project Author: "));
        JTextField authorField = new JTextField(14);
        authorField.setText(project.getAuthor());
        authorField.setEditable(false);
        detailsPnl.add(authorField);
        detailsPnl.add(new JLabel("Creation Date: "));
        JTextField creationField = new JTextField(14);
        creationField.setText(project.setCreationDate());
        creationField.setEditable(false);
        detailsPnl.add(creationField);
        detailsPnl.add(new JLabel("Last Edited: "));
        JTextField editedField = new JTextField(14);
        editedField.setText(project.setLastEdit());
        editedField.setEditable(false);
        detailsPnl.add(editedField);
        return detailsPnl;
    }


    /**
     * Method to create generate panel in standard maze creator
     * @param sizeInput size of maze determined by user input
     * @return generatePnl
     */
    public static JPanel generatePanel(JTextField sizeInput){
        JPanel generatePnl = new JPanel();
        JPanel buttonPanel = new JPanel();
        JButton generateButton = new JButton(new AbstractAction("Generate Maze") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = sizeInput.getText();
                int mazeSizeInput = Integer.parseInt(text);
                mazeSizeInput = ((mazeSizeInput+5)/10)*10+1; //rounds maze to the nearest working size.
                mazePane.refresh(mazeSizeInput);
                mazePane.repaint();
            }
        });

        generateButton.setFont(new Font("Serif", Font.BOLD, 20));
        buttonPanel.add(generateButton);
        generatePnl.setLayout(new GridBagLayout());
        generatePnl.add(buttonPanel);

        // Generate button functionality
        generateButton.addActionListener(ae -> {
            generateInt = 1;

        });
        return generatePnl;
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

        solutionCheckBox.addActionListener(e -> {

            if(generateInt == 0){
                JOptionPane.showMessageDialog(null, "Error: Please generate a new maze first.");
            }

            if (solutionCheckBox.isSelected() & generateInt == 1) {
                    mazePane.autoMove((Graphics2D) mazePane.getGraphics());
                }
            else if(!solutionCheckBox.isSelected()& generateInt == 1){
                mazePane.repaint();
            }
        });

        metricsPnl.add(solutionCheckBox);
        return metricsPnl;
    }


    /**
     * Method to create generate panel in simple maze creator
     * @return generatePnl
     */
    public static JPanel generatePanel(){
        JPanel generatePnl = new JPanel();
        JPanel buttonPanel = new JPanel();
        JButton generateButton = createButton("Generate Maze", EventHandler::generateButtonClicked);
        buttonPanel.add(generateButton);
        generatePnl.setLayout(new GridBagLayout());
        generatePnl.add(buttonPanel);
        return generatePnl;
    }

    /**
     * Method to create a JButton
     * @param str Button title
     * @param listener event listener
     * @return button
     */
    public static JButton createButton(String str, ActionListener listener){
        //Create JButton
        JButton button = new JButton();
        //Set button text
        button.setText(str);
        //Set button font
        button.setFont(new Font("Serif",Font.BOLD,18));
        //Add listener
        button.addActionListener(listener);
        //Return button
        return button;
    }
}