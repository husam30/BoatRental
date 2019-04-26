package com.capgemini.molveno.BoatRental.Controller;

import com.capgemini.molveno.BoatRental.Model.ElectricalBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class ElectricalBoatService {
    @Autowired
    private ElectricalRepository electricalRepository;

    public List<ElectricalBoat> getAllBoatE() { return electricalRepository.findAll(); }

    public Optional<ElectricalBoat> getOneBoatE(Long id){
        return electricalRepository.findById(id);
    }

    public ElectricalBoat saveBoatE(ElectricalBoat newEBoat){
        return electricalRepository.save(newEBoat);
    }

    public void deleteBoatE(Long id){
        electricalRepository.deleteById(id);
    }

    public ElectricalBoat getSingleBoatE(Long id){
        Optional<ElectricalBoat> boat = getOneBoatE(id);
        if(boat.isPresent()){
            return boat.get();
        }
        return new ElectricalBoat();
    }

    public void editBoatE( ElectricalBoat boat) {


        ElectricalBoat g = electricalRepository.findById(boat.getId());


        if (boat.getBootNumber() != 0) {
            g.setBootNumber(boat.getBootNumber());
        }
        if (boat.getNumberOfSeats() != 0) {
            g.setNumberOfSeats(boat.getNumberOfSeats());
        }
        if (boat.getPrice() != 0) {
            g.setPrice(boat.getPrice());
        }

        electricalRepository.save(g);

    }
    public void setPrice(double price){
        List<ElectricalBoat> ebs = electricalRepository.findAll();
        for ( ElectricalBoat boats : ebs){
            boats.setPrice(price);
        }
        electricalRepository.saveAll(ebs);
    }

}
