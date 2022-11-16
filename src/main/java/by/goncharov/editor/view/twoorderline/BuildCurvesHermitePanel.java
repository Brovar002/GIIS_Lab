package by.goncharov.editor.view.twoorderline;

import by.goncharov.editor.drawing.controler.AlgorithmController;
import by.goncharov.editor.drawing.model.BorderConditionsForHermite;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;

public class BuildCurvesHermitePanel extends Panel {

    public BuildCurvesHermitePanel(AlgorithmController pAlgorithmController, JDialog pJDialog) {
        this.setLayout(new GridBagLayout());

        JLabel enterP1Text = new JLabel("P1:");
        JTextField enterP1InputFirst = new JTextField("", 6);
        JTextField enterP1InputSecond = new JTextField("", 6);

        JLabel enterP4Text = new JLabel("P4:");
        JTextField enterP4InputFirst = new JTextField("", 6);
        JTextField enterP4InputSecond = new JTextField("", 6);

        JLabel enterR1Text = new JLabel("R1:");
        JTextField enterR1InputFirst = new JTextField("", 6);
        JTextField enterR1InputSecond = new JTextField("", 6);

        JLabel enterR4Text = new JLabel("R4:");
        JTextField enterR4InputFirst = new JTextField("", 6);
        JTextField enterR4InputSecond = new JTextField("", 6);

        JLabel enterCheckoutModText = new JLabel("Checkout mode");
        JCheckBox enterCheckoutModInput = new JCheckBox();

        JButton enterButton = new JButton("ОК");
        enterButton.addActionListener(e -> {
            pJDialog.setVisible(false);
            BorderConditionsForHermite borderConditionsForHermite = new BorderConditionsForHermite();
            borderConditionsForHermite.setFirstValueP1(Integer.parseInt(enterP1InputFirst.getText()));
            borderConditionsForHermite.setSecondValueP1(Integer.parseInt(enterP1InputSecond.getText()));
            borderConditionsForHermite.setFirstValueP4(Integer.parseInt(enterP4InputFirst.getText()));
            borderConditionsForHermite.setSecondValueP4(Integer.parseInt(enterP4InputSecond.getText()));
            borderConditionsForHermite.setFirstValueR1(Integer.parseInt(enterR1InputFirst.getText()));
            borderConditionsForHermite.setSecondValueR1(Integer.parseInt(enterR1InputSecond.getText()));
            borderConditionsForHermite.setFirstValueR4(Integer.parseInt(enterR4InputFirst.getText()));
            borderConditionsForHermite.setSecondValueR4(Integer.parseInt(enterR4InputSecond.getText()));
            pAlgorithmController.startBuildSegment(borderConditionsForHermite, enterCheckoutModInput.isSelected());
        });

        add(enterP1Text, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));

        add(enterP1InputFirst, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterP1InputSecond, new GridBagConstraints(1, 1, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));

        add(enterP4Text, new GridBagConstraints(0, 2, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));

        add(enterP4InputFirst, new GridBagConstraints(0, 3, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterP4InputSecond, new GridBagConstraints(1, 3, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));

        add(enterR1Text, new GridBagConstraints(0, 4, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));

        add(enterR1InputFirst, new GridBagConstraints(0, 7, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterR1InputSecond, new GridBagConstraints(1, 7, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));

        add(enterR4Text, new GridBagConstraints(0, 8, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));

        add(enterR4InputFirst, new GridBagConstraints(0, 9, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterR4InputSecond, new GridBagConstraints(1, 9, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));

        add(enterCheckoutModText, new GridBagConstraints(0, 10, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterCheckoutModInput, new GridBagConstraints(1, 10, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));

        add(enterButton, new GridBagConstraints(0, 11, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));

        JButton test1Button = new JButton("TEST1");
        test1Button.addActionListener(e -> {
            enterP1InputFirst.setText("0");
            enterP1InputSecond.setText("0");
            enterP4InputFirst.setText("4");
            enterP4InputSecond.setText("0");
            enterR1InputFirst.setText("1");
            enterR1InputSecond.setText("1");
            enterR4InputFirst.setText("1");
            enterR4InputSecond.setText("0");
        });

        JButton test2Button = new JButton("TEST2");
        test2Button.addActionListener(e -> {
            enterP1InputFirst.setText("0");
            enterP1InputSecond.setText("0");
            enterP4InputFirst.setText("3");
            enterP4InputSecond.setText("5");
            enterR1InputFirst.setText("1");
            enterR1InputSecond.setText("1");
            enterR4InputFirst.setText("0");
            enterR4InputSecond.setText("-1");
        });

        JButton test3Button = new JButton("TEST3");
        test3Button.addActionListener(e -> {
            enterP1InputFirst.setText("0");
            enterP1InputSecond.setText("0");
            enterP4InputFirst.setText("3");
            enterP4InputSecond.setText("0");
            enterR1InputFirst.setText("0");
            enterR1InputSecond.setText("1");
            enterR4InputFirst.setText("1");
            enterR4InputSecond.setText("0");
        });

        JButton test4Button = new JButton("TEST4");
        test4Button.addActionListener(e -> {
            enterP1InputFirst.setText("0");
            enterP1InputSecond.setText("0");
            enterP4InputFirst.setText("4");
            enterP4InputSecond.setText("4");
            enterR1InputFirst.setText("0");
            enterR1InputSecond.setText("1");
            enterR4InputFirst.setText("0");
            enterR4InputSecond.setText("-1");
        });

        JButton test5Button = new JButton("TEST5");
        test5Button.addActionListener(e -> {
            enterP1InputFirst.setText("0");
            enterP1InputSecond.setText("0");
            enterP4InputFirst.setText("4");
            enterP4InputSecond.setText("4");
            enterR1InputFirst.setText("0");
            enterR1InputSecond.setText("1");
            enterR4InputFirst.setText("0");
            enterR4InputSecond.setText("-1");
        });

        JButton test6Button = new JButton("TEST6");
        test6Button.addActionListener(e -> {
            enterP1InputFirst.setText("0");
            enterP1InputSecond.setText("0");
            enterP4InputFirst.setText("3");
            enterP4InputSecond.setText("5");
            enterR1InputFirst.setText("1");
            enterR1InputSecond.setText("1");
            enterR4InputFirst.setText("0");
            enterR4InputSecond.setText("-1");
        });

        JButton test7Button = new JButton("TEST7");
        test7Button.addActionListener(e -> {
            enterP1InputFirst.setText("0");
            enterP1InputSecond.setText("0");
            enterP4InputFirst.setText("4");
            enterP4InputSecond.setText("0");
            enterR1InputFirst.setText("0");
            enterR1InputSecond.setText("1");
            enterR4InputFirst.setText("1");
            enterR4InputSecond.setText("0");
        });

        JButton test8Button = new JButton("TEST8");
        test8Button.addActionListener(e -> {
            enterP1InputFirst.setText("0");
            enterP1InputSecond.setText("0");
            enterP4InputFirst.setText("4");
            enterP4InputSecond.setText("0");
            enterR1InputFirst.setText("1");
            enterR1InputSecond.setText("1");
            enterR4InputFirst.setText("1");
            enterR4InputSecond.setText("1");
        });



        add(test1Button, new GridBagConstraints(0, 12, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(test2Button, new GridBagConstraints(1, 12, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(test3Button, new GridBagConstraints(0, 13, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(test4Button, new GridBagConstraints(1, 13, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(test5Button, new GridBagConstraints(0, 14, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(test6Button, new GridBagConstraints(1, 14, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(test7Button, new GridBagConstraints(0, 15, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(test8Button, new GridBagConstraints(1, 15, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
    }
}
