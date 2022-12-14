package it.unive.dais.po1.vehicle.car;

import it.unive.dais.po1.vehicle.ImpossibleAccelerationException;
import it.unive.dais.po1.vehicle.NegativeSpeedException;
import it.unive.dais.po1.vehicle.Vehicle;

/**
 * This class is an abstract of a car that can accelerate, brake, and refuel.
 *
 * @invariant this.getSpeed()>=0
 * @invariant this.getAmountOfFuel()>=0
 *
 * @author Pietro Ferrara
 */
public class Car extends Vehicle {


    /**
     * It represents the fuel type of the car
     */
    private final FuelType fuelType;
    /**
     * @invariant this.fuel >= 0
     */
    private double fuel;


    public Car(double initialSpeed, FuelType ft, double amountOfFuel) {
        super(initialSpeed);
        this.fuelType = ft;
        this.fuel = amountOfFuel;
    }

    public Car(double initialSpeed, FuelType ft) {
        this(initialSpeed, ft, 0.0);
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
        if(tank.getFuelType().equals(fuelType))
            this.fuel = this.fuel + tank.getAmount();
        else {
            System.err.println("I cannot use "+tank.getFuelType()+" with a car with "+fuelType.getFuelName());
        }
    }

    @Deprecated(forRemoval = true)
    public void refuel(double amount) {
        assert amount >= 0.0;
        this.fuel += amount;
    }

    public static int getNumberOfVehicles() {
        return -1;
    }

    /**
     *
     It accelerates the car with the given speed
     It consumes the fuel that is required to speed up the car
     If the fuel is not enough, it accelerates as much as possible

     @param amount the number of km/h we want to accelerate.
                It must be a value greater than or equal to zero.
     @throws NegativeSpeedException
                if the given amount is less than zero
     @throws NotEnoughFuelException
                if the fuel is not enough to finalize the acceleration
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
    @Override
    final public void accelerate(double amount)
            throws NegativeSpeedException, ImpossibleAccelerationException {
        double consumption = amount*fuelType.FUEL_CONSUMPTION;
        if(consumption <= this.fuel) {
            super.accelerate(amount);
            fuel = fuel - consumption * fuelType.FUEL_CONSUMPTION;
        }
        else
            throw new NotEnoughFuelException("You needed "+consumption+" lt of fuel but you had only "+this.fuel);
        /*{
            consumption = this.fuel;
            this.fuel = 0;
            super.accelerate(consumption/fuelType.FUEL_CONSUMPTION);
        }*/
    }

    /**
     * The given car crashes against the current car.
     * The result is that car {@literal c} stops, while the current car gets the speed of the other car
     * @param c the car that is crashing against the current one
     */
    public void crash(Car c) throws NegativeSpeedException, ImpossibleAccelerationException {
        super.accelerate(c.getSpeed());
        c.brake();
    }

    public boolean isFuelEmpty() throws NegativeSpeedException, ImpossibleAccelerationException {
        if(fuel>0)
            return false;
        else {
            super.accelerate(-this.getSpeed() * 0.1);
            super.slowdown(this.getSpeed()*0.1);
            return true;
        }
    }

    public FuelType getFuelType() {
        return this.fuelType;
    }

}
