package com.capgemini.molveno.BoatRental.Controller;


import com.capgemini.molveno.BoatRental.Model.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class BoatService {
    @Autowired
    private  BoatRepository boatRepository;


    public Iterable<Boat> getAll() {
        return boatRepository.findAll();
    }



}
