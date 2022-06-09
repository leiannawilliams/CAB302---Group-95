package GUI;

import Maze.Drawing;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class standardMazeCreator extends menu {

    private static Drawing drawPanel2; // Drawing canvas to display maze

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
        JPanel generatePanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JButton generateButton = new JButton("Generate Maze");
        generateButton.setFont(new Font("Serif", Font.BOLD, 20));
        buttonPanel.add(generateButton);
        JButton exportBtn = new JButton("Export");
        exportBtn.setEnabled(false);
        buttonPanel.add(exportBtn);
        generatePanel.setLayout(new GridBagLayout());
        generatePanel.add(buttonPanel);
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
                File image = new File(imgChooser.getSelectedFile().getAbsolutePath());
                selectedImg.setText(image.getAbsolutePath());
            }
            // Cancel selecting image
            else if (returnVal == JFileChooser.CANCEL_OPTION){
                selectedImg.setText("No image selected");
            }
        });

        // Generate button functionality
       generateButton.addActionListener(ae -> {
           Drawing drawPanel = new Drawing(sizeInput);
           drawPanel.setBackground(Color.WHITE);
           pane2.getViewport().add(drawPanel);
           exportBtn.setEnabled(true);

           drawPanel2 = drawPanel;
       });

        //Export button functionality
        exportBtn.addActionListener(ae -> {

            JFileChooser jfc = new JFileChooser();
            jfc.setFileFilter(new FileNameExtensionFilter("Image (jpeg, jpg, png)", "jpeg", "jpg", "png"));

            jfc.setDialogTitle("Save maze as image");
            int saveResult = jfc.showSaveDialog(exportBtn);

            BufferedImage componentImage = new BufferedImage(drawPanel2.getWidth(), drawPanel2.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = componentImage.createGraphics();
            drawPanel2.paint(g2d);
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

                }
        );

        mazeCreatorFrame.pack();
        mazeCreatorFrame.setLocationRelativeTo(null);
        mazeCreatorFrame.setResizable(false);
        mazeCreatorFrame.setVisible(true);

    }
}