package it.unive.dais.po1.car;

public class FuelTank {
    double amount;
    FuelType type;

    final int tankId;

    static int numberOfTanks;

    static final int MAX_NUMBER_OF_TANKS = 1000;

    FuelTank(double amount, FuelType type) {
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

    void refuelCar(Car c) {
        c.refuel(this);
    }

    static void resetTankCounter() {
        FuelTank.numberOfTanks = 0;
    }
}
