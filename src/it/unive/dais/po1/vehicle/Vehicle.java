package it.unive.dais.po1.vehicle;

import it.unive.dais.po1.vehicle.car.NotEnoughFuelException;

import java.util.Objects;

abstract public class Vehicle implements Comparable<Vehicle> {

    private static int NumberOfVehicles = 1;

    @Override
    public int compareTo(Vehicle o) {
        if(this.equals(o))
            return 0;
        else if(this.speed!=o.speed)
                return  ((int) (this.speed-o.speed));
        else return this.id-o.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.speed, speed) == 0 && id == vehicle.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed, id);
    }

    @Override
    public String toString() {
        return "Vehicle with id " + id + " and with speed "+speed+"km/h";
    }

    /**
     * @invariant this.speed >= 0
     */
    private double speed;
    private int id;

    public Vehicle(double initialSpeed) {
        if(initialSpeed>=0)
            this.speed = initialSpeed;
        else this.speed = 0;
        this.id = Vehicle.NumberOfVehicles;
        Vehicle.NumberOfVehicles++;
    }



    public static int getNumberOfVehicles() {
        return Vehicle.NumberOfVehicles;
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
    public void accelerate(double amount) throws NegativeSpeedException, ImpossibleAccelerationException {
        if(amount < 0)
            throw new NegativeSpeedException("amount must be greater than or equal to zero");
        this.speed = this.speed + amount;
    }

    public void slowdown(double amount) {
        if(amount < 0)
            throw new AssertionError("amount must be greater than or equal to zero");
        if(amount > this.speed)
            throw new AssertionError("amount is greater than the current speed of the vehicle");
        this.speed = this.speed - amount;
    }
}
