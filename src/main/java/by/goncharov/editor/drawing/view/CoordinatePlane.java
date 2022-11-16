package by.goncharov.editor.drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import by.goncharov.editor.drawing.model.Segment;

public class CoordinatePlane extends JPanel implements CoordinatePlaneConstants{

	private BufferedImage firstBuffer;
	private BufferedImage secondBuffer;
	private BufferedImage coordinateBuffer;

	public CoordinatePlane(){
        setMaximumSize(new Dimension(COORDINATE_PLANE_WIDTH, COORDINATE_PLANE_HEIGHT));
		firstBuffer = new BufferedImage(COORDINATE_PLANE_WIDTH, COORDINATE_PLANE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		secondBuffer = new BufferedImage(COORDINATE_PLANE_WIDTH, COORDINATE_PLANE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		coordinateBuffer = new BufferedImage(COORDINATE_PLANE_WIDTH, COORDINATE_PLANE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		drawCoordinatePlane();
	}

    public void drawSegment(Segment pSegment, Color pColor){
        drawSegment(pSegment.getStartX(), pSegment.getStartY(),
                pSegment.getFinishX(), pSegment.getFinishY(), pColor);
    }

    public void drawInAllQuarter(double x, double y, double centerX, double centerY){
        drawPlot((int)x, (int)y, Color.black);
        drawPlot((int)(centerX-Math.abs(centerX-x)), (int)y, Color.black);
        drawPlot((int)x, (int)(centerY-Math.abs(centerY-y)), Color.black);
        drawPlot((int)(centerX-Math.abs(centerX-x)), (int)(centerY-Math.abs(centerY-y)), Color.black);
    }

    public void drawSegment(double startX, double startY, double finishX, double finishY, Color pColor){
        int x1 = getXOnPlane(startX);
        int y1 = getYOnPlane(startY);
        int x2 = getXOnPlane(finishX);
        int y2 = getYOnPlane(finishY);

        Graphics pain = secondBuffer.getGraphics();
        Graphics2D painter = (Graphics2D)pain;
        painter.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        painter.setBackground(new Color(255,255,255,0));
        painter.setStroke(new BasicStroke(4));
        painter.setColor(pColor);

        painter.drawLine(x1, y1, x2, y2);
        painter.setStroke(new BasicStroke(8));
        painter.drawLine(x1, y1, x1, y1);
        painter.drawLine(x2, y2, x2, y2);
        repaint();
    }

    public void drawPlot(int x, int y, Color pColor){
        int x1 = getXOnPlane(x);
        int y1 = getYOnPlane(y);
        int x2 = getXOnPlane(x+1);
        int y2 = getYOnPlane(y+1);

        Graphics pain = firstBuffer.getGraphics();
        Graphics2D painter = (Graphics2D)pain;
        painter.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        painter.setBackground(new Color(255,255,255,0));
        painter.setStroke(new BasicStroke(4));
        painter.setColor(pColor);

        painter.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
        repaint();
    }

    public void clearCoordinatePlane(){
        Graphics pain = firstBuffer.getGraphics();
        Graphics2D painter = (Graphics2D)pain;
        painter.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        painter.setBackground(new Color(255,255,255,0));
        painter.clearRect(0, 0, COORDINATE_PLANE_WIDTH, COORDINATE_PLANE_HEIGHT);

        pain = secondBuffer.getGraphics();
        painter = (Graphics2D)pain;
        painter.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        painter.setBackground(new Color(255,255,255,0));
        painter.clearRect(0, 0, COORDINATE_PLANE_WIDTH, COORDINATE_PLANE_HEIGHT);
        repaint();
    }

    @Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(coordinateBuffer, null, null);
        g2.drawImage(firstBuffer, null, null);
        g2.drawImage(secondBuffer, null, null);
	}

	private void drawCoordinatePlane(){
		Graphics pain = coordinateBuffer.getGraphics();
		Graphics2D painter = (Graphics2D)pain;
		painter.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		painter.setBackground(new Color(255,255,255,0));
		painter.setColor(Color.gray);

		for (int i = 0; i < COORDINATE_PLANE_WIDTH; i+= COORDINATE_PLANE_CELL) {
			painter.drawLine(i, 0, i, COORDINATE_PLANE_HEIGHT);
		}

		for (int i = 0; i < COORDINATE_PLANE_HEIGHT; i+= COORDINATE_PLANE_CELL) {
			painter.drawLine(0, i, COORDINATE_PLANE_WIDTH, i);
		}

		painter.setStroke(new BasicStroke(4));
		painter.setColor(Color.black);
		painter.drawLine(COORDINATE_PLANE_WIDTH/2, 0, COORDINATE_PLANE_WIDTH/2, COORDINATE_PLANE_HEIGHT);
		painter.drawLine(COORDINATE_PLANE_WIDTH/2, 0, COORDINATE_PLANE_WIDTH/2+10, 10);
		painter.drawLine(COORDINATE_PLANE_WIDTH/2, 0, COORDINATE_PLANE_WIDTH/2-10, 10);
		painter.drawLine(0, COORDINATE_PLANE_HEIGHT/2, COORDINATE_PLANE_WIDTH, COORDINATE_PLANE_HEIGHT/2);
		painter.drawLine(COORDINATE_PLANE_WIDTH-10, COORDINATE_PLANE_HEIGHT/2+10,
				COORDINATE_PLANE_WIDTH, COORDINATE_PLANE_HEIGHT/2);
		painter.drawLine(COORDINATE_PLANE_WIDTH-10, COORDINATE_PLANE_HEIGHT/2-10,
				COORDINATE_PLANE_WIDTH, COORDINATE_PLANE_HEIGHT/2);

		for (int i = COORDINATE_PLANE_WIDTH/2; i < COORDINATE_PLANE_WIDTH; i+= COORDINATE_PLANE_STEP * COORDINATE_PLANE_CELL) {
			painter.drawLine(i, COORDINATE_PLANE_HEIGHT/2- COORDINATE_PLANE_CELL /4,
                    i, COORDINATE_PLANE_HEIGHT/2+ COORDINATE_PLANE_CELL /4);
        }
        for (int i = COORDINATE_PLANE_WIDTH/2; i >0; i-= COORDINATE_PLANE_STEP * COORDINATE_PLANE_CELL) {
            painter.drawLine(i, COORDINATE_PLANE_HEIGHT/2- COORDINATE_PLANE_CELL /4,
                    i, COORDINATE_PLANE_HEIGHT/2+ COORDINATE_PLANE_CELL /4);
        }
        for (int i = COORDINATE_PLANE_HEIGHT/2; i < COORDINATE_PLANE_HEIGHT; i+= COORDINATE_PLANE_STEP * COORDINATE_PLANE_CELL) {
            painter.drawLine(COORDINATE_PLANE_WIDTH/2 - COORDINATE_PLANE_CELL /4, i,
                    COORDINATE_PLANE_WIDTH/2+ COORDINATE_PLANE_CELL /4, i);
        }
        for (int i = COORDINATE_PLANE_HEIGHT/2; i > 0; i-= COORDINATE_PLANE_STEP * COORDINATE_PLANE_CELL) {
            painter.drawLine(COORDINATE_PLANE_WIDTH/2- COORDINATE_PLANE_CELL /4, i,
                    COORDINATE_PLANE_WIDTH/2+ COORDINATE_PLANE_CELL /4, i);
        }

		repaint();
	}

    private int getXOnPlane(double pValue){
        int coordinate = COORDINATE_PLANE_WIDTH/2 + ((int)(COORDINATE_PLANE_CELL*pValue))*COORDINATE_PLANE_STEP;
        return coordinate;
    }

    private int getXOnPlane(int pValue){
        int coordinate = COORDINATE_PLANE_WIDTH/2 + (COORDINATE_PLANE_CELL*pValue)*COORDINATE_PLANE_STEP;
        return coordinate;
    }

    private int getYOnPlane(double pValue){
        int coordinate = COORDINATE_PLANE_HEIGHT/2 - ((int)(COORDINATE_PLANE_CELL*pValue))*COORDINATE_PLANE_STEP;
        return coordinate;
    }

    private int getYOnPlane(int pValue){
        int coordinate = COORDINATE_PLANE_HEIGHT/2 - (COORDINATE_PLANE_CELL*pValue)*COORDINATE_PLANE_STEP;
        return coordinate;
    }
}
