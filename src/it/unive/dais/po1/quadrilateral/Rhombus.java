package it.unive.dais.po1.quadrilateral;

public class Rhombus extends Quadrilateral {
    private int height;

    public Rhombus(int edge, int height) {
        super(edge, edge, edge, edge);
        this.height = height;
    }

    @Override
    public int getArea() {
        return this.edge1 * this.height;
    }
}
