package com.capgemini.molveno.BoatRental.Controller;


import com.capgemini.molveno.BoatRental.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    //get all  boat\
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
            Optional<ElectricalBoat> electricalBoatOptional = electricalBoatService.getOneBoatE(b.getId());
            if(electricalBoatOptional.isPresent()){
                ElectricalBoat electricalBoat = electricalBoatOptional.get();
                electricalBoat.setBoatStatus("Reserved");
                electricalBoatService.saveBoatE(electricalBoat);

            }else{
                Optional<RowingBoat> rowingBoatOptional = rowingBoatService.getOneBoatR(b.getId());
                if(rowingBoatOptional.isPresent()){
                    RowingBoat rowingBoat = rowingBoatOptional.get();
                    rowingBoat.setBoatStatus("Reserved");
                    rowingBoatService.saveBoatR(rowingBoat);

                }else {
                    Optional<RiverRaftBoat> riverRaftBoatOptional = riverRaftBoatService.getOneBoatRr(b.getId());
                    if(riverRaftBoatOptional.isPresent()){
                        RiverRaftBoat riverRaftBoat = riverRaftBoatOptional.get();
                        riverRaftBoat.setBoatStatus("Reserved");
                        riverRaftBoatService.saveBoatRr(riverRaftBoat);
                    }
                }
            }
        }
    }
}
