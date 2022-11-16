package by.goncharov.editor.menu.geometry;

import by.goncharov.editor.drawing.controler.AlgorithmController;
import by.goncharov.editor.view.twoorderline.BuildHyperbolaPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HyperbolaBuildingListener implements ActionListener {
    private JFrame mainWindow;
    private AlgorithmController mAlgorithmController;

    public HyperbolaBuildingListener(JFrame pMainWindow, AlgorithmController pAlgorithmController){
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
        dialogPanel.add(new BuildHyperbolaPanel(mAlgorithmController, dialogPanel), BorderLayout.NORTH);
    }
}
