package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class mazeList extends menu {
    /**
     * Method to create the maze list GUI
     */

    // Arraylists to store data from database
    static ArrayList<String> titleData = new ArrayList<String>();
    static ArrayList<String> authorData = new ArrayList<String>();
    static ArrayList<String> dateCreatedData = new ArrayList<String>();
    static ArrayList<String> dateEditedData = new ArrayList<String>();

    public static void createMazeList() {

        JFrame mazeListFrame = new JFrame("Maze Creator");
        mazeListFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mazeListFrame.setPreferredSize(new Dimension(600, 500));

        // Adding menu bar to frame
        mazeListFrame.setJMenuBar(menu.createMenuBar());

        // Creating main panel to store all the other panels
        JPanel mainPanel = new JPanel();

        // Creating panel with title
        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        JLabel title = new JLabel(" List of Mazes");
        title.setFont(new Font ("Serif", Font.BOLD, 40));
        titlePanel.add(title);
        String[] sortBy = {"","Title", "Author", "Date Created", "Date Last Edited"};

        JPanel comboPanel = new JPanel();
        JLabel sortByLabel = new JLabel("Sort by:");
        comboPanel.add(sortByLabel);
        sortByLabel.setFont(new Font ("Serif", Font.BOLD, 16));
        JComboBox<String> mazeComboBox = new JComboBox<>(sortBy);
        comboPanel.add(mazeComboBox);
        titlePanel.add(comboPanel);
        mainPanel.add(titlePanel);

        // Creating a table with the list of all existing mazes
        JPanel mazeList = new JPanel();

        // JTable column headings
        String[] columns = {"Title", "Author", "Date Created", "Date Edited", "Export?"};

        // Creating JTable with no rows
        DefaultTableModel mazeTableModel = new DefaultTableModel(columns, 0);

        JTable mazeJTable = new JTable(mazeTableModel) {
            // Creating boolean checkbox inside the 'Export?' column.
            public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };

        // Putting JTable in a scroll pane
        JScrollPane sp = new JScrollPane(mazeJTable);
        sp.setPreferredSize(new Dimension(550, 250));
        mazeList.add(sp);
        mainPanel.add(mazeList);

        // Functionality of 'sort by' JComboBox and implementation of JTable rows
        mazeComboBox.addActionListener(e -> {
            Object item = mazeComboBox.getSelectedItem();
            // Sort by Title
            if(item == "Title"){
                try {
                    mazeTableModel.setRowCount(0);
                    dbTableData("title");
                    for (int i = 0; i < titleData.size(); i++)
                    {
                        mazeTableModel.addRow( new Object[]{titleData.get(i), authorData.get(i), dateCreatedData.get(i), dateEditedData.get(i), false} );
                    }
                } catch (SQLException ex) {
                    return;
                }
            }
            // Sort by Author
            else if(item == "Author"){
                try {
                    mazeTableModel.setRowCount(0);
                    dbTableData("author");
                    for (int i = 0; i < titleData.size(); i++)
                    {
                        mazeTableModel.addRow( new Object[]{titleData.get(i), authorData.get(i), dateCreatedData.get(i), dateEditedData.get(i), false} );
                    }
                } catch (SQLException ex) {
                    return;
                }
            }
            // Sort by Date Created
            else if(item == "Date Created"){
                try {
                    mazeTableModel.setRowCount(0);
                    dbTableData("dateCreated");
                    for (int i = 0; i < titleData.size(); i++)
                    {
                        mazeTableModel.addRow( new Object[]{titleData.get(i), authorData.get(i), dateCreatedData.get(i), dateEditedData.get(i), false} );
                    }
                } catch (SQLException ex) {
                    return;
                }
            }
            // Sort by Date Edited
            else if(item == "Date Last Edited"){
                try {
                    mazeTableModel.setRowCount(0);
                    dbTableData("dateEdited");
                    for (int i = 0; i < titleData.size(); i++)
                    {
                        mazeTableModel.addRow( new Object[]{titleData.get(i), authorData.get(i), dateCreatedData.get(i), dateEditedData.get(i), false} );
                    }
                } catch (SQLException ex) {
                    return;
                }
            }
            else if(item == ""){
                mazeTableModel.setRowCount(0);
            }
        });


        // Creating Export Button
        JPanel exportPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JButton exportButton = new JButton("Export");
        exportButton.setFont(new Font("Serif", Font.PLAIN, 20));
        buttonPanel.add(exportButton);
        exportPanel.add(buttonPanel);
        mainPanel.add(exportPanel, BorderLayout.SOUTH);


        mazeListFrame.add(mainPanel);

        mazeListFrame.pack();
        mazeListFrame.setLocationRelativeTo(null);
        mazeListFrame.setResizable(false);
        mazeListFrame.setVisible(true);
    }

    /**
     * Stores data from 'mazeList' database table into arraylists
     * @throws SQLException
     */
    public static int dbTableData(String order) throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:sqlite:mazeCreator.db");
        Statement statement = connection.createStatement();

        // Storing title data in ListArray
        ResultSet rs1 = statement.executeQuery( "SELECT title FROM mazeList ORDER BY " + order + ";" );
        titleData.removeAll(titleData);
        while (rs1.next()) {
            titleData.add(rs1.getString(1));
        }

        // Storing author data in ListArray
        ResultSet rs2 = statement.executeQuery( "SELECT author FROM mazeList ORDER BY " + order + ";" );
        authorData.removeAll(authorData);
        while (rs2.next()) {
            authorData.add(rs2.getString(1));
        }

        // Storing dateCreated data in ListArray
        ResultSet rs3 = statement.executeQuery( "SELECT dateCreated FROM mazeList ORDER BY " + order + ";" );
        dateCreatedData.removeAll(dateCreatedData);
        while (rs3.next()) {
            dateCreatedData.add(rs3.getString(1));
        }

        // Storing dateEdited data in ListArray
        ResultSet rs4 = statement.executeQuery( "SELECT dateEdited FROM mazeList ORDER BY " + order + ";" );
        dateEditedData.removeAll(dateEditedData);
        while (rs4.next()) {
            dateEditedData.add(rs4.getString(1));
        }

        statement.close();
        connection.close();
        return 0;
    }

}