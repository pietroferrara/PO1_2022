package it.unive.dais.po1.quadrilateral;

public class Quadrilateral {

    int edge1, edge2, edge3, edge4;


    public Quadrilateral(int edge1, int edge2, int edge3, int edge4) {
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.edge3 = edge3;
        this.edge4 = edge4;
    }

    public int getArea() {
        return -1;
    }

    public int getPerimeter() {
        return this.edge1 + this.edge2 + this.edge3 + this.edge4;
    }
}
