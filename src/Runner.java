import it.unive.dais.po1.car.Car;
import it.unive.dais.po1.car.FuelTank;
import it.unive.dais.po1.car.FuelType;
import it.unive.dais.po1.wrappers.IntWrapper;

public class Runner {

    public static void main(String[] args) {


        Car myCar;
        FuelType diesel = new FuelType("diesel", 0.015, 1.7);
        myCar = new Car();
        myCar.fuelType = diesel;
        FuelTank tank = new FuelTank(10, diesel);
        myCar.refuel(tank);
        //dieselTank.refuelCar(myCar);
        myCar.accelerate(100);
        myCar.brake();
    }
}
