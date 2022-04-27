package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class mainWindow extends menu {

    public void createMainWindow() {

        JFrame mainWindowFrame = new JFrame("Maze Creator");
        mainWindowFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindowFrame.setPreferredSize(new Dimension(600, 500));

        // Adding menu bar to frame
        mainWindowFrame.setJMenuBar(menu.createMenuBar());

        // Creating main window label and buttons
        JLabel title = new JLabel("Maze Editor");
        title.setFont(new Font ("Serif", Font.BOLD, 60));
        JButton newProjectBtn = new JButton("New Project");
        JButton openProjectBtn = new JButton("Open Project");

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
        buttonsPanel.add(openProjectBtn);
        mainPanel.add(buttonsPanel);

        // 'New Project' button functionality
        newProjectBtn.addActionListener(e -> {
            mainWindowFrame.setVisible(false);
            mazeCreator.createMazeCreator();
        });


        mainWindowFrame.pack();
        mainWindowFrame.setLocationRelativeTo(null);
        mainWindowFrame.setVisible(true);

    }

}