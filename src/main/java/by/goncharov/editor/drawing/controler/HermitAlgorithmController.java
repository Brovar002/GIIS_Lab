package by.goncharov.editor.drawing.controler;

import Jama.Matrix;
import by.goncharov.editor.drawing.model.BorderConditionsForHermite;
import by.goncharov.editor.drawing.view.CoordinatePlane;
import by.goncharov.editor.view.WorkingAreaPanel;

import java.awt.Color;

public class HermitAlgorithmController extends AlgorithmController {

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


            System.out.println(result.get(0, 0));
            System.out.println(result.get(0, 1));

            int x = (int) Math.round(result.get(0, 0));
            int y = (int) Math.round(result.get(0, 1));

            System.out.println("x=" + x);
            System.out.println("y=" + y);
            System.out.println();

            coordinatePlane.drawPlot(x, y, new Color(0,0,0));
        }
    }
}
