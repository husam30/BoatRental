package com.capgemini.molveno.BoatRental.Controller;

import com.capgemini.molveno.BoatRental.Model.ElectricalBoat;
import org.springframework.data.repository.CrudRepository;

public interface ElectricalRepository extends CrudRepository<ElectricalBoat,Long> {
    Iterable <ElectricalBoat> findAll();
    ElectricalBoat findById(long id);
}
