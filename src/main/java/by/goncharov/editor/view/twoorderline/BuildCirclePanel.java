package by.goncharov.editor.view.twoorderline;

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
import by.goncharov.editor.drawing.model.Circle;

public class BuildCirclePanel extends JPanel {

	public BuildCirclePanel(AlgorithmController pAlgorithmController, JDialog pJDialog){
		this.setLayout(new GridBagLayout());

		JLabel enterX1Text = new JLabel("X:");
		JTextField enterX1Input = new JTextField("", 10);
		JLabel enterY1Text = new JLabel("Y:");
		JTextField enterY1Input = new JTextField("", 10);
		JLabel enterRText = new JLabel("R:");
		JTextField enterRInput = new JTextField("", 10);
        JLabel enterCheckoutModText = new JLabel("Run checkout mode");
        JCheckBox enterCheckoutModInput = new JCheckBox();

		JButton enterButton = new JButton("ОК");
		enterButton.addActionListener(e -> {
            pJDialog.setVisible(false);

			Circle circle = new Circle();
			circle.setCircleX(Double.valueOf(enterX1Input.getText()));
			circle.setCircleY(Double.valueOf(enterY1Input.getText()));
			circle.setCircleR(Double.valueOf(enterRInput.getText()));
            pAlgorithmController.startBuildSegment(circle, enterCheckoutModInput.isSelected());
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
		add(enterRText, new GridBagConstraints(0, 4, 1, 1, 0, 0,
				GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
				1, 1, 1, 1), 0, 0));
		add(enterRInput, new GridBagConstraints(0, 7, 1, 1, 0, 0,
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
