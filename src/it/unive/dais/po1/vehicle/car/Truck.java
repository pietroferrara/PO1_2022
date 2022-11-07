package it.unive.dais.po1.vehicle.car;

import it.unive.dais.po1.vehicle.Loadable;
import it.unive.dais.po1.vehicle.UnloadableLoadable;

final public class Truck extends Car implements UnloadableLoadable {

    private double load;

    public Truck(double initialSpeed, FuelType ft, double amountOfFuel, double initialLoad) {
        super(initialSpeed, ft, amountOfFuel);
        this.load = initialLoad;
    }

    public Truck(double initialSpeed, FuelType ft, double amountOfFuel) {
        this(initialSpeed, ft, amountOfFuel, 0.0);
    }
    public Truck(double initialSpeed, FuelType ft) {
        this(initialSpeed, ft, 0.0);
    }

    @Override
    public double getLoad() {
        return this.load;
    }

    @Override
    public void setLoad(double d) {
        this.load = d;
    }

}
