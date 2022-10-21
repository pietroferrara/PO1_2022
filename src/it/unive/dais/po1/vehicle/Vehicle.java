package it.unive.dais.po1.vehicle;

public class Vehicle {

    /**
     * @invariant this.speed >= 0
     */
    public double speed;


    //It fully brakes the car
    public void brake() {
        speed = 0;
    }

    /**
     * It returns the current speed of the car
     *
     * @return the current speed of the
     * @postcondition return >= 0
     */
    public double getSpeed() {
        return this.speed;
    }


    /**
     *
     It accelerates the car with the given speed
     It consumes the fuel that is required to speed up the car
     If the fuel is not enough, it accelerates as much as possible

     @param amount the number of km/h we want to accelerate.
     It must be a value greater than or equal to zero.

     */
    public void accelerate(double amount) {
        if(amount < 0)
            throw new AssertionError("amount must be greater than or equal to zero");
        speed = speed + amount;
    }
}
