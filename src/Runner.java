import it.unive.dais.po1.accessibility.A;
import it.unive.dais.po1.quadrilateral.Quadrilateral;
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
        if(v1 instanceof Car) {
            Car c1 = (Car) v1;
            c1.refuel(new FuelTank(10.0, c1.getFuelType()));
        }
        if(v2 instanceof Car) {
            Car c2 = (Car) v2;
            c2.refuel(new FuelTank(10.0, c2.getFuelType()));
        }

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
        Vehicle myCar = new Car(0, ft, 0);
        myCar.accelerate(10);

        Vehicle myBicycle = new Bicycle(0);
        myBicycle.accelerate(10);
        myBicycle.brake();

        Vehicle myTruck = new Truck(0.0, ft);

        race(myTruck, myCar, 10);

    }

    private static Quadrilateral giveMeARandomQuadrilateral() {
        if(Math.random()>=0.5)
            return new Square((int)(Math.random()*10.0));
        else if(Math.random()>=0.5)
            return new Rectangle((int)(Math.random()*10.0), (int)(Math.random()*10.0));
        else return new Rhombus((int)(Math.random()*10.0), (int)(Math.random()*10.0));


    }
}
