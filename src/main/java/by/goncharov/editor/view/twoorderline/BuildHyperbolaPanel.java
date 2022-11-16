package by.goncharov.editor.view.twoorderline;

import by.goncharov.editor.drawing.controler.AlgorithmController;
import by.goncharov.editor.drawing.model.Hyperbola;

import javax.swing.*;
import java.awt.*;

public class BuildHyperbolaPanel extends JPanel{
    public BuildHyperbolaPanel(AlgorithmController pAlgorithmController, JDialog pJDialog){
        this.setLayout(new GridBagLayout());

        JLabel enterX1Text = new JLabel("X:");
        JTextField enterX1Input = new JTextField("", 10);
        JLabel enterY1Text = new JLabel("Y:");
        JTextField enterY1Input = new JTextField("", 10);
        JLabel enterAText = new JLabel("A:");
        JTextField enterAInput = new JTextField("", 10);
        JLabel enterBText = new JLabel("B:");
        JTextField enterBInput = new JTextField("", 10);
        JLabel enterCheckoutModText = new JLabel("Run checkout mode");
        JCheckBox enterCheckoutModInput = new JCheckBox();

        JButton enterButton = new JButton("ОК");
        enterButton.addActionListener(e -> {
            pJDialog.setVisible(false);
            Hyperbola hyperbola = new Hyperbola();
            hyperbola.setX(Integer.parseInt(enterX1Input.getText()));
            hyperbola.setY(Integer.parseInt(enterY1Input.getText()));
            hyperbola.setA(Integer.parseInt(enterAInput.getText()));
            hyperbola.setB(Integer.parseInt(enterBInput.getText()));
            pAlgorithmController.startBuildSegment(hyperbola, enterCheckoutModInput.isSelected());
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
        add(enterBText, new GridBagConstraints(0, 6, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterBInput, new GridBagConstraints(0, 7, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterCheckoutModText, new GridBagConstraints(0, 8, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterCheckoutModInput, new GridBagConstraints(0, 9, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterButton,new GridBagConstraints(0, 10, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));

    }
}
