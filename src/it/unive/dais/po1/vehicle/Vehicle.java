package it.unive.dais.po1.vehicle;

abstract public class Vehicle {

    /**
     * @invariant this.speed >= 0
     */
    protected double speed;

    public Vehicle(double initialSpeed) {
        if(initialSpeed>=0)
            this.speed = initialSpeed;
        else this.speed = 0;
    }


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
    abstract protected void accelerate(double amount);
}