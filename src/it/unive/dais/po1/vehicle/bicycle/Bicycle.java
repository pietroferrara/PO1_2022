package it.unive.dais.po1.vehicle.bicycle;

import it.unive.dais.po1.printing.ErrorPrintable;
import it.unive.dais.po1.printing.Printable;
import it.unive.dais.po1.vehicle.ImpossibleAccelerationException;
import it.unive.dais.po1.vehicle.NegativeSpeedException;
import it.unive.dais.po1.vehicle.Vehicle;

public class Bicycle extends Vehicle implements ErrorPrintable {


    public Bicycle(double initialSpeed, double frontPressure, double rearPressure) {
        super(initialSpeed);
        this.frontTire = frontPressure;
        this.rearTire = rearPressure;
    }

    public Bicycle(double initialSpeed) {
        this(initialSpeed, 2.0, 2.0);
    }

    protected void accelerate(String s) throws NegativeSpeedException, ImpossibleAccelerationException {
        this.accelerate(Double.valueOf(s));
        //return this.speed;
    }


    private double frontTire = 2.0, rearTire = 2.0;
    public double frontTirePressure() {
        return frontTire;
    }
    public double rearTirePressure() {
        return rearTire;
    }

    @Override
    public void print() {
        System.out.println("I'm a bicycle");
    }

    @Override
    public void printError() {
        System.err.println("I'm a broken bicycle");
    }
}
