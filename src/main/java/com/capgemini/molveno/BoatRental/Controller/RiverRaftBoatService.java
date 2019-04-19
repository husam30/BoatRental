package com.capgemini.molveno.BoatRental.Controller;

import com.capgemini.molveno.BoatRental.Model.RiverRaftBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class RiverRaftBoatService {
    @Autowired
    private RiverRaftRepository riverRaftRepository;

    public List<RiverRaftBoat> getAllBoatRr() { return riverRaftRepository.findAll(); }

    private Optional<RiverRaftBoat> getOneBoatRr(Long id){
        return riverRaftRepository.findById(id);
    }

    public RiverRaftBoat saveBoatRr(RiverRaftBoat newRrBoat){
        return riverRaftRepository.save(newRrBoat);
    }

    public void deleteBoatRr(@RequestParam Long id){
        riverRaftRepository.deleteById(id);
    }

    public RiverRaftBoat getSingleBoatRr(Long id){
        Optional<RiverRaftBoat> boat = getOneBoatRr(id);
        if(boat.isPresent()){
            return boat.get();
        }
        return new RiverRaftBoat();
    }

    public void editBoatRr(@RequestBody RiverRaftBoat boat) {


        RiverRaftBoat g = riverRaftRepository.findById(boat.getId());


        if (boat.getBootNumber() == 0) {
            g.setBootNumber(boat.getBootNumber());
        }
        if (boat.getNumberOfSeats() == 0) {
            g.setNumberOfSeats(boat.getNumberOfSeats());
        }
        if (boat.getPrice() == 0) {
            g.setPrice(boat.getPrice());
        }

        riverRaftRepository.save(g);

    }
}
