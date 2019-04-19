package com.capgemini.molveno.BoatRental.Controller;

import com.capgemini.molveno.BoatRental.Model.RiverRaftBoat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RiverRaftRepository extends CrudRepository<RiverRaftBoat,Long> {
    List<RiverRaftBoat> findAll();
    RiverRaftBoat findById(long id);
}
