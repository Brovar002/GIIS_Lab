package by.goncharov.editor.drawing.model;

public class Circle implements GeometryObject{
    private double circleX;
    private double circleY;
    private double circleR;

    public double getCircleX() {
        return circleX;
    }

    public void setCircleX(double pCircleX) {
        circleX = pCircleX;
    }

    public double getCircleY() {
        return circleY;
    }

    public void setCircleY(double pCircleY) {
        circleY = pCircleY;
    }

    public double getCircleR() {
        return circleR;
    }

    public void setCircleR(double pCircleR) {
        circleR = pCircleR;
    }
}
