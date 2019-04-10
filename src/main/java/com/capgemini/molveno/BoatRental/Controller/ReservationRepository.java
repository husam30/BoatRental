package com.capgemini.molveno.BoatRental.Controller;

import com.capgemini.molveno.BoatRental.Model.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    Iterable<Reservation> findAll();
    Reservation findById(long id);
}
