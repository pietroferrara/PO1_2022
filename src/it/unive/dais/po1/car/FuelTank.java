package it.unive.dais.po1.car;

public class FuelTank {
    private double amount;
    private final FuelType type;
    private final int tankId;

    private static int numberOfTanks;

    static final int MAX_NUMBER_OF_TANKS = 1000;

    public FuelTank(double amount, FuelType type) {
        this.amount = amount;
        this.type = type;
        if(FuelTank.numberOfTanks > 0 && FuelTank.numberOfTanks < FuelTank.MAX_NUMBER_OF_TANKS)
            this.tankId = FuelTank.numberOfTanks;
        else this.tankId = -1;
        FuelTank.numberOfTanks = FuelTank.numberOfTanks + 1;
    }

    static {
        FuelTank.resetTankCounter();
    }

    public void refuelCar(Car c) {
        c.refuel(this);
    }

    private static void resetTankCounter() {
        FuelTank.numberOfTanks = 0;
    }

    public String getFuelName() {
        return this.type.getFuelName();
    }

    public double getAmount() {
        return this.amount;
    }
}
