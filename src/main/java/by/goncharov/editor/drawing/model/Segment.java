package by.goncharov.editor.drawing.model;

public class Segment implements GeometryObject{
    private double mStartX;
    private double mStartY;
    private double mFinishX;
    private double mFinishY;

    public double getStartX() {
        return mStartX;
    }

    public void setStartX(double pStartX) {
        mStartX = pStartX;
    }

    public double getStartY() {
        return mStartY;
    }

    public void setStartY(double pStartY) {
        mStartY = pStartY;
    }

    public double getFinishX() {
        return mFinishX;
    }

    public void setFinishX(double pFinishX) {
        mFinishX = pFinishX;
    }

    public double getFinishY() {
        return mFinishY;
    }

    public void setFinishY(double pFinishY) {
        mFinishY = pFinishY;
    }
}
