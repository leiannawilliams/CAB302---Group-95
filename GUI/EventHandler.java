package GUI;

import Maze.Drawing;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static GUI.standardMazeCreator.*;

public class EventHandler implements ActionListener {
    /**
     * 'Browse' button functionality to look for image
     * @param e event listener
     */
    public static void browseButtonClicked(ActionEvent e, JTextField displayImg){
        // Create file picker dialog box
        JFileChooser imgChooser = new JFileChooser();
        // Disable the 'All' file extension filter
        imgChooser.setAcceptAllFileFilterUsed(false);
        // Set file extension filter to accept only image files
        FileNameExtensionFilter filter= new FileNameExtensionFilter("Image(jpeg,jpg,png)","jpeg","jpg","png");
        // Add filter
        imgChooser.addChoosableFileFilter(filter);

        // Show file picker dialog to start browsing for image file
        int returnVal = imgChooser.showOpenDialog(imgChooser);
        // Open selected image
        if(returnVal == JFileChooser.APPROVE_OPTION){
            try{
                // Get file path of selected image
                File image = new File(imgChooser.getSelectedFile().getAbsolutePath());
                // Display file path of selected image in text field
                displayImg.setText(image.getAbsolutePath());

            } catch (Exception ae){

            } // try and catch
        // Cancel selecting image
        } else if(returnVal==JFileChooser.CANCEL_OPTION){
            displayImg.setText("No image selected");
        }
    }

    /**
     * 'Generate' button functionality for standard maze
     * @param ae event listener
     */
    public static void generateButtonClicked(ActionEvent ae){
        Drawing drawPanel = new Drawing(sizeInput);
        drawPanel.setBackground(Color.WHITE);
        pane2.getViewport().add(drawPanel);

        drawPanel2 = drawPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
