package it.unive.dais.po1.vehicle.car;
public class Truck extends Car {

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


        public void chargeLoad(double amount) {
        if(amount >= 0)
            this.load = this.load + amount;
    }

    public double unload() {
        double totalLoad = this.load;
        this.load=0;
        return totalLoad;
    }

    public void accelerate(double amount) {
        this.speed = this.speed + amount;
    }
}
