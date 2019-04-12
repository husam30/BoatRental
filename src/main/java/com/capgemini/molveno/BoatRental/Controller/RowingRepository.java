package com.capgemini.molveno.BoatRental.Controller;

import com.capgemini.molveno.BoatRental.Model.RowingBoat;
import org.springframework.data.repository.CrudRepository;

public interface RowingRepository extends CrudRepository<RowingBoat,Long> {
    Iterable <RowingBoat> findAll();
    RowingBoat findById(long id);
}
