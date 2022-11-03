import it.unive.dais.po1.accessibility.A;
import it.unive.dais.po1.quadrilateral.Rectangle;
import it.unive.dais.po1.quadrilateral.Rhombus;
import it.unive.dais.po1.quadrilateral.Square;
import it.unive.dais.po1.vehicle.Vehicle;
import it.unive.dais.po1.vehicle.bicycle.Bicycle;
import it.unive.dais.po1.vehicle.car.*;

public class Runner {


    //Returns 1 if v1 wins, 2 if w2 wins, 0 otherwise
    public static int race(Vehicle v1, Vehicle v2, double length) {
        v1.brake();
        v2.brake();
        double v1_position = 0.0, v2_position = 0.0;
        while(v1_position < length && v2_position < length) {
            double amount_acceleration = 10*Math.random();
            if(Math.random()>=0.5)
                v1.accelerate(amount_acceleration);
            else v2.accelerate(amount_acceleration);
            v1_position = v1_position + v1.getSpeed();
            v2_position = v2_position + v2.getSpeed();
        }
        if(v1_position >= length && v2_position < length)
            return 1;
        if(v2_position >= length && v1_position < length)
            return 2;
        return 0;
    }

    public static void main(String[] args) {
        FuelType ft = new FuelType("diesel", 0.017, 1.7);
        Car myCar = new Car(0, ft, 10);
        myCar.accelerate(10);
        myCar.isFuelEmpty();

        Bicycle myBicycle = new Bicycle(0);
        myBicycle.accelerate(10);
        myBicycle.brake();

        race(myCar, myBicycle, 100);
    }
}
