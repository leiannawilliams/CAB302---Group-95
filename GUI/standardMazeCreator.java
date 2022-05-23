package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class standardMazeCreator extends menu {

    public static void createStandardMaze(){

        JFrame mazeCreatorFrame = new JFrame("Maze Creator");
        mazeCreatorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mazeCreatorFrame.setPreferredSize(new Dimension(1500, 800));

        // Adding menu bar to frame
        mazeCreatorFrame.setJMenuBar(menu.createMenuBar());



        // Maze Editor and Details -- Left side of Split Pane -- Pane 1
        JPanel pane1 = new JPanel(new GridLayout(5, 1));
        // Title
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Standard Maze Creator");
        title.setFont(new Font ("Serif", Font.BOLD, 38));
        titlePanel.add(title, BorderLayout.CENTER);
        pane1.add(titlePanel);
        // Details contents
        JPanel detailsPanel = new JPanel(new GridLayout(4,2));
        detailsPanel.setBorder(BorderFactory.createTitledBorder("Details"));
        ((TitledBorder) detailsPanel.getBorder()).setTitleFont(new Font("Serif", Font.BOLD, 20));
        detailsPanel.add(new JLabel("Project Title: "));
        JTextField titleField = new JTextField(14);
        titleField.setText("Awesome Maze"); // temporary dummy data
        detailsPanel.add(titleField);
        detailsPanel.add(new JLabel("Project Author: "));
        JTextField authorField = new JTextField(14);
        authorField.setText("Bob Ross"); // temporary dummy data
        detailsPanel.add(authorField);
        detailsPanel.add(new JLabel("Creation Date: "));
        JTextField creationField = new JTextField(14);
        creationField.setText("27-04-2022 11:27:03"); // temporary dummy data
        creationField.setEditable(false);
        detailsPanel.add(creationField);
        detailsPanel.add(new JLabel("Last Edited: "));
        JTextField editedField = new JTextField(14);
        editedField.setText("27-04-2022 11:27:03"); // temporary dummy data
        editedField.setEditable(false);
        detailsPanel.add(editedField);
        pane1.add(detailsPanel);
        // Style contents
        JPanel stylePanel = new JPanel(new GridLayout(1,1));
        stylePanel.setBorder(BorderFactory.createTitledBorder("Style"));
        ((TitledBorder) stylePanel.getBorder()).setTitleFont(new Font("Serif", Font.BOLD, 16));
        JLabel imageText = new JLabel("  Logo Image:");
        imageText.setFont(new Font ("Serif", Font.PLAIN, 20));
        stylePanel.add(imageText);
        JPanel selectedImgPanel = new JPanel();
        selectedImgPanel.setLayout(new GridBagLayout());
        JTextField selectedImg = new JTextField("Browse for image");
        selectedImgPanel.add(selectedImg);
        stylePanel.add(selectedImgPanel);
        JPanel browseButtonPanel = new JPanel();
        browseButtonPanel.setLayout(new GridBagLayout());
        JButton browseButton = new JButton("Browse");
        browseButton.setFont(new Font("Serif", Font.PLAIN, 20));
        browseButtonPanel.add(browseButton);
        stylePanel.add(browseButtonPanel);
        pane1.add(stylePanel);
        //Metrics contents
        JPanel metricsPanel = new JPanel(new GridLayout(3,1));
        metricsPanel.setBorder(BorderFactory.createTitledBorder("Metrics"));
        ((TitledBorder) metricsPanel.getBorder()).setTitleFont(new Font("Serif", Font.BOLD, 20));
        metricsPanel.add(new JLabel("Percentage of cells that are reached by an optimal solution: 50%")); // temporary dummy data
        metricsPanel.add(new JLabel("Percentage of cells that are dead ends: 12%")); // temporary dummy data
        JCheckBox solutionCheckBox = new JCheckBox("Show Optimal Maze Solution");
        metricsPanel.add(solutionCheckBox);
        pane1.add(metricsPanel);
        // Generate Button Panel
        JPanel generatePanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JButton generateButton = new JButton("Generate Maze");
        generateButton.setFont(new Font("Serif", Font.BOLD, 20));
        buttonPanel.add(generateButton);
        generatePanel.setLayout(new GridBagLayout());
        generatePanel.add(buttonPanel);
        pane1.add(generatePanel);


        // Maze -- Right side of Split Pane -- Pane 2
        JPanel pane2 = new JPanel();
        JLabel temporaryLabel = new JLabel("Maze generates here.");
        pane2.setLayout(new GridBagLayout());
        pane2.add(temporaryLabel);


        // Creating Split Pane
        JSplitPane mazeSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pane1, pane2);
        mazeSplitPane.setOrientation(SwingConstants.VERTICAL);
        mazeSplitPane.setDividerLocation(400);
        mazeCreatorFrame.add(mazeSplitPane);


        // 'browse' button functionality - browse for image
        browseButton.addActionListener(e-> {
            JFileChooser imgChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image (jpeg, jpg, png)", "jpeg", "jpg", "png");
            imgChooser.addChoosableFileFilter(filter);
            // Open selected image
            int returnVal = imgChooser.showOpenDialog(imgChooser);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                File image = new File(imgChooser.getSelectedFile().getAbsolutePath());
                selectedImg.setText(image.getAbsolutePath());
            }
            // Cancel selecting image
            else if (returnVal == JFileChooser.CANCEL_OPTION){
                selectedImg.setText("No image selected");
            }
        });


        mazeCreatorFrame.pack();
        mazeCreatorFrame.setLocationRelativeTo(null);
        mazeCreatorFrame.setResizable(false);
        mazeCreatorFrame.setVisible(true);

    }

}