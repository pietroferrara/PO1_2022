import it.unive.dais.po1.quadrilateral.Rectangle;
import it.unive.dais.po1.quadrilateral.Rhombus;
import it.unive.dais.po1.quadrilateral.Square;
import it.unive.dais.po1.vehicle.Vehicle;
import it.unive.dais.po1.vehicle.bicycle.Bicycle;
import it.unive.dais.po1.vehicle.car.*;

public class Runner {

    public static void main(String[] args) {
        FuelType ft = new FuelType("diesel", 0.017, 1.7);
        Car myCar = new Car(0, ft, 10);
        myCar.accelerate(10000);
        myCar.isFuelEmpty();

        Bicycle myBicycle = new Bicycle(0);
        myBicycle.accelerate(10);
        myBicycle.brake();
    }
}
