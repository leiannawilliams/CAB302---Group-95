import GUI.mainWindow;

import javax.swing.*;

public class Main{
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        mainWindow window = new mainWindow();
        window.createMainWindow(mainWindow.project);
    }
}