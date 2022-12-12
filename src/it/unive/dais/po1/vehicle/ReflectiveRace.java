package it.unive.dais.po1.vehicle;


import it.unive.dais.po1.datastructures.List;
import it.unive.dais.po1.vehicle.animalCarts.HorseCart;
import it.unive.dais.po1.vehicle.animalCarts.HorseWeddingCart;
import it.unive.dais.po1.vehicle.bicycle.Bicycle;
import it.unive.dais.po1.vehicle.car.Car;
import it.unive.dais.po1.vehicle.car.FuelType;
import it.unive.dais.po1.vehicle.car.Truck;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectiveRace {

    public static void main(String[] args) throws ImpossibleAccelerationException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Vehicle> vehicles = createAllPossibleVehicles();
        System.out.println(new RacingList<Vehicle>(40).race(vehicles));
    }

    private static List<Vehicle> createAllPossibleVehicles() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Vehicle> result = new List<>();
        result.add(getInstanceOf(Car.class));
        result.add(getInstanceOf(Bicycle.class));
        result.add(getInstanceOf(Truck.class));
        result.add(getInstanceOf(HorseCart.class));
        result.add(getInstanceOf(HorseWeddingCart.class));
        return result;
    }

    private static Vehicle getInstanceOf(Class carClass) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for(Constructor constr : carClass.getConstructors()) {
            Object[] parValues = getDefaultValues(constr.getParameterTypes());
            if(parValues!=null)
                return (Vehicle) constr.newInstance(parValues);
        }
        return null;
    }

    private static Object[] getDefaultValues(Class[] parameterTypes) {
        Object[] result = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++){
            Object o = giveDefaultValue(parameterTypes[i]);
            if(o==null)
                return null;
            result[i] = o;
        }
        return result;
    }

    private static Object giveDefaultValue(Class parameterType) {
        if(parameterType.equals(double.class))
            return 0.0;
        if(parameterType.equals(int.class))
            return 1;
        if(parameterType.equals(FuelType.class))
            return new FuelType("diesel", 0.0012, 1.7);
        return null;
    }
}
