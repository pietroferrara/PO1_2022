public class FuelType {
    double FUEL_CONSUMPTION;
    String name;
    double costPerLiter;

    FuelType(String name) {
        this.name = name;
    }

    FuelType(String name, double FUEL_CONSUMPTION, double costPerLiter) {
        this(name);
        this.FUEL_CONSUMPTION = FUEL_CONSUMPTION;
        this.costPerLiter = costPerLiter;
    }
}
