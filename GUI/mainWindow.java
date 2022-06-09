package GUI;

import Project.Project;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.SQLException;

public class mainWindow extends menu {

    public static JFrame mainWindowFrame;

    public static Project project = new Project(); // Initialise project

    /**
     * Method to create the main window GUI
     * @param project to create a maze project
     * @throws SQLException SQL server error
     */
    public void createMainWindow(Project project) throws SQLException {
        mainWindowFrame = new JFrame("Maze Creator");
        mainWindowFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindowFrame.setPreferredSize(new Dimension(600, 500));

        // Creating main window label and buttons
        JLabel title = new JLabel("Maze Editor");
        title.setFont(new Font ("Serif", Font.BOLD, 60));
        JButton newProjectBtn = new JButton("New Project");
        JButton viewProjectsBtn = new JButton("View Projects");

        // Main Panel so components are easily centered and organised
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new LineBorder(Color.WHITE, 2));
        mainWindowFrame.setLayout(new GridBagLayout());
        mainWindowFrame.add(mainPanel);

        //Creating label in a separate JPanel
        JPanel labelPanel = new JPanel();
        labelPanel.add(title);
        mainPanel.add(labelPanel, BorderLayout.NORTH);

        //Creating buttons and label in a JPanel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(newProjectBtn);
        buttonsPanel.add(viewProjectsBtn);
        mainPanel.add(buttonsPanel);


        //CREATING POPUP TO CREATE NEW MAZE
        // Main popup panel (incorporates both textPanel and difficultyPanel)
        JPanel popupPanel = new JPanel(new BorderLayout());
        // Panel for Project Title and Author
        JPanel textPanel = new JPanel(new GridLayout(2,2));
        textPanel.add(new JLabel("Project Title:"));
        JTextField titleField = new JTextField(14);
        textPanel.add(titleField);
        textPanel.add(new JLabel("Project Author:"));
        JTextField authorField = new JTextField(14);
        textPanel.add(authorField);
        popupPanel.add(textPanel, BorderLayout.NORTH);
        // Panel for difficulty selection buttons
        JPanel difficultyPanel = new JPanel(new GridLayout(1,3));
        difficultyPanel.add(new JLabel("Difficulty:"));
        JRadioButton standardMazeBtn = new JRadioButton("Standard Maze");
        difficultyPanel.add(standardMazeBtn);
        JRadioButton simpleMazeBtn = new JRadioButton("Simple Maze");
        difficultyPanel.add(simpleMazeBtn);
        // Buttongroup So only one JRadioButton can be selected at a time
        ButtonGroup difficultyButtons = new ButtonGroup();
        difficultyButtons.add(standardMazeBtn);
        difficultyButtons.add(simpleMazeBtn);

        popupPanel.add(difficultyPanel, BorderLayout.CENTER);

        // 'New Project' button functionality
        newProjectBtn.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, popupPanel,
                    "Create New Project", JOptionPane.OK_CANCEL_OPTION);
            project.setTitle(titleField.getText());
            project.setAuthor(authorField.getText());
            if (result == JOptionPane.OK_OPTION) {
                // Fields must be filled in
                 if(titleField.getText().isBlank() || authorField.getText().isBlank()){
                    JOptionPane.showMessageDialog(null, "Error: Please fill out fields before proceeding.");
                }
                // Open standard maze creator window
                else if(standardMazeBtn.isSelected()){
                    mainWindowFrame.setVisible(false);
                    standardMazeCreator.createStandardMaze();

                }
                // Open simple maze creator window
                else if(simpleMazeBtn.isSelected()){
                    mainWindowFrame.setVisible(false);
                    simpleMazeCreator.createSimpleMaze();
                }
                // Maze difficulty must be selected
                else if(!simpleMazeBtn.isSelected() && !standardMazeBtn.isSelected()){
                    JOptionPane.showMessageDialog(null, "Error: Please select a maze difficulty.");
                }
            }
        });


        // 'Open Project' button functionality
        viewProjectsBtn.addActionListener(e -> {
            mainWindowFrame.setVisible(false);
            mazeList.createMazeList();
        });

        mainWindowFrame.pack();
        mainWindowFrame.setLocationRelativeTo(null);
        mainWindowFrame.setResizable(false);
        mainWindowFrame.setVisible(true);

    }
}