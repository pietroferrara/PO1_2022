package it.unive.dais.po1.car;

public class Car {

    public FuelType fuelType;
    private double fuel;
    private double speed;

    //It fully brakes the car
    public void brake() {
        speed = 0;
    }

    public double getSpeed() {
        return this.speed;
    }

    public double getAmountOfFuel() {
        return this.fuel;
    }

    //It adds the given amount of fuel to the tank of the car
    public void refuel(FuelTank tank) {
        if(tank.getFuelName().equals(fuelType.getFuelName()))
            this.fuel = this.fuel + tank.getAmount();
        else {
            System.err.println("I cannot use "+tank.getFuelName()+" with a car with "+fuelType.getFuelName());
        }
    }

    //It accelerates the car with the given speed
    //It consumes the fuel that is required to speed up the car
    //If amount is negative, it does nothing
    //If the fuel is not enough, it accelerates as much as possible
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

    public void crash(Car c) {
        this.speed = this.speed + c.speed;
        c.speed = 0;
    }


    public void setSpeed(double value) {
        if(value < 0)
            this.speed =0;
        else if(value <= this.speed)
            this.speed = value;
        else this.accelerate(value - this.speed);
    }
}
