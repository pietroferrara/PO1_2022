package it.unive.dais.po1.quadrilateral;

public class Rectangle extends Quadrilateral {

    public Rectangle(int edge1, int edge2) {
        super(edge1, edge2, edge1, edge2);
    }
    public int getArea() {
        return this.edge1*this.edge2;
    }
}
