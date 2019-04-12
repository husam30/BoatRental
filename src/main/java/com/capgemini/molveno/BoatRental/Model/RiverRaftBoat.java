package com.capgemini.molveno.BoatRental.Model;

import javax.persistence.Entity;

@Entity
public class RiverRaftBoat extends Boat {
    private double pricePerHourRaft;

    public double getPricePerHourRaft() {
        return pricePerHourRaft;
    }

    public void setPricePerHourRaft(double pricePerHourRaft) {
        this.pricePerHourRaft = pricePerHourRaft;
    }
}
