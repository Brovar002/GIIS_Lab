package by.goncharov.editor.drawing.controler;

import java.awt.Color;
import by.goncharov.editor.drawing.model.Segment;
import by.goncharov.editor.drawing.view.CoordinatePlane;
import by.goncharov.editor.view.WorkingAreaPanel;

public class DDAAlgorithmController extends AlgorithmController {

    public DDAAlgorithmController(WorkingAreaPanel pWorkingAreaPanel) {
        super(pWorkingAreaPanel);
    }

    @Override
    public void buildGeometryObjectByAlgorithm() {
        Segment segment = (Segment) mGeometryObject;
        CoordinatePlane coordinatePlane = mWorkingAreaPanel.getCoordinatePlane();
        coordinatePlane.clearCoordinatePlane();
        int pause = mCheckoutMod?1000:0;

        double x1 = segment.getStartX();
        double y1 = segment.getStartY();
        double x2 = segment.getFinishX();
        double y2 = segment.getFinishY();
        int length = (int)Math.max(Math.abs(x1-x2), Math.abs(y1-y2));
        double dx = (x2-x1) / length;
        double dy = (y2-y1) / length;
        double x = x1 + 0.5;
        double y = y1 + 0.5;

        logInfo("i     x       y      plot(x, y)");
        logInfo(0 + "  " + String.format("%.2f", x) + "  " +
                String.format("%.2f", y) + "  (" + (int)x + " " + (int)y + ")");
        for (int i = 1; i < length+1; i++) {
            coordinatePlane.drawPlot((int)x, (int)y, Color.black);

            try {
                Thread.sleep(pause);
            } catch (InterruptedException pE) {
                pE.printStackTrace();
                Thread.currentThread().interrupt();
            }

//            coordinatePlane.drawSegment(x, y, x+dx, y+dy, Color.black);
            x+=dx;
            y+=dy;
            logInfo(i + "  " + String.format("%.2f", x) + "  " + String.format("%.2f", y) +
                    "  (" + (int)x + " " + (int)y + ")");
        }
        coordinatePlane.drawPlot((int)x, (int)y, Color.black);
    }
}
