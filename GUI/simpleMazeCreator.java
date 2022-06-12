package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class simpleMazeCreator extends menu {

    private static JTextField startImg, endImg; // Text fields to display image file path

    /**
     * Method to create the simple maze GUI
     */
    public static void createSimpleMaze(){

        JFrame mazeCreatorFrame = new JFrame("Maze Creator");
        mazeCreatorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mazeCreatorFrame.setPreferredSize(new Dimension(1500, 800));

        // Adding menu bar to frame
        mazeCreatorFrame.setJMenuBar(menu.createMenuBar());

        // Maze Editor and Details -- Left side of Split Pane -- Pane 1
        JPanel pane1 = new JPanel(new GridLayout(5, 1));
        // Title
        JPanel titlePnl = titlePanel("Simple Maze Creator");
        pane1.add(titlePnl);
        // Details contents
        JPanel detailsPanel = detailsPanel();
        pane1.add(detailsPanel);

        /* STYLE CONTENTS */
        JPanel stylePanel = new JPanel(new GridLayout(2,3));
        stylePanel.setBorder(BorderFactory.createTitledBorder("Style"));
        ((TitledBorder) stylePanel.getBorder()).setTitleFont(new Font("Serif", Font.BOLD, 20));
        /* Start image panel */
        JLabel startImageText = new JLabel("Start image:");
        startImageText.setFont(new Font ("Serif", Font.PLAIN, 18));
        stylePanel.add(startImageText);
        // Text field to display start image file path
        JPanel startImgPanel = new JPanel();
        startImg = new JTextField("Browse for image");
        startImgPanel.add(startImg);
        stylePanel.add(startImgPanel);
        stylePanel.add(createButton("Browse", e -> EventHandler.browseButtonClicked(e, startImg)));
        /* End image panel */
        JLabel endImageText = new JLabel("End image:");
        endImageText.setFont(new Font ("Serif", Font.PLAIN, 18));
        stylePanel.add(endImageText);
        // Text field to display end image file path
        JPanel endImgPanel = new JPanel();
        endImg = new JTextField("Browse for image");
        endImgPanel.add(endImg);
        stylePanel.add(endImgPanel);
        stylePanel.add(createButton("Browse", e -> EventHandler.browseButtonClicked(e, endImg)));
        pane1.add(stylePanel);

        //Metrics contents
        JPanel metricsPnl = metricsPanel();
        pane1.add(metricsPnl);
        // Generate Button Panel
        JPanel generatePanel = generatePanel();
        pane1.add(generatePanel);


        // Maze -- Right side of Split Pane -- Pane 2
        JScrollPane pane2 = new JScrollPane();
        pane2.setAutoscrolls(true);
        pane2.setPreferredSize(new Dimension(500, 500));


        // Creating Split Pane
        JSplitPane mazeSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pane1, pane2);
        mazeSplitPane.setOrientation(SwingConstants.VERTICAL);
        mazeSplitPane.setDividerLocation(400);
        mazeCreatorFrame.add(mazeSplitPane);


        mazeCreatorFrame.pack();
        mazeCreatorFrame.setLocationRelativeTo(null);
        mazeCreatorFrame.setResizable(false);
        mazeCreatorFrame.setVisible(true);
    }
}