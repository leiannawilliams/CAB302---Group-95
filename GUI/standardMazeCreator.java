package GUI;

import Maze.Drawing;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class standardMazeCreator extends menu {

    public static JScrollPane pane2; // Scroll pane for the drawing canvas
    public static Drawing drawPanel2; // Drawing canvas to display maze

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
        JTextField sizeInput = new JTextField();
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
        pane2 = new JScrollPane();
        pane2.setAutoscrolls(true);
        pane2.setPreferredSize(new Dimension(500, 500));


        // Creating Split Pane
        JSplitPane mazeSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pane1, pane2);
        mazeSplitPane.setOrientation(SwingConstants.VERTICAL);
        mazeSplitPane.setDividerLocation(400);
        mazeCreatorFrame.add(mazeSplitPane);


        /* EVENT HANDLERS */

        // 'browse' button functionality - browse for image
        browseButton.addActionListener(e-> {
            JFileChooser imgChooser = new JFileChooser();
            imgChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image (jpeg, jpg, png)", "jpeg", "jpg", "png");
            imgChooser.addChoosableFileFilter(filter);
            // Open selected image
            int returnVal = imgChooser.showOpenDialog(imgChooser);
            if(returnVal == JFileChooser.APPROVE_OPTION){
                try{
                    File image = new File(imgChooser.getSelectedFile().getAbsolutePath());
                    selectedImg.setText(image.getAbsolutePath());
                } catch(Exception ae){

                } // try and catch
            }
            // Cancel selecting image
            else if (returnVal == JFileChooser.CANCEL_OPTION){
                selectedImg.setText("No image selected");
            }
        }); // Browse button

        mazeCreatorFrame.pack();
        mazeCreatorFrame.setLocationRelativeTo(null);
        mazeCreatorFrame.setResizable(false);
        mazeCreatorFrame.setVisible(true);

    }
}