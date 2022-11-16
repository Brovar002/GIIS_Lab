package by.goncharov.editor.view.twoorderline;

import by.goncharov.editor.drawing.controler.AlgorithmController;
import by.goncharov.editor.drawing.model.Parabola;

import javax.swing.*;
import java.awt.*;

public class BuildParabolaPanel extends JPanel{
    public BuildParabolaPanel(AlgorithmController pAlgorithmController, JDialog pJDialog){
        this.setLayout(new GridBagLayout());

        JLabel enterX1Text = new JLabel("X:");
        JTextField enterX1Input = new JTextField("", 10);
        JLabel enterY1Text = new JLabel("Y:");
        JTextField enterY1Input = new JTextField("", 10);
        JLabel enterAText = new JLabel("p:");
        JTextField enterAInput = new JTextField("", 10);
        JCheckBox enterCheckoutModInput = new JCheckBox();
        JLabel enterCheckoutModText = new JLabel("Run checkout mode");

        JButton enterButton = new JButton("ОК");
        enterButton.addActionListener(e -> {
            pJDialog.setVisible(false);
            Parabola parabola = new Parabola();
            parabola.setX(Integer.parseInt(enterX1Input.getText()));
            parabola.setY(Integer.parseInt(enterY1Input.getText()));
            parabola.setP(Integer.parseInt(enterAInput.getText()));
            pAlgorithmController.startBuildSegment(parabola, enterCheckoutModInput.isSelected());
        });

        add(enterX1Text, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterX1Input, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterY1Text, new GridBagConstraints(0, 2, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterY1Input, new GridBagConstraints(0, 3, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterAText, new GridBagConstraints(0, 4, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterAInput, new GridBagConstraints(0, 5, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterCheckoutModText, new GridBagConstraints(0, 6, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterCheckoutModInput, new GridBagConstraints(0, 7, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterButton, new GridBagConstraints(0, 8, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));


    }
}
