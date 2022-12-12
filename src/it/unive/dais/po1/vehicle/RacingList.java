package it.unive.dais.po1.vehicle;

import it.unive.dais.po1.datastructures.List;
import it.unive.dais.po1.vehicle.car.Car;
import it.unive.dais.po1.vehicle.car.FuelTank;
import it.unive.dais.po1.vehicle.car.Truck;

public class RacingList<T extends Vehicle> {
    private double length;

    public RacingList(double length) {
        this.length = length;
    }


    //Returns 1 if v1 wins, 2 if w2 wins, 0 otherwise
    public int race(List<Vehicle> v) throws ImpossibleAccelerationException {
        for(int i = 0; i < v.size(); i++)
            v.get(i).brake();
        for(int i = 0; i < v.size(); i++)
            if(v.get(i) instanceof Car)
                ((Car) v.get(i)).refuel(new FuelTank(10.0, ((Car) v.get(i)).getFuelType()));

        for(int i = 0; i < v.size(); i++)
            if(v.get(i) instanceof UnloadableLoadable)
                ((UnloadableLoadable) v.get(i)).unload();

        List<Double> positions = new List<Double>();
        for(int i = 0; i < v.size(); i++)
            positions.add(0.0);
        while(noVehicleAtTheEnd(positions)) {
            double amount_acceleration = 10*Math.random();
            int vToBeAccelerate = (int) (Math.random()*v.size());
            try {
                v.get(vToBeAccelerate).accelerate(amount_acceleration);
            } catch (NegativeSpeedException e) {
                try {
                    v.get(vToBeAccelerate).accelerate(0.0 - amount_acceleration);
                } catch (NegativeSpeedException ex) {
                    throw new IllegalArgumentException("0 minus a negative value results in a negative value");
                }
            }
            for(int i = 0; i < v.size(); i++)
                positions.replace(i,positions.get(i)+v.get(i).getSpeed());
        }
        return getWinner(positions);
    }

    private int getWinner(List<Double> positions) {
        double current_max = positions.get(0);
        int winner = 0;
        for(int i=1; i< positions.size(); i++)
            if(positions.get(i)>current_max) {
                current_max = positions.get(i);
                winner = i;
            }
        return winner;
    }

    private boolean noVehicleAtTheEnd(List<Double> positions) {
        for(int i = 0; i < positions.size(); i++)
            if(positions.get(i) >= length)
                return false;
        return true;
    }

    public int race(Car v1, Car v2) {
        System.out.println("Racing among cars");
        return 0;
    }

    public int race(Vehicle v1, Truck v2) {
        System.out.println("Racing among a vehicle and a truck");
        return 0;
    }
    public int race(Vehicle v1, Car v2) {
        System.out.println("Racing among a vehicle and a car");
        return 0;
    }
}
