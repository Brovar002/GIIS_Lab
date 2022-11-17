package by.goncharov.editor.drawing.controler;

import by.goncharov.editor.drawing.model.Parabola;
import by.goncharov.editor.drawing.view.CoordinatePlane;
import by.goncharov.editor.view.WorkingAreaPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class ParabolaAlgorithController extends AlgorithmController {
    public static final Logger LOGGER = LogManager.getLogger(ParabolaAlgorithController.class);

    public ParabolaAlgorithController(WorkingAreaPanel pWorkingAreaPanel) {
        super(pWorkingAreaPanel);
    }

    @Override
    public void buildGeometryObjectByAlgorithm() {
        Parabola parabola = (Parabola) mGeometryObject;
        CoordinatePlane coordinatePlane = mWorkingAreaPanel.getCoordinatePlane();
        coordinatePlane.clearCoordinatePlane();
        int pause = mCheckoutMod ? 1000 : 0;

        int p = parabola.getP();
        int x = parabola.getX();
        int y = parabola.getY();
        int y1 = y;
        int bound = 20;
        int d;
        int p2;
        int p4;
        p2 = 2 * p;
        p4 = p2 * 2;
        d = 1 - p;
        int i = 0;

        while ((y < p) && (x <= bound)) {
            try {
                Thread.sleep(pause);
            } catch (InterruptedException pE) {
                pE.printStackTrace();
                Thread.currentThread().interrupt();
            }
            coordinatePlane.drawPlot(x, y, Color.black);
            coordinatePlane.drawPlot(x, y1, Color.black);
            LOGGER.info("i " + ++i + " d " + d + " " + x + " " + y);
            if (d >= 0) {
                x++;
                d -= p2;
            }
            y++;
            y1--;
            d += 2 * y + 1;
        }
        if (d == 1) {
            d = 1 - p4;
        } else {
            d = 1 - p2;
        }
        while (x <= bound) {
            try {
                Thread.sleep(pause);
            } catch (InterruptedException pE) {
                pE.printStackTrace();
                Thread.currentThread().interrupt();
            }
            coordinatePlane.drawPlot(x, y, Color.black);
            coordinatePlane.drawPlot(x, y1, Color.black);
            LOGGER.info("i " + ++i + " d " + d + " " + x + " " + y);
            if (d <= 0) {
                y++;
                y1--;
                d += 4 * y;
            }
            x++;
            d -= p4;
        }
    }
}

