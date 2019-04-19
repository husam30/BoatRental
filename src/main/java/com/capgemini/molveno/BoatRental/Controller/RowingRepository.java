package com.capgemini.molveno.BoatRental.Controller;

import com.capgemini.molveno.BoatRental.Model.RowingBoat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RowingRepository extends CrudRepository<RowingBoat,Long> {
    List<RowingBoat> findAll();
    RowingBoat findById(long id);
}
