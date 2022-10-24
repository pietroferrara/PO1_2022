package it.unive.dais.po1.vehicle.bicycle;

import it.unive.dais.po1.vehicle.Vehicle;

public class Bicycle extends Vehicle {


    public Bicycle(double initialSpeed, double frontPressure, double rearPressure) {
        super(initialSpeed);
        this.frontTire = frontPressure;
        this.rearTire = rearPressure;
    }

    public Bicycle(double initialSpeed) {
        this(initialSpeed, 2.0, 2.0);
    }

    @Override
    public void accelerate(double amount) {
        if(amount < 0)
            throw new AssertionError("amount must be greater than or equal to zero");
        this.speed = this.speed + amount;
    }
    protected double accelerate(String s) {
        this.accelerate(Double.valueOf(s));
        return this.speed;
    }


    private double speed;
    private double frontTire = 2.0, rearTire = 2.0;
    public double frontTirePressure() {
        return frontTire;
    }
    public double rearTirePressure() {
        return rearTire;
    }

}
