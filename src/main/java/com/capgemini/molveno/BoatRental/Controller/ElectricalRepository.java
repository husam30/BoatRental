package com.capgemini.molveno.BoatRental.Controller;

import com.capgemini.molveno.BoatRental.Model.ElectricalBoat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElectricalRepository extends CrudRepository<ElectricalBoat,Long> {
    List<ElectricalBoat> findAll();
    ElectricalBoat findById(long id);
}
