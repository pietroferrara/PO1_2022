package it.unive.dais.po1.car;

/**
 * This class is an abstract of a car that can accelerate, brake, and refuel.
 *
 * @author Pietro Ferrara
 */
public class Car {

    /**
     * It represents the fuel type of the car
     */
    public FuelType fuelType;
    private double fuel;
    private double speed;

    //It fully brakes the car
    public void brake() {
        speed = 0;
    }

    /**
     * It returns the current speed of the car
     *
     * @return the current speed of the car
     */
    public double getSpeed() {
        return this.speed;
    }

    public double getAmountOfFuel() {
        return this.fuel;
    }

    /**
     *
     It adds the given amount of fuel to the tank of the car
     {@link FuelTank}
     */
    public void refuel(FuelTank tank) {
        if(tank.getFuelName().equals(fuelType.getFuelName()))
            this.fuel = this.fuel + tank.getAmount();
        else {
            System.err.println("I cannot use "+tank.getFuelName()+" with a car with "+fuelType.getFuelName());
        }
    }

    /**
     *
     It accelerates the car with the given speed
     It consumes the fuel that is required to speed up the car
     If amount is negative, it does nothing
     If the fuel is not enough, it accelerates as much as possible
     */
    public void accelerate(double amount) {
        if(amount < 0)
            return;
        double consumption = amount*fuelType.FUEL_CONSUMPTION;
        if(consumption <= this.fuel) {
            speed = speed + amount;
            fuel = fuel - consumption * fuelType.FUEL_CONSUMPTION;
        }
        else {
            consumption = this.fuel;
            this.fuel = 0;
            speed = speed + consumption/fuelType.FUEL_CONSUMPTION;
        }
    }

    /**
     * The given car crashes against the current car.
     * The result is that car {@literal c} stops, while the current car gets the speed of the other car
     * @param c the car that is crashing against the current one
     */
    public void crash(Car c) {
        this.speed = this.speed + c.speed;
        c.speed = 0;
    }


    /**
     * It sets the speed of the car to the current value.
     * If the given value is negative, it does nothing.
     * If it increases the speed, it dispatches the call to accelerate.
     * @param value
     */
    public void setSpeed(double value) {
        if(value < 0)
            this.speed =0;
        else if(value <= this.speed)
            this.speed = value;
        else this.accelerate(value - this.speed);
    }
}
