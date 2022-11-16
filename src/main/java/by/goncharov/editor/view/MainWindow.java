package by.goncharov.editor.view;

import by.goncharov.editor.drawing.controler.*;
import by.goncharov.editor.menu.ExitMenuListener;
import by.goncharov.editor.menu.geometry.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainWindow implements ViewConstants {
	public MainWindow() {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		JFrame mainFrame = new JFrame(APPLICATION_NAME);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1200, 700);
		mainFrame.setLocationRelativeTo(null);

		JMenuBar mainMenuBar = new JMenuBar();
		JMenu fileMenu = new JMenu(MENU_FILE);
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenuItem exitItem = new JMenuItem(EXIT, KeyEvent.VK_Q);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		fileMenu.add(exitItem);
		mainMenuBar.add(fileMenu);
		mainFrame.setJMenuBar(mainMenuBar);
		exitItem.addActionListener(new ExitMenuListener());

		WorkingAreaPanel workingAreaPanel = new WorkingAreaPanel();
		mainFrame.add(workingAreaPanel, BorderLayout.CENTER);

		JMenu segmentsMenu = new JMenu(MENU_SEGMENTS);
		segmentsMenu.setMnemonic(KeyEvent.VK_E);
		JMenuItem ddaAlgoritmItem = new JMenuItem(MENU_SEGMENT_DDA, KeyEvent.VK_R);
		JMenuItem brenzenhemAlgoritmItem = new JMenuItem(MENU_SEGMENT_BRENZENHEM, KeyEvent.VK_A);
		JMenuItem byAlgoritmItem = new JMenuItem(MENU_SEGMENT_BY, KeyEvent.VK_D);
		JMenuItem curvesHirmiteItem = new JMenuItem(MENU_CURVES_HERMITE, KeyEvent.VK_H);

		segmentsMenu.add(ddaAlgoritmItem);
		segmentsMenu.add(brenzenhemAlgoritmItem);
		segmentsMenu.add(byAlgoritmItem);
		segmentsMenu.add(curvesHirmiteItem);
		mainMenuBar.add(segmentsMenu);

		ddaAlgoritmItem.addActionListener(new SegmentListener(
				mainFrame,
				new DDAAlgorithmController(workingAreaPanel))
		);
		byAlgoritmItem.addActionListener(new SegmentListener(
				mainFrame,
				new BYAlgorithmController(workingAreaPanel))
		);
		brenzenhemAlgoritmItem.addActionListener(new SegmentListener(
				mainFrame,
				new BrezenhemAlgorithmController(workingAreaPanel))
		);
		curvesHirmiteItem.addActionListener(new CurvesHermiteBuildingListener(
				mainFrame,
				new HermitAlgorithmController(workingAreaPanel))
		);

		JMenu secondOrderLinesMenu = new JMenu(MENU_TWO_ORDER_LINES);

		JMenuItem circleBuildingItem = new JMenuItem(MENU_CIRCLE);
		JMenuItem ellipseBuildingtem = new JMenuItem(MENU_ELLIPSE);
		JMenuItem hyperboleBuildingtem = new JMenuItem(MENU_HYPERBOLE);
		JMenuItem parabolaBuildingItem = new JMenuItem(MENU_PARABOLA);

		secondOrderLinesMenu.add(circleBuildingItem);
		secondOrderLinesMenu.add(ellipseBuildingtem);
		secondOrderLinesMenu.add(hyperboleBuildingtem);
		secondOrderLinesMenu.add(parabolaBuildingItem);
		mainMenuBar.add(secondOrderLinesMenu);

		circleBuildingItem.addActionListener(new CircleBuildingListener(
				mainFrame,
				new CircleAlgorithmController(workingAreaPanel))
		);

		ellipseBuildingtem.addActionListener(new EllipseBuildingListener(
				mainFrame,
				new EllipseAlgorithmController(workingAreaPanel))
		);

		parabolaBuildingItem.addActionListener(new ParabolaBuildingListener(
				mainFrame,
				new ParabolaAlgorithController(workingAreaPanel))
		);

		hyperboleBuildingtem.addActionListener(new HyperbolaBuildingListener(
				mainFrame,
				new HyperbolaAlgorithController(workingAreaPanel))
		);



		mainFrame.setVisible(true);
	}
}
