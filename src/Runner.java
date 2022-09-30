public class Runner {

    public static void main(String[] args) {
        Car myCar, yourCar;
        FuelType diesel = new FuelType();
        diesel.name = "diesel";
        diesel.FUEL_CONSUMPTION = 0.015;
        diesel.costPerLiter = 1.7;
        FuelType petrol = new FuelType();
        petrol.name = "petrol";
        petrol.FUEL_CONSUMPTION = 0.01;
        petrol.costPerLiter = 1.5;
        myCar = new Car();
        myCar.fuelType = diesel;
        FuelTank tank = new FuelTank();
        tank.type = petrol;
        tank.amount = 10;
        myCar.refuel(tank);
        myCar.accelerate(100);
        myCar.brake();
    }
}
