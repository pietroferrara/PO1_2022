import it.unive.dais.po1.accessibility.A;
import it.unive.dais.po1.printing.Printable;
import it.unive.dais.po1.quadrilateral.Quadrilateral;
import it.unive.dais.po1.quadrilateral.Rectangle;
import it.unive.dais.po1.quadrilateral.Rhombus;
import it.unive.dais.po1.quadrilateral.Square;
import it.unive.dais.po1.vehicle.Loadable;
import it.unive.dais.po1.vehicle.Racing;
import it.unive.dais.po1.vehicle.UnloadableLoadable;
import it.unive.dais.po1.vehicle.Vehicle;
import it.unive.dais.po1.vehicle.animalCarts.HorseCart;
import it.unive.dais.po1.vehicle.animalCarts.HorseWeddingCart;
import it.unive.dais.po1.vehicle.bicycle.Bicycle;
import it.unive.dais.po1.vehicle.car.*;

public class Runner {



    public static void main(String[] args) {

        FuelType ft = new FuelType("diesel", 0.017, 1.7);
        Car myCar1 = new Car(0, ft, 0);
        Car myCar2 = new Car(0, ft, 0);
        Truck myTruck = new Truck(0, ft, 0);

        Vehicle v1 = myCar1;
        Vehicle v2 = myCar2;
        Racing race = new Racing(10.0);

        race.race(myCar1, (Car) myTruck);

        race.race((Vehicle) myCar1, myTruck);

        race.race(v1, myTruck);

        System.out.println("Number of vehicles: "+v1.getNumberOfVehicles());

        System.out.println("Number of cars: "+myCar1.getNumberOfVehicles());
    }

    private static void printIfPossible(Object o) {
        if(o instanceof Printable)
            ((Printable) o).print();
    }

    private static Quadrilateral giveMeARandomQuadrilateral() {
        if(Math.random()>=0.5)
            return new Square((int)(Math.random()*10.0));
        else if(Math.random()>=0.5)
            return new Rectangle((int)(Math.random()*10.0), (int)(Math.random()*10.0));
        else return new Rhombus((int)(Math.random()*10.0), (int)(Math.random()*10.0));


    }
}
