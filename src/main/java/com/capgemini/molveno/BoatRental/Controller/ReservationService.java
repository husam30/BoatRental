package com.capgemini.molveno.BoatRental.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class ReservationService {
    @Autowired
    private RowingRepository rowingRepository;
}
