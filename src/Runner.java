import it.unive.dais.po1.accessibility.A;
import it.unive.dais.po1.datastructures.List;
import it.unive.dais.po1.printing.Printable;
import it.unive.dais.po1.quadrilateral.Quadrilateral;
import it.unive.dais.po1.quadrilateral.Rectangle;
import it.unive.dais.po1.quadrilateral.Rhombus;
import it.unive.dais.po1.quadrilateral.Square;
import it.unive.dais.po1.vehicle.*;
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

        List<? extends Car> listCar = new List<>();
        List<? extends Vehicle> list = listCar;

        Vehicle v = list.get(0);


        List<Car> listCar1 = new List<>();
        List<Vehicle> list1 = listCar;


        list.add(myCar2);
        list.add(myTruck);

        /*Car[] arrayCars = new Car[3];
        arrayCars[0] = myCar1;
        arrayCars[1] = myTruck;

        Vehicle[] arrayVehicle = (Car[]) arrayCars;
        arrayVehicle[2] = new Bicycle(0, 0, 0);
        Car newCar = arrayCars[2];
        */


        RacingList<Vehicle> listrace = new RacingList<>(20);
        System.out.println("The winner is "+listrace.race(listCar));

        System.out.println("Number of vehicles: "+v1.getNumberOfVehicles());

        System.out.println("Number of cars: "+myCar1.getNumberOfVehicles());

        List t = new List<Car>();
        t = new List<String>();

        String s = Runner.identity("pippo");
        Car car = Runner.identity(new Car(0, ft, 0));
    }

    //template<typename T>
    static <T> T identity(T par) {
        return par;
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
