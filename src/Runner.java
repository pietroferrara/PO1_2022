import it.unive.dais.po1.car.Car;
import it.unive.dais.po1.car.FuelTank;
import it.unive.dais.po1.car.FuelType;
import it.unive.dais.po1.wrappers.IntWrapper;

public class Runner {

    public static void main(String[] args) {

        int x = 5;
        int y = 10;
        y = x;
        x = x+1;

        IntWrapper xw = new IntWrapper(5);
        IntWrapper yw = null;
        yw = xw;
        xw.i = xw.i+1;

        Car myCar, yourCar;
        FuelType diesel = new FuelType("diesel", 0.015, 1.7);
        diesel = new FuelType("dieselPlus", 0.020, 2.0);
        //diesel.name = "diesel";
        //diesel.FUEL_CONSUMPTION = 0.015;
        //diesel.costPerLiter = 1.7;
        FuelType petrol = new FuelType("petrol", 0.01, 1.5);
        //petrol.name = "petrol";
        //petrol.FUEL_CONSUMPTION = 0.01;
        petrol.costPerLiter = 1.5;
        myCar = new Car();
        myCar.fuelType = diesel;
        FuelTank tank = new FuelTank(10, petrol);
        FuelTank dieselTank = new FuelTank(20, diesel);
        myCar.refuel(tank);
        //dieselTank.refuelCar(myCar);
        myCar.accelerate(100);
        myCar.brake();
        FuelTank.resetTankCounter();
        diesel.costPerLiter = 1.6;
    }
}
