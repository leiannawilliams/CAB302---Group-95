import GUI.mainWindow;

import javax.swing.*;
import java.sql.SQLException;

public class Main{
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        mainWindow window = new mainWindow();
        window.createMainWindow(mainWindow.project);
    }
}