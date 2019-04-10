package com.capgemini.molveno.BoatRental.API;


import com.capgemini.molveno.BoatRental.Controller.GuestRepository;
import com.capgemini.molveno.BoatRental.Controller.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/guest")
public class GuestEndpoint {
    @Autowired
    private GuestService guestService;

}
