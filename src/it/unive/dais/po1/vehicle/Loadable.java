package it.unive.dais.po1.vehicle;

public interface Loadable {

    public default void chargeLoad(double d) {
        if(d>=0)
            this.setLoad(this.getLoad() + d);
    }

    public double getLoad();
    public void setLoad(double d);
}
