package com.ensa.demo.service;

import com.ensa.demo.model.Conductor;
import com.ensa.demo.model.Vehicule;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AvailabilityService {
    List<Conductor> getAvailableConductor(LocalDate startDate, LocalDate endDate);

    List<Vehicule> getAvailableVehicule(LocalDate startDate, LocalDate endDate);



    List<Conductor> getAvailableDriversForVehicle(Long vehiculeId ,LocalDate startDate  , LocalDate endDate) ;


}
