package it.unive.dais.po1.vehicle.car;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.Objects;

@XmlRootElement
@XmlType
public class FuelType {

    @XmlElement
    double FUEL_CONSUMPTION;

    @XmlAttribute
    private String name;

    @Override
    public String toString() {
        return "Fuel:" + name + " consuming " + FUEL_CONSUMPTION + " costing "+costPerLiter;
    }

    @XmlElement
    private double costPerLiter;


    public FuelType() {}

    public FuelType(String name, double FUEL_CONSUMPTION, double costPerLiter) {
        this.name = name;
        if(FUEL_CONSUMPTION >= 0)
            this.FUEL_CONSUMPTION = FUEL_CONSUMPTION;
        else this.FUEL_CONSUMPTION = 0;
        if(costPerLiter >= 0)
            this.costPerLiter = costPerLiter;
        else this.costPerLiter = 0;
    }

    public String getFuelName() {
        return this.name;
    }
/*
    @Override
    public boolean equals(Object obj) {
        if( ! (obj instanceof FuelType))
            return false;
        else {
            if(this.FUEL_CONSUMPTION==0.15)
                return false;
            return this.getFuelName().equals(((FuelType) obj).getFuelName());
        }
    }*/

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        FuelType fuelType = (FuelType) o;
        return Objects.equals(name, fuelType.name);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FuelType fuelType = (FuelType) o;

        return name != null ? name.equals(fuelType.name) : fuelType.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public FuelType clone() throws CloneNotSupportedException {
        return new FuelType(this.name, this.FUEL_CONSUMPTION, this.costPerLiter);
    }
}
