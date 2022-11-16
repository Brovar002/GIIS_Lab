package by.goncharov.editor.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import by.goncharov.editor.drawing.controler.AlgorithmController;
import by.goncharov.editor.drawing.model.Segment;

public class BuildSegmentPanel extends JPanel {

	public BuildSegmentPanel(AlgorithmController pAlgorithmController, JDialog pJDialog){
		this.setLayout(new GridBagLayout());

		JLabel enterX1Text = new JLabel("X1:");
		JTextField enterX1Input = new JTextField("", 10);
		JLabel enterY1Text = new JLabel("Y1:");
		JTextField enterY1Input = new JTextField("", 10);
		JLabel enterX2Text = new JLabel("X2:");
		JTextField enterX2Input = new JTextField("", 10);
		JLabel enterY2Text = new JLabel("Y2:");
		JTextField enterY2Input = new JTextField("", 10);
        JLabel enterCheckoutModText = new JLabel("Run checkout mode");
        JCheckBox enterCheckoutModInput = new JCheckBox();

		JButton enterButton = new JButton("ОК");
		enterButton.addActionListener(e -> {
            pJDialog.setVisible(false);

            Segment segment = new Segment();
            segment.setStartX(Double.valueOf(enterX1Input.getText()));
            segment.setStartY(Double.valueOf(enterY1Input.getText()));
            segment.setFinishX(Double.valueOf(enterX2Input.getText()));
            segment.setFinishY(Double.valueOf(enterY2Input.getText()));
            pAlgorithmController.startBuildSegment(segment, enterCheckoutModInput.isSelected());
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
		add(enterX2Text, new GridBagConstraints(0, 4, 1, 1, 0, 0,
				GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
				1, 1, 1, 1), 0, 0));
		add(enterX2Input, new GridBagConstraints(0, 5, 1, 1, 0, 0,
				GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
				1, 1, 1, 1), 0, 0));
		add(enterY2Text, new GridBagConstraints(0, 6, 1, 1, 0, 0,
				GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
				1, 1, 1, 1), 0, 0));
		add(enterY2Input, new GridBagConstraints(0, 7, 1, 1, 0, 0,
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
