public class Car {

    FuelType fuelType;
    double fuel;
    double speed;

    //It fully brakes the car
    void brake() {
        speed = 0;
    }

    //It adds the given amount of fuel to the tank of the car
    void refuel(FuelTank tank) {
        if(tank.type.name.equals(fuelType.name))
            this.fuel = this.fuel + tank.amount;
        else {
            System.err.println("I cannot use "+tank.type.name+" with a car with "+fuelType.name);
        }
    }

    //It accelerates the car with the given speed
    //It consumes the fuel that is required to speed up the car
    void accelerate(double amount) {
        speed = speed + amount;
        fuel = fuel - amount*fuelType.FUEL_CONSUMPTION;
    }
}
