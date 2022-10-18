package it.unive.dais.po1.bicycles;

public class Bicycle {

    private double speed = 0;

    public void accelerate(double amount) {
        if(amount>0)
            this.speed += amount;
    }

    public void brake() {
        this.speed = 0;
    }

    public double getSpeed() {
        return this.speed;
    }
}
