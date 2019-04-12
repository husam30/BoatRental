package com.capgemini.molveno.BoatRental.Controller;

import com.capgemini.molveno.BoatRental.Model.RowingBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@Transactional
public class RowingBoatService {
    @Autowired
    private RowingRepository rowingRepository;

    public Iterable<RowingBoat> getAllBoatR() { return rowingRepository.findAll(); }

    private Optional<RowingBoat> getOneBoatR(Long id){
        return rowingRepository.findById(id);
    }

    public RowingBoat saveBoatR(RowingBoat newRBoat){
        return rowingRepository.save(newRBoat);
    }

    public void deleteBoatR(@RequestParam Long id){
        rowingRepository.deleteById(id);
    }

    public RowingBoat getSingleBoatR(Long id){
        Optional<RowingBoat> boat = getOneBoatR(id);
        if(boat.isPresent()){
            return boat.get();
        }
        return new RowingBoat();
    }

    public void editBoatR(@RequestBody RowingBoat boat) {


        RowingBoat g = rowingRepository.findById(boat.getId());


        if (boat.getBootNumber() == 0) {
            g.setBootNumber(boat.getBootNumber());
        }
        if (boat.getNumberOfSeats() == 0) {
            g.setNumberOfSeats(boat.getNumberOfSeats());
        }
        if (boat.getPricePerHourRowing() == 0) {
            g.setPricePerHourRowing(boat.getPricePerHourRowing());
        }

        rowingRepository.save(g);

    }
}
