package com.capgemini.molveno.BoatRental.Controller;


import com.capgemini.molveno.BoatRental.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class ReservationService {
    @Autowired
    private GuestService guestService;
   // @Autowired
    //private BoatService BoatService;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ElectricalBoatService electricalBoatService;
    @Autowired
    private RowingBoatService rowingBoatService;
    @Autowired
    private RiverRaftBoatService riverRaftBoatService;
    @Autowired
    private BoatRepository boatRepository;

    //get all  boat
    public List<Boat> getAllBoats(String type){
        List<Boat> boats = new ArrayList<>();
        if(type.equals("Electrical")){
            boats.addAll(electricalBoatService.getAllBoatE());
        }
        if(type.equals("Rowing")){
            boats.addAll(rowingBoatService.getAllBoatR());
        }
        if(type.equals("RiverRaft")) {
            boats.addAll(riverRaftBoatService.getAllBoatRr());
        }
        return boats;
    }
    public Reservation saveReservation(Reservation reservation){
        changeBoatStatus(reservation);
        return reservationRepository.save(reservation);


    }

    public void changeBoatStatus(Reservation reservation){
        List<Boat> boats = new ArrayList<>();
        boats.addAll(reservation.getBoatArrayList());
        for (Boat b: boats){
            if(b instanceof ElectricalBoat){
                 ElectricalBoat c=(ElectricalBoat)b;
                 c.setBoatStatus("Reserved");
                 electricalBoatService.saveBoatE(c);
            }
            if(b instanceof RowingBoat){
                RowingBoat c = (RowingBoat) b;
                c.setBoatStatus("Reserved");
                rowingBoatService.saveBoatR(c);
            }
            if(b instanceof RiverRaftBoat){
                RiverRaftBoat c = (RiverRaftBoat) b;
                c.setBoatStatus("Reserved");
                riverRaftBoatService.saveBoatRr(c);
            }

        }
    }
    //electrical boat availablity
/*    public  boolean Reservation(LocalDateTime startDate, LocalDateTime endDate) {

        List<ElectricalBoat> boatsE = electricalRepository.findAll();
        List<RowingBoat> boatsR = rowingRepository.findAll();
        List<RiverRaftBoat> boatsRR = riverRaftRepository.findAll();
        List<Boat> boats = new ArrayList<>();
        boats.addAll(boatsE);
        boats.addAll(boatsR);
        boats.addAll(boatsRR);



        List<Trip> trips1 = new ArrayList<>();
        LocalDateTime a = LocalDateTime.now();



        long boatId = boats.get(0).getId();

        LocalDateTime min = startDate;
        LocalDateTime max = endDate.plusHours(1);

        for (Reservation current : currentReservations) {
            if (current.getBoatArrayList().getId() != boatId) {
                continue;
            }
            if (max.isAfter(current.getStartDate()) & max.isBefore((current.getEndDate()).plusHours(1))) {
                return false;
            }
            if (min.isAfter(current.getStartDate()) & min.isBefore((current.getEndDate()).plusHours(1))) {
                return false;
            }
            if (min.isEqual(current.getStartDate()) & max.isEqual((current.getEndDate()).plusHours(1))) {
                return false;
            }
        }
        return true;
    }

    public  List<Boat> getAvailableBoats(LocalDateTime startDateRequest,LocalDateTime endDateRequest, List<Boat> allBoats, List<Reservation> reservations) {
        List<Boat> availableBoats = new ArrayList<>();
        for (Boat boat : allBoats) {
            if (checkDateTime(startDateRequest ,endDateRequest, reservations, boat)) {
                availableBoats.add(boat);

            }

        }
        return availableBoats;

    }*/
}
