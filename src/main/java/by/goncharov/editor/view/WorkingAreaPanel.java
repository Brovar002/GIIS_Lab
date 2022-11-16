package by.goncharov.editor.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import by.goncharov.editor.drawing.view.CoordinatePlane;

public class WorkingAreaPanel extends JPanel{
    private CoordinatePlane mCoordinatePlane;
    private JTextArea mLogPanel;

    public WorkingAreaPanel(){
        setLayout(new BorderLayout());
        mCoordinatePlane= new CoordinatePlane();
        mCoordinatePlane.setBackground(Color.white);
        mLogPanel = new JTextArea();
        mLogPanel.setPreferredSize(new Dimension(200, 700));
        add(mCoordinatePlane, BorderLayout.CENTER);
        add(mLogPanel, BorderLayout.EAST);
    }

    public CoordinatePlane getCoordinatePlane() {
        return mCoordinatePlane;
    }

    public void setCoordinatePlane(CoordinatePlane pCoordinatePlane) {
        mCoordinatePlane = pCoordinatePlane;
    }

    public JTextArea getLogPanel() {
        return mLogPanel;
    }

    public void setLogPanel(JTextArea pLogPanel) {
        mLogPanel = pLogPanel;
    }
}
