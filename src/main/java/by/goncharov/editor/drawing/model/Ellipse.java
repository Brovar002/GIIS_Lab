package by.goncharov.editor.drawing.model;

public class Ellipse implements GeometryObject{
    private double eclipseX;
    private double eclipseY;
    private double eclipseA;
    private double eclipseB;

    public double getEclipseX() {
        return eclipseX;
    }

    public void setEclipseX(double pCircleX) {
        eclipseX = pCircleX;
    }

    public double getEclipseY() {
        return eclipseY;
    }

    public void setEclipseY(double pCircleY) {
        eclipseY = pCircleY;
    }

    public double getEclipseA() {
        return eclipseA;
    }

    public void setEclipseA(double pCircleA) {
        eclipseA = pCircleA;
    }

    public double getEclipseB() {
        return eclipseB;
    }

    public void setEclipseB(double pCircleB) {
        eclipseB = pCircleB;
    }
}
