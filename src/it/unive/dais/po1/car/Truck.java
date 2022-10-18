package it.unive.dais.po1.car;
public class Truck {

    /**
     * It represents the fuel type of the car
     */
    public FuelType fuelType;
    /**
     * @invariant this.fuel >= 0
     */
    private double fuel;
    /**
     * @invariant this.speed >= 0
     */
    private double speed;

    private double load;

    public void chargeLoad(double amount) {
        if(amount >= 0)
            this.load = this.load + amount;
    }

    public double unload() {
        double totalLoad = this.load;
        this.load=0;
        return totalLoad;
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
     * It returns the current amount of fuel in the car
     *
     * @return the current amount of fuel in the car
     * @postcondition return >= 0
     */
    public double getAmountOfFuel() {
        return this.fuel;
    }

    /**
     * It returns the fuel consumption of the current car
     *
     * @return the fuel consumption
     * @postcondition return >= 0
     */
    public double getFuelConsumption() {
        return this.fuelType.FUEL_CONSUMPTION;
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
     If the fuel is not enough, it accelerates as much as possible

     @param amount the number of km/h we want to accelerate.
     It must be a value greater than or equal to zero.
     @precondition/@requires amount >= 0

     TOO LONG VERSION
     @postcondition/@ensures amount*this.getFuelConsumption() <= prev(this.getAmountOfFuel()) =>
     this.getSpeed() = prev(this.getSpeed()) + amount
     AND this.getAmountOfFuel() = prev(this.getAmountOfFuel()) - amount*this.getFuelConsumption()
     @postcondition/@ensures amount*this.getFuelConsumption() > prev(this.getAmountOfFuel()) =>
     this.getSpeed() = prev(this.getSpeed()) + prev(this.getAmountOfFuel())/this.getFuelConsumption()
     AND this.getAmountOfFuel() = 0

     RIGHT LEVEL OF ABSTRACTION

     @postcondition/@ensures
     this.getSpeed() >= prev(this.getSpeed())
     AND this.getAmountOfFuel() <= prev(this.getAmountOfFuel())
     */
    public void accelerate(double amount) {
        if(amount < 0)
            throw new AssertionError("amount must be greater than or equal to zero");
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
    public void crash(Truck c) {
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
