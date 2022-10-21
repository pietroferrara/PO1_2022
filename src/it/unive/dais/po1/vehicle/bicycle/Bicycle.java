package it.unive.dais.po1.vehicle.bicycle;

import it.unive.dais.po1.vehicle.Vehicle;

public class Bicycle extends Vehicle {

    private double speed;
    private double frontTire = 2.0, rearTire = 2.0;
    public double frontTirePressure() {
        super.speed = 10;
        this.speed = 20;
        return frontTire;
    }
    public double rearTirePressure() {
        return rearTire;
    }
}
