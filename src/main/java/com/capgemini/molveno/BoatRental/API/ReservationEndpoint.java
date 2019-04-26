package com.capgemini.molveno.BoatRental.API;

import com.capgemini.molveno.BoatRental.Controller.ReservationService;
import com.capgemini.molveno.BoatRental.Model.Boat;
import com.capgemini.molveno.BoatRental.Model.Guest;
import com.capgemini.molveno.BoatRental.Model.Reservation;
import com.capgemini.molveno.BoatRental.Model.RiverRaftBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin(origins = "*")
public class ReservationEndpoint {
    @Autowired
    private ReservationService reservationService;
    //get all boats
    @GetMapping("/all-boats/{type}")
    public List<Boat> getAllBoat(@PathVariable String type){
        return reservationService.getAllBoats(type);
    }

    @PostMapping("/add-reservation")
    public Reservation saveGuest(@RequestBody @Valid @NotNull Reservation reservation){
        return reservationService.saveReservation(reservation);
    }
}
