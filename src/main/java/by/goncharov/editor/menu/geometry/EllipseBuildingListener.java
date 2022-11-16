package by.goncharov.editor.menu.geometry;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import by.goncharov.editor.drawing.controler.AlgorithmController;
import by.goncharov.editor.view.twoorderline.BuildCirclePanel;
import by.goncharov.editor.view.twoorderline.BuildEllipsePanel;

public class EllipseBuildingListener implements ActionListener {
    private JFrame mainWindow;
    private AlgorithmController mAlgorithmController;

    public EllipseBuildingListener(JFrame pMainWindow, AlgorithmController pAlgorithmController){
        this.mainWindow = pMainWindow;
        this.mAlgorithmController = pAlgorithmController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialogPanel = new JDialog(mainWindow, "Enter parameters window", false);
        dialogPanel.setSize(300, 300);
        dialogPanel.setLocationRelativeTo(mainWindow);
        dialogPanel.setVisible(true);
        dialogPanel.setLayout(new BorderLayout());
        dialogPanel.add(new BuildEllipsePanel(mAlgorithmController, dialogPanel), BorderLayout.NORTH);
    }
}
