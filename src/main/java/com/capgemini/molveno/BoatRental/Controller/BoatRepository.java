package com.capgemini.molveno.BoatRental.Controller;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.molveno.BoatRental.Model.Boat;

import java.util.List;

public interface BoatRepository extends CrudRepository<Boat,Long>{
    Iterable <Boat> findAll();
    Boat findById(long id);
}

