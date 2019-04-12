package com.capgemini.molveno.BoatRental.Controller;

import com.capgemini.molveno.BoatRental.Model.Boat;
import com.capgemini.molveno.BoatRental.Model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@Transactional
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    public Iterable<Guest> getAllGuest() { return guestRepository.findAll(); }

    private Optional<Guest> getOneGuest(Long id){
        return guestRepository.findById(id);
    }

    public Guest saveGuest(Guest newGuest){
        return guestRepository.save(newGuest);
    }

    public void deleteGuest(@RequestParam Long id){
        guestRepository.deleteById(id);
    }

    public Guest getSingleGuest(Long id){
        Optional<Guest> boat = getOneGuest(id);
        if(boat.isPresent()){
            return boat.get();
        }
        return new Guest();
    }

    public void editGuest(@RequestBody Guest guest) {


        Guest g = guestRepository.findById(guest.getId());


        if (!guest.getFirstName().equals("")) {
            g.setFirstName(guest.getFirstName());
        }
        if (!guest.getLastName().equals("")) {
            g.setLastName(guest.getLastName());
        }
        if (!guest.getEmail().equals("")) {
            g.setEmail(guest.getEmail());
        }

        guestRepository.save(g);

    }
}
