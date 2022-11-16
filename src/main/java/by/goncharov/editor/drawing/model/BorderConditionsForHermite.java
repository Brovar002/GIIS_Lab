package by.goncharov.editor.drawing.model;

public class BorderConditionsForHermite implements GeometryObject{
    private int firstValueP1;
    private int secondValueP1;
    private int firstValueP4;
    private int secondValueP4;
    private int firstValueR1;
    private int secondValueR1;
    private int firstValueR4;
    private int secondValueR4;

    public int getFirstValueP1() {
        return firstValueP1;
    }

    public void setFirstValueP1(int firstValueP1) {
        this.firstValueP1 = firstValueP1;
    }

    public int getSecondValueP1() {
        return secondValueP1;
    }

    public void setSecondValueP1(int secondValueP1) {
        this.secondValueP1 = secondValueP1;
    }

    public int getFirstValueP4() {
        return firstValueP4;
    }

    public void setFirstValueP4(int firstValueP4) {
        this.firstValueP4 = firstValueP4;
    }

    public int getSecondValueP4() {
        return secondValueP4;
    }

    public void setSecondValueP4(int secondValueP4) {
        this.secondValueP4 = secondValueP4;
    }

    public int getFirstValueR1() {
        return firstValueR1;
    }

    public void setFirstValueR1(int firstValueR1) {
        this.firstValueR1 = firstValueR1;
    }

    public int getSecondValueR1() {
        return secondValueR1;
    }

    public void setSecondValueR1(int secondValueR1) {
        this.secondValueR1 = secondValueR1;
    }

    public int getFirstValueR4() {
        return firstValueR4;
    }

    public void setFirstValueR4(int firstValueR4) {
        this.firstValueR4 = firstValueR4;
    }

    public int getSecondValueR4() {
        return secondValueR4;
    }

    public void setSecondValueR4(int secondValueR4) {
        this.secondValueR4 = secondValueR4;
    }
}
