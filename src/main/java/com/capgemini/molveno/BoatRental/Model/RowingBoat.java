package com.capgemini.molveno.BoatRental.Model;

import javax.persistence.Entity;

@Entity
public class RowingBoat  extends Boat{
    private double pricePerHourRowing;

    public double getPricePerHourRowing() {
        return pricePerHourRowing;
    }

    public void setPricePerHourRowing(double pricePerHourRowing) {
        this.pricePerHourRowing = pricePerHourRowing;
    }
}
