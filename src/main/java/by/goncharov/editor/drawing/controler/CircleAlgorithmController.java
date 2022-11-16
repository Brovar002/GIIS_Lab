package by.goncharov.editor.drawing.controler;

import by.goncharov.editor.drawing.model.Circle;
import by.goncharov.editor.drawing.view.CoordinatePlane;
import by.goncharov.editor.view.WorkingAreaPanel;

public class CircleAlgorithmController extends AlgorithmController {
	public CircleAlgorithmController(WorkingAreaPanel pWorkingAreaPanel) {
		super(pWorkingAreaPanel);
	}

	@Override
	public void buildGeometryObjectByAlgorithm() {
		Circle circle = (Circle) mGeometryObject;
		CoordinatePlane coordinatePlane = mWorkingAreaPanel.getCoordinatePlane();
		coordinatePlane.clearCoordinatePlane();
		int pause = mCheckoutMod?1000:0;

		double centerX, centerY, r, delta, x, y, limit, sigma;
		centerX = circle.getCircleX();
		centerY = circle.getCircleY();
		r = circle.getCircleR();

        x = centerX; y = centerY+r; limit = centerY;
        delta = 2 - 2*r;

        coordinatePlane.drawInAllQuarter(x, y, centerX, centerY);

        logInfo("D - 0");
        logInfo("H - 1");
        logInfo("V - 2");
        logInfo("  i  Di  s  s*  p   x  y  Di+1");
        String logTemplate = "--- --- --- --- --- --- --- ---";
        String tableRow = logTemplate;
        tableRow = insertLogInfo(tableRow, 0, 0);
        tableRow = insertLogInfo(tableRow, 5, (int)x);
        tableRow = insertLogInfo(tableRow, 6, (int)y);
        tableRow = insertLogInfo(tableRow, 7, (int)delta);
        logInfo(tableRow);
        int i = 1;
        while (y > limit){
            try {
                Thread.sleep(pause);
            } catch (InterruptedException pE) {
                pE.printStackTrace();
            }

            tableRow = logTemplate;
            tableRow = insertLogInfo(tableRow, 0, i);
            tableRow = insertLogInfo(tableRow, 1, (int)delta);
            if (delta == 0){
                x = x + 1;
                y = y - 1;
                delta = delta + 2*x - 2*y + 2;
                tableRow = insertLogInfo(tableRow, 4, 0);
            } else if (delta > 0){
                sigma = 2*delta - 2*x - 1;
                tableRow = insertLogInfo(tableRow, 3, (int)sigma);
                if (sigma > 0){
                    y = y - 1;
                    delta = delta - 2*y + 1;
                    tableRow = insertLogInfo(tableRow, 4, 0);
                } else {
                    x = x + 1;
                    y = y - 1;
                    delta = delta + 2*x - 2*y + 2;
                    tableRow = insertLogInfo(tableRow, 4, 2);
                }
            } else if (delta < 0) {
                sigma = 2*delta + 2*y -1;
                tableRow = insertLogInfo(tableRow, 2, (int)sigma);
                if (sigma <= 0){
                    x = x + 1;
                    delta = delta + 2*x + 1;
                    tableRow = insertLogInfo(tableRow, 4, 1);
                } else {
                    x = x + 1;
                    y = y - 1;
                    delta = delta + 2*x - 2*y + 2;
                    tableRow = insertLogInfo(tableRow, 4, 2);
                }
            }
            tableRow = insertLogInfo(tableRow, 5, (int)x);
            tableRow = insertLogInfo(tableRow, 6, (int)y);
            tableRow = insertLogInfo(tableRow, 7, (int)delta);
            coordinatePlane.drawInAllQuarter(x, y, centerX, centerY);
            i++;
            logInfo(tableRow);
        }
    }

    private String insertLogInfo(String template, int cell, int info){
        String answer;
        String insertInfo = String.valueOf(info);
        int left, right;
        left = 4*cell;
        right = left+2;
        while (insertInfo.length()<3) insertInfo = " " + insertInfo;

        answer = template.substring(0, left) + insertInfo + template.substring(right+1, template.length());
        return answer;
    }
}
