package com.capgemini.molveno.BoatRental.Controller;

import com.capgemini.molveno.BoatRental.Model.Boat;
import com.capgemini.molveno.BoatRental.Model.ElectricalBoat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BoatRepository extends CrudRepository<Boat,Long> {
    List<Boat> findAll();
    Boat findById(long id);
}
