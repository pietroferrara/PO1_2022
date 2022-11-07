package it.unive.dais.po1.vehicle;

public interface UnloadableLoadable extends Loadable {


    public default double unload() {
        double totalLoad = this.getLoad();
        this.setLoad(0);
        return totalLoad;
    }
}
