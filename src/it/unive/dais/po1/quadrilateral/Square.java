package it.unive.dais.po1.quadrilateral;


public class Square extends Quadrilateral {

    public Square(int edgeLength) {
        super(edgeLength, edgeLength, edgeLength, edgeLength);
    }

    public Square() {
        this(1);
    }

    public int getArea() {
        return this.edge1 * this.edge1;
    }
}
