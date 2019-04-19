package com.capgemini.molveno.BoatRental.API;

import com.capgemini.molveno.BoatRental.Controller.RowingBoatService;
import com.capgemini.molveno.BoatRental.Model.RowingBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/rowingboat")
public class RowingBoatEndpoint {
    @Autowired
    private RowingBoatService rowingBoatService;

    @GetMapping("/all-boat")
    public List<RowingBoat> getAllBoat(){ return rowingBoatService.getAllBoatR(); }

    @PostMapping("/add-one-boat")
    public RowingBoat saveBoat(@RequestBody @Valid @NotNull RowingBoat newBoat){
        return rowingBoatService.saveBoatR(newBoat);
    }

    @GetMapping("/get-one-boat")
    public RowingBoat getSingleBoat(@RequestParam Long id){
        return rowingBoatService.getSingleBoatR(id);
    }

    @DeleteMapping("/delete-one-boat")
    public void deleteBoat(@RequestParam Long id){
        rowingBoatService.deleteBoatR(id);
    }

    @PostMapping("/edit-boat")
    public RowingBoat editBoat(@RequestBody @Valid @NotNull RowingBoat editBoat){
        return rowingBoatService.saveBoatR(editBoat);}
}
