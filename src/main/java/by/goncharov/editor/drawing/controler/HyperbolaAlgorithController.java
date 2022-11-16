package by.goncharov.editor.drawing.controler;

import by.goncharov.editor.drawing.model.Hyperbola;
import by.goncharov.editor.drawing.view.CoordinatePlane;
import by.goncharov.editor.view.WorkingAreaPanel;

public class HyperbolaAlgorithController extends AlgorithmController {

    public HyperbolaAlgorithController(WorkingAreaPanel pWorkingAreaPanel) {
        super(pWorkingAreaPanel);
    }

    @Override
    public void buildGeometryObjectByAlgorithm() {
        Hyperbola hyperbola = (Hyperbola) mGeometryObject;
        CoordinatePlane coordinatePlane = mWorkingAreaPanel.getCoordinatePlane();
        coordinatePlane.clearCoordinatePlane();

        int a = hyperbola.getA();
        int b = hyperbola.getB();
        int x = hyperbola.getX();
        int y = hyperbola.getY();
        int bound = 20;
    }

}

