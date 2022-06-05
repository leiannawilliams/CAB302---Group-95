package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class simpleMazeCreator extends menu {

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
        pane1.add(detailsPanel);
        // Style contents
        JPanel stylePanel = new JPanel(new GridLayout(2,2));
        stylePanel.setBorder(BorderFactory.createTitledBorder("Style"));
        ((TitledBorder) stylePanel.getBorder()).setTitleFont(new Font("Serif", Font.BOLD, 20));
        JLabel startImageText = new JLabel("Start image:");
        startImageText.setFont(new Font ("Serif", Font.PLAIN, 22));
        stylePanel.add(startImageText);
        stylePanel.add(new JButton("Browse"));
        JLabel endImageText = new JLabel("End image:");
        endImageText.setFont(new Font ("Serif", Font.PLAIN, 22));
        stylePanel.add(endImageText);
        stylePanel.add(new JButton("Browse"));
        pane1.add(stylePanel);
        //Metrics contents
        JPanel metricsPnl = metricsPanel();
        pane1.add(metricsPnl);
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


        mazeCreatorFrame.pack();
        mazeCreatorFrame.setLocationRelativeTo(null);
        mazeCreatorFrame.setResizable(false);
        mazeCreatorFrame.setVisible(true);
    }
}