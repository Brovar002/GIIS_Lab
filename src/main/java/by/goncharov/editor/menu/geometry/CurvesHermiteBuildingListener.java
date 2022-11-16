package by.goncharov.editor.menu.geometry;

import by.goncharov.editor.drawing.controler.AlgorithmController;
import by.goncharov.editor.view.twoorderline.BuildCurvesHermitePanel;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurvesHermiteBuildingListener implements ActionListener {
    private JFrame mainWindow;
    private AlgorithmController mAlgorithmController;

    public CurvesHermiteBuildingListener(JFrame pMainWindow, AlgorithmController pAlgorithmController) {
        this.mainWindow = pMainWindow;
        this.mAlgorithmController = pAlgorithmController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialogPanel = new JDialog(mainWindow, "Enter parameters window", false);
        dialogPanel.setSize(300, 450);
        dialogPanel.setLocationRelativeTo(mainWindow);
        dialogPanel.setVisible(true);
        dialogPanel.setLayout(new BorderLayout());
        dialogPanel.add(new BuildCurvesHermitePanel(mAlgorithmController, dialogPanel), BorderLayout.NORTH);
    }
}
