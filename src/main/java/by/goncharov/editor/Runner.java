package by.goncharov.editor;

import javax.swing.SwingUtilities;

import by.goncharov.editor.view.MainWindow;

public class Runner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}
