package it.unive.dais.po1.vehicle.animalCarts;

import it.unive.dais.po1.printing.Printable;
import it.unive.dais.po1.vehicle.UnloadableLoadable;
import it.unive.dais.po1.vehicle.Vehicle;

public class HorseCart extends Vehicle implements UnloadableLoadable, Printable {

    private double load;

    public HorseCart(double initialSpeed, double load) {
        super(initialSpeed);
        this.load = load;
    }

    @Override
    public double getLoad() {
        return this.load;
    }

    @Override
    public void setLoad(double d) {
        this.load = d;
    }

    @Override
    public void print() {
        System.out.println("I'm an horse cart with "+this.load+" kgs of load");
    }
}
