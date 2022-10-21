import it.unive.dais.po1.quadrilateral.Rectangle;
import it.unive.dais.po1.quadrilateral.Rhombus;
import it.unive.dais.po1.quadrilateral.Square;
import it.unive.dais.po1.vehicle.bicycle.Bicycle;
import it.unive.dais.po1.vehicle.car.*;

public class Runner {

    public static void main(String[] args) {
        Bicycle b = new Bicycle();
        b.accelerate(10);
        System.out.println("The speed is "+b.getSpeed());
        double frontpressure = b.frontTirePressure();

        Square s = new Square(2);
        System.out.println("The area is "+s.getArea());
    }
}
