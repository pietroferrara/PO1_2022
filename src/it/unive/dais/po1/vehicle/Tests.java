package it.unive.dais.po1.vehicle;

import it.unive.dais.po1.vehicle.car.Car;
import it.unive.dais.po1.vehicle.car.FuelTank;
import it.unive.dais.po1.vehicle.car.FuelType;
import it.unive.dais.po1.vehicle.car.Truck;
import org.junit.jupiter.api.Test;

import java.util.AbstractSet;

public class Tests {

    @Test
    public void test1() throws SuspendedRaceException {
        FuelType ft = new FuelType("diesel", 0.017, 1.7);
        FuelType ft1 = new FuelType("diesel", 0.017, 1.7);
        Car myCar1 = new Car(0, ft, 0);
        Truck myTruck = new Truck(0, ft, 0);
        FuelTank tank = new FuelTank(10.0, ft1);
        myCar1.refuel(tank);
        Racing r = new Racing(100);
        int winner = r.race(myCar1, myTruck);
    }

    @Test
    public void test2() {

    }


    @Test
    public void test3() {
        Integer n = Math.random() >= 0.5 ?
                Integer.valueOf(1) :
                null;
        n.byteValue();
    }
}
