package by.goncharov.editor.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitMenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
