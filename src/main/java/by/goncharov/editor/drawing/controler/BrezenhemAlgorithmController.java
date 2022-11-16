package by.goncharov.editor.drawing.controler;

import java.awt.Color;
import by.goncharov.editor.drawing.model.GeometryObject;
import by.goncharov.editor.drawing.model.Segment;
import by.goncharov.editor.drawing.view.CoordinatePlane;
import by.goncharov.editor.view.WorkingAreaPanel;

public class BrezenhemAlgorithmController extends AlgorithmController {
	public BrezenhemAlgorithmController(WorkingAreaPanel pWorkingAreaPanel) {
		super(pWorkingAreaPanel);
	}

	@Override
	public void buildGeometryObjectByAlgorithm() {
		Segment segment = (Segment) mGeometryObject;
		CoordinatePlane coordinatePlane = mWorkingAreaPanel.getCoordinatePlane();
		coordinatePlane.clearCoordinatePlane();
		int pause = mCheckoutMod?1000:0;
		int x1 = (int)segment.getStartX();
		int y1 = (int)segment.getStartY();
		int x2 = (int)segment.getFinishX();
		int y2 = (int)segment.getFinishY();
		int x = x1;
		int y = y1;
		int dx = x2-x1;
		int dy = y2-y1;
		int e = 2*dy - dx;
		int nx, ny, ne;

		logInfo("i    e    x    y   e'  plot(x, y)");
		logInfo(0 + "   -    " + x + "   " + y + "   " + e + "  (" + x + " " + y + ")");
		int i = 1;
		while (i <= dx) {
			coordinatePlane.drawPlot(x, y, Color.black);

			try {
				Thread.sleep(pause);
			} catch (InterruptedException pE) {
				pE.printStackTrace();
			}
			ny = y;
			nx = x+1;
            ne = e;
			if (e >= 0){
				ny = ny + 1;
				ne -= 2*dx;
			}
            ne += 2*dy;
//			coordinatePlane.drawSegment(x, y, nx, ny, Color.black);
			x = nx; y = ny;
			logInfo(i + "   " + e + "   " + x + "   " + y + "   " + ne + "  (" + x + " " + y + ")");
			e = ne;
            i++;
		}
		coordinatePlane.drawPlot(x, y, Color.black);
	}
}
