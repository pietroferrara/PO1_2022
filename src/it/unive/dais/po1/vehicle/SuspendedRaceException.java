package it.unive.dais.po1.vehicle;

public class SuspendedRaceException extends Throwable {
    public SuspendedRaceException(String race_suspended, Exception e) {
        super(race_suspended, e);
    }
}
