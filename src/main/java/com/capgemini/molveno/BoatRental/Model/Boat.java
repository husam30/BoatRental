package com.capgemini.molveno.BoatRental.Model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private  int numberOfSeats;
    private  int bootNumber;
    private double price;
    private String boatStatus = "Avalible";

    public  long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getBootNumber() {
        return bootNumber;
    }

    public void setBootNumber(int bootNumber) {
        this.bootNumber = bootNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBoatStatus() {
        return boatStatus;
    }

    public void setBoatStatus(String boatStatus) {
        this.boatStatus = boatStatus;
    }
}
