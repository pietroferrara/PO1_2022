package it.unive.dais.po1.vehicle.car;

import it.unive.dais.po1.vehicle.ImpossibleAccelerationException;

public class NotEnoughFuelException extends ImpossibleAccelerationException {
    public NotEnoughFuelException(String s) {
        super(s);
    }
}
