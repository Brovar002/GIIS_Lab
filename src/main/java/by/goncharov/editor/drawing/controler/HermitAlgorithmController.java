package by.goncharov.editor.drawing.controler;

import Jama.Matrix;
import by.goncharov.editor.drawing.model.BorderConditionsForHermite;
import by.goncharov.editor.drawing.view.CoordinatePlane;
import by.goncharov.editor.view.WorkingAreaPanel;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.awt.Color;

public class HermitAlgorithmController extends AlgorithmController {

    public static final Logger LOGGER = LogManager.getLogger(HermitAlgorithmController.class);

    public HermitAlgorithmController(WorkingAreaPanel pWorkingAreaPanel) {
        super(pWorkingAreaPanel);
    }

    @Override
    public void buildGeometryObjectByAlgorithm() {
        BorderConditionsForHermite hermite = (BorderConditionsForHermite) mGeometryObject;
        CoordinatePlane coordinatePlane = mWorkingAreaPanel.getCoordinatePlane();
        coordinatePlane.clearCoordinatePlane();
        double[][] arrayHermit = {{2., -2., 1., 1.}, {-3., 3., -2., -1.}, {0., 0., 1., 0.}, {1., 0., 0., 0.}};

        double[][] arrayCondition = {{hermite.getFirstValueP1(), hermite.getSecondValueP1()},
                {hermite.getFirstValueP4(), hermite.getSecondValueP4()},
                {hermite.getFirstValueR1(), hermite.getSecondValueR1()},
                {hermite.getFirstValueR4(), hermite.getSecondValueR4()}};

        Matrix hermitMatrix = new Matrix(arrayHermit);
        Matrix inputMatrix = new Matrix(arrayCondition);
        Matrix resultMatrix = hermitMatrix.times(inputMatrix);

        for (double t = 0; t < 10; t++) {
            double t1 = (1 + t) / 10;
            double t2 = t1 * t1;
            double t3 = t1 * t1 * t1;

            double[][] arrayT = {{t3, t2, t1, 1}};
            Matrix matrixT = new Matrix(arrayT);
            Matrix result = matrixT.times(resultMatrix);


            LOGGER.info(result.get(0, 0));
            LOGGER.info(result.get(0, 1));

            int x = (int) Math.round(result.get(0, 0));
            int y = (int) Math.round(result.get(0, 1));

            LOGGER.info("x=" + x);
            LOGGER.info("y=" + y);

            coordinatePlane.drawPlot(x, y, new Color(0,0,0));
        }
    }
}
