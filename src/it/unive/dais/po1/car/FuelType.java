package it.unive.dais.po1.car;

public class FuelType {
    final double FUEL_CONSUMPTION;
    private final String name;
    private final double costPerLiter;

    public FuelType(String name, double FUEL_CONSUMPTION, double costPerLiter) {
        this.name = name;
        if(FUEL_CONSUMPTION >= 0)
            this.FUEL_CONSUMPTION = FUEL_CONSUMPTION;
        else this.FUEL_CONSUMPTION = 0;
        if(costPerLiter >= 0)
            this.costPerLiter = costPerLiter;
        else this.costPerLiter = 0;
    }

    public String getFuelName() {
        return this.name;
    }
}
