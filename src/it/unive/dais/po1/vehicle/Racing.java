package it.unive.dais.po1.vehicle;

import it.unive.dais.po1.vehicle.car.Car;
import it.unive.dais.po1.vehicle.car.FuelTank;
import it.unive.dais.po1.vehicle.car.Truck;

public class Racing {
    private double length;

    public Racing(double length) {
        this.length = length;
    }


    //Returns 1 if v1 wins, 2 if w2 wins, 0 otherwise
    public int race(Vehicle v1, Vehicle v2) throws SuspendedRaceException {
        try {
            v1.brake();
            v2.brake();
            if (v1 instanceof Car)
                ((Car) v1).refuel(new FuelTank(10.0, ((Car) v1).getFuelType()));
            if (v2 instanceof Car) {
                Car c2 = (Car) v2;
                c2.refuel(new FuelTank(10.0, c2.getFuelType()));
            }
            if (v1 instanceof UnloadableLoadable)
                ((UnloadableLoadable) v1).unload();
            if (v2 instanceof UnloadableLoadable)
                ((UnloadableLoadable) v2).unload();

            double v1_position = 0.0, v2_position = 0.0;
            while (v1_position < length && v2_position < length) {
                double amount_acceleration = 10 * Math.random();
                if (Math.random() >= 0.5)
                    v1.accelerate(amount_acceleration);
                else v2.accelerate(amount_acceleration);
                v1_position = v1_position + v1.getSpeed();
                v2_position = v2_position + v2.getSpeed();
            }
            if (v1_position >= length && v2_position < length)
                return 1;
            if (v2_position >= length && v1_position < length)
                return 2;
            return 0;
        }
        catch(NegativeSpeedException|ImpossibleAccelerationException e) {
            throw new SuspendedRaceException("Race suspended", e);
        }
        finally {
            if(v1!=null)
                v1.brake();
            v2.brake();
        }
    }


}
