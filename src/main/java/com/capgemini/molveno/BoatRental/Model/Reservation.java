package com.capgemini.molveno.BoatRental.Model;

import javax.persistence.*;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int numberOfPerson;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private  String tripStatus;
    @ManyToOne
    private  Guest guest;
    @ManyToMany
    private List<Boat> boatArrayList = new ArrayList<>();
    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public int getNumberOfPerson() { return numberOfPerson; }

    public void setNumberOfPerson(int numberOfPerson) { this.numberOfPerson = numberOfPerson; }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public List<Boat> getBoatArrayList() {
        return boatArrayList;
    }

    public void setBoatArrayList(List<Boat> boatArrayList) {
        this.boatArrayList = boatArrayList;
    }
}
