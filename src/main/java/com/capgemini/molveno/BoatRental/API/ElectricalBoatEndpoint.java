package com.capgemini.molveno.BoatRental.API;

import com.capgemini.molveno.BoatRental.Controller.ElectricalBoatService;
import com.capgemini.molveno.BoatRental.Model.ElectricalBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/electricaboat")
@CrossOrigin(origins = "*")
public class ElectricalBoatEndpoint {
    @Autowired
    private ElectricalBoatService electricalBoatService;

    @GetMapping("/all-boat")
    public List<ElectricalBoat> getAllBoat(){ return electricalBoatService.getAllBoatE(); }

    @PostMapping("/add-one-boat")
    public ElectricalBoat saveBoat(@RequestBody @Valid @NotNull ElectricalBoat newBoat){
        return electricalBoatService.saveBoatE(newBoat);
    }

    @GetMapping("/get-one-boat")
    public ElectricalBoat getSingleBoat(@PathVariable Long id){
        return electricalBoatService.getSingleBoatE(id);
    }

    @DeleteMapping("/delete-one-boat/{id}")
    public void deleteBoat(@PathVariable Long id){
        electricalBoatService.deleteBoatE(id);
    }

    @PostMapping("/edit-boat")
    public ElectricalBoat editBoat(@RequestBody @Valid @NotNull ElectricalBoat editBoat){
        return electricalBoatService.saveBoatE(editBoat);}


    @GetMapping("/set-price/{price}")
    public void setPrice (@PathVariable double price){
        electricalBoatService.setPrice(price);
    }


}

