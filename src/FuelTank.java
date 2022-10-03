public class FuelTank {
    double amount;
    FuelType type;

    final int tankId;

    static int numberOfTanks;

    FuelTank(double amount, FuelType type) {
        this.amount = amount;
        this.type = type;
        if(FuelTank.numberOfTanks > 0)
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
