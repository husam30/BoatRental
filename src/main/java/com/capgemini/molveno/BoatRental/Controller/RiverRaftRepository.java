package com.capgemini.molveno.BoatRental.Controller;

import com.capgemini.molveno.BoatRental.Model.RiverRaftBoat;
import org.springframework.data.repository.CrudRepository;

public interface RiverRaftRepository extends CrudRepository<RiverRaftBoat,Long> {
    Iterable <RiverRaftBoat> findAll();
    RiverRaftBoat findById(long id);
}
