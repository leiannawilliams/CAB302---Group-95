package GUI;

import Maze.MazePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class standardMazeCreator extends menu {

    public static JTextField sizeInput; // Text filed for maze size input

    private static final long serialVersionUID = 1L;
    public static int mazeSize;
    static JPanel contentPane;
    static JSplitPane mazeSplitPane;
    static MazePanel mazePane;

    /**
     * Method to create the standard maze GUI
     */
    public static void createStandardMaze(){

        JFrame mazeCreatorFrame = new JFrame("Maze Creator");
        mazeCreatorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mazeCreatorFrame.setPreferredSize(new Dimension(1500, 800));

        // Adding menu bar to frame
        mazeCreatorFrame.setJMenuBar(menu.createMenuBar());


        // Maze Editor and Details -- Left side of Split Pane -- Pane 1
        JPanel pane1 = new JPanel(new GridLayout(5, 1));
        // Title
        JPanel titlePnl = titlePanel("Standard Maze Creator");
        pane1.add(titlePnl);
        // Details contents
        JPanel detailsPanel = detailsPanel();
        pane1.add(detailsPanel);
        // Style contents
        JPanel stylePanel = new JPanel(new GridLayout(2,2));
        stylePanel.setBorder(BorderFactory.createTitledBorder("Style"));
        ((TitledBorder) stylePanel.getBorder()).setTitleFont(new Font("Serif", Font.BOLD, 16));
        JLabel imageText = new JLabel("  Logo Image:");
        imageText.setFont(new Font ("Serif", Font.PLAIN, 20));
        stylePanel.add(imageText);
        JPanel selectedImgPanel = new JPanel();
        selectedImgPanel.setLayout(new GridBagLayout());
        // Text field for displaying image file path
        JTextField selectedImg = new JTextField("Browse for image");
        selectedImgPanel.add(selectedImg);
        stylePanel.add(selectedImgPanel);
        JPanel browseButtonPanel = new JPanel();
        browseButtonPanel.setLayout(new GridBagLayout());
        JButton browseButton = new JButton("Browse");
        browseButton.setFont(new Font("Serif", Font.PLAIN, 20));
        browseButtonPanel.add(browseButton);
        stylePanel.add(browseButtonPanel);
        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new GridBagLayout());
        sizePanel.add(new JLabel("Set preferred maze size: "));
        sizeInput = new JTextField();
        sizeInput.setPreferredSize(new Dimension(80,20));
        sizeInput.setMinimumSize(new Dimension(80,20));
        sizeInput.grabFocus();
        sizePanel.add(sizeInput);
        stylePanel.add(sizePanel);
        pane1.add(stylePanel);
        //Metrics contents
        JPanel metricsPnl = metricsPanel();
        pane1.add(metricsPnl);
        // Generate Button Panel
        JPanel generatePanel = generatePanel(sizeInput);
        pane1.add(generatePanel);


        // Maze -- Right side of Split Pane -- Pane 2
        contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        mazeSize = 51;
        standardMazeCreator.mazePane = new MazePanel(mazeSize);
        contentPane.add(mazePane, BorderLayout.CENTER);


        // Creating Split Pane
        mazeSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pane1, contentPane);
        mazeSplitPane.setOrientation(SwingConstants.VERTICAL);
        mazeSplitPane.setDividerLocation(400);

        mazeCreatorFrame.add(mazeSplitPane);


        mazeCreatorFrame.pack();
        mazeCreatorFrame.setLocationRelativeTo(null);
        mazeCreatorFrame.setResizable(false);
        mazeCreatorFrame.setVisible(true);
    }



}