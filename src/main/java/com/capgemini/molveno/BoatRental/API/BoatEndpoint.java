package com.capgemini.molveno.BoatRental.API;

import com.capgemini.molveno.BoatRental.Controller.BoatRepository;
import com.capgemini.molveno.BoatRental.Controller.BoatService;
import com.capgemini.molveno.BoatRental.Model.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/boat")
public class BoatEndpoint {
    @Autowired
    private BoatService boatService;

    @GetMapping("/allboat")
    public Iterable<Boat> getAllPlayers(){
        return boatService.getAll();
    }


    @PostMapping("/singleboat")
    public Boat savePlayer(@RequestBody @Valid @NotNull Boat newboat){
        return boatService.saveboat(newboat);
    }
}

