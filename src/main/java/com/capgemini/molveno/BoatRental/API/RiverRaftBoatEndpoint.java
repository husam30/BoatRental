package com.capgemini.molveno.BoatRental.API;

import com.capgemini.molveno.BoatRental.Controller.RiverRaftBoatService;
import com.capgemini.molveno.BoatRental.Model.RiverRaftBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/riverraftboat")
@CrossOrigin(origins = "*")
public class RiverRaftBoatEndpoint {
    @Autowired
    private RiverRaftBoatService riverRaftBoatService;

    @GetMapping("/all-boat")
    public List<RiverRaftBoat> getAllBoat(){ return riverRaftBoatService.getAllBoatRr(); }

    @PostMapping("/add-one-boat")
    public RiverRaftBoat saveBoat(@RequestBody @Valid @NotNull RiverRaftBoat newBoat){
        return riverRaftBoatService.saveBoatRr(newBoat);
    }

    @GetMapping("/get-one-boat")
    public RiverRaftBoat getSingleBoat(@RequestParam Long id){
        return riverRaftBoatService.getSingleBoatRr(id);
    }

    @DeleteMapping("/delete-one-boat/{id}")
    public void deleteBoat(@PathVariable Long id){
        riverRaftBoatService.deleteBoatRr(id);
    }

    @PostMapping("/edit-boat")
    public RiverRaftBoat editBoat(@RequestBody @Valid @NotNull RiverRaftBoat editBoat){
        return riverRaftBoatService.saveBoatRr(editBoat);}

    @GetMapping("/set-price/{price}")
    public void setPrice (@PathVariable double price){
        riverRaftBoatService.setPrice(price);
    }
}
