package com.capgemini.molveno.BoatRental.Model;

import javax.persistence.Entity;

@Entity
public class ElectricalBoat extends Boat{
    private double pricePerHourElectrical;
    private double chargingTime;

    public double getPricePerHourElectrical() {
        return pricePerHourElectrical;
    }

    public void setPricePerHourElectrical(double pricePerHourElectrical) {
        this.pricePerHourElectrical = pricePerHourElectrical;
    }
}
