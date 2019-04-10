package com.capgemini.molveno.BoatRental.Controller;

import com.capgemini.molveno.BoatRental.Model.Boat;
import com.capgemini.molveno.BoatRental.Model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;
    @RequestMapping(value = "/allguest", method = RequestMethod.GET)
    public List<Guest> getAll() {
        return guestRepository.findAll();
    }
}
