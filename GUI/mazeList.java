package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class mazeList extends menu {
    /**
     * Method to create the maze list GUI
     */

    // Arrays to store data from database
    static ArrayList<String> titleData = new ArrayList<String>();
    static ArrayList<String> authorData = new ArrayList<String>();
    static ArrayList<String> dateCreatedData = new ArrayList<String>();
    static ArrayList<String> dateEditedData = new ArrayList<String>();

    public static void createMazeList() {

        JFrame mazeListFrame = new JFrame("Maze Creator");
        mazeListFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
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

        // Boolean so that the function (dbRowCount) to count the number of rows in mazeList only runs once.
        AtomicBoolean rowCounted = new AtomicBoolean(false);
        AtomicInteger rowCount = new AtomicInteger();

        // Functionality of JComboBox
        mazeComboBox.addActionListener(e -> {
            Object item = mazeComboBox.getSelectedItem();

            if(rowCounted.get() == false){
                rowCounted.set(true);
                try {
                    rowCount.set(dbRowCount());
                } catch (SQLException ex) {
                    return;
                }
            }
            if(item == "Title"){
                try {
                    dbTableData();

                } catch (SQLException ex) {
                    return;
                }
            }
            else if(item == "Author"){

            }
            else if(item == "Date Created"){
                //
            }
            else if(item == "Date Last Edited"){
                //
            }
        });

        // Temporary dummy table Data
        String[] columns = {"Title", "Author", "Date Created", "Date Edited", "Export?"};
        Object[][] data = {
                {"Doggy Maze", "Bob Ross", "27-04-2022 11:27:03", "27-04-2022 11:27:03", false},
                {"Awesome Maze", "Bob Ross", "27-04-2022 11:27:03", "27-04-2022 11:27:03", false},
        };


        DefaultTableModel mazeTableModel = new DefaultTableModel(data, columns);
        JTable mazeJTable = new JTable(mazeTableModel) {
            public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };

        // Putting JTable in a scroll pane
        JScrollPane sp = new JScrollPane(mazeJTable);
        sp.setPreferredSize(new Dimension(550, 250));
        mazeList.add(sp);
        mainPanel.add(mazeList);


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
     * Counts the number of rows in the database
     * @return count - the number of rows
     * @throws SQLException
     */
    public static int dbRowCount() throws SQLException { /// Deprecated function
        // Counting the number of rows in the database.
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mazecreator", "root", "password");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select count(*) from mazeList;");
        rs.next();
        int count = rs.getInt(1);
        statement.close();
        connection.close();
        return count;
    }

    /**
     * Stores data from 'mazeList' database table into arrays
     * @throws SQLException
     */
    public static int dbTableData() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mazecreator", "root", "password");
        Statement statement = connection.createStatement();

        // Storing title data
        ResultSet rs1 = statement.executeQuery( "SELECT title FROM mazeList;" );
        int columnCount = rs1.getMetaData().getColumnCount();
        rs1.next();
        for (int i = 0; i <columnCount ; i++)
        {
            titleData.add(rs1.getString(i + 1) );
        }

        // Storing author data
        ResultSet rs2 = statement.executeQuery( "SELECT author FROM mazeList;" );
        rs2.next();
        for (int i = 0; i <columnCount ; i++)
        {
            authorData.add(rs2.getString(i + 1) );
        }

        // Storing dateCreated data
        ResultSet rs3 = statement.executeQuery( "SELECT dateCreated FROM mazeList;" );
        rs3.next();
        for (int i = 0; i <columnCount ; i++)
        {
            dateCreatedData.add(rs3.getString(i + 1) );
        }

        // Storing dateEdited data
        ResultSet rs4 = statement.executeQuery( "SELECT dateEdited FROM mazeList;" );
        rs4.next();
        for (int i = 0; i <columnCount ; i++)
        {
            dateEditedData.add(rs4.getString(i + 1) );
        }

        return 0;
    }

}