package com.capgemini.molveno.BoatRental.API;


import com.capgemini.molveno.BoatRental.Controller.GuestRepository;
import com.capgemini.molveno.BoatRental.Controller.GuestService;
import com.capgemini.molveno.BoatRental.Model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/guest")
public class GuestEndpoint {
    @Autowired
    private GuestService guestService;

    @GetMapping("/all-guest")
    public List<Guest> getAllGuest(){ return guestService.getAllGuest(); }

    @PostMapping("/add-one-guest")
    public Guest saveGuest(@RequestBody @Valid @NotNull Guest newGuest){
        return guestService.saveGuest(newGuest);
    }

    @GetMapping("/get-one-guest")
    public Guest getSingleGuest(@RequestParam Long id){
        return guestService.getSingleGuest(id);
    }

    @DeleteMapping("/delete-one-guest")
    public void deleteGuest(@RequestParam Long id){
        guestService.deleteGuest(id);
    }

    @PostMapping("/edit-guest")
    public Guest editGuest(@RequestBody @Valid @NotNull Guest editguest){
        return guestService.saveGuest(editguest);}

}
