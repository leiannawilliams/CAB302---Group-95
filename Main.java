import GUI.mainWindow;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        // setting up connection to database
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/maze", "root", "password");

        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        mainWindow window = new mainWindow();
        window.createMainWindow(mainWindow.project);
        connection.close();
    }
}