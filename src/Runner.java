import it.unive.dais.po1.car.*;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Hello world");


        Car myCar;
        FuelType diesel = new FuelType("diesel", 0.015, 1.7);
        myCar = new Car();
        myCar.fuelType = diesel;
        FuelTank tank = new FuelTank(10, diesel);
        myCar.refuel(tank);
        //dieselTank.refuelCar(myCar);
        myCar.accelerate(-100);
        myCar.crash(myCar);
        myCar.brake();
        myCar.getSpeed();
        FuelType f = myCar.fuelType;
    }
}
