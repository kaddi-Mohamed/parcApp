package com.ensa.demo.service;

import com.ensa.demo.Repository.ConductorRepository;
import com.ensa.demo.Repository.VehiculeRepository;
import com.ensa.demo.Repository.VoyageRepository;
import com.ensa.demo.exception.ElementNotFoundException;
import com.ensa.demo.exception.NotConductorAvaibleException;
import com.ensa.demo.exception.NotVehiculeAvaibleException;
import com.ensa.demo.model.Conductor;
import com.ensa.demo.model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AvailabilityServiceImp implements AvailabilityService {

    @Autowired
    VehiculeRepository vehiculeRepository ;
    @Autowired
    ConductorRepository conductorRepository ;
    @Autowired
    VoyageRepository voyageRepository ;
    @Override
    public List<Conductor> getAvailableConductor(LocalDate startDate, LocalDate endDate) {
        List<Conductor> availableConductor =  conductorRepository.findAvailableConductors(startDate , endDate) ;
        if(availableConductor.isEmpty()) throw new NotConductorAvaibleException() ;
        return availableConductor ;
    }

    @Override
    public List<Vehicule> getAvailableVehicule(LocalDate startDate, LocalDate endDate) {
        List<Vehicule> availableVehicule =  vehiculeRepository.findAvailableVehicles(startDate , endDate) ;
        if(availableVehicule.isEmpty()) throw new NotVehiculeAvaibleException() ;
        return availableVehicule  ;
    }

    @Override
    public List<Conductor> getAvailableDriversForVehicle(Long vehiculeId, LocalDate startDate, LocalDate endDate) {
        List <Conductor> conductors = conductorRepository.findAvailableConductors(startDate , endDate) ;
        if(conductors.isEmpty()) throw new NotConductorAvaibleException() ;
        Optional<Vehicule> vehicule = vehiculeRepository.findById(vehiculeId) ;
        if(vehicule.isEmpty()) throw new ElementNotFoundException() ;
        List <Conductor> availableConducoreForVehicule  = conductors
                .stream()
                .filter(conductor ->conductor.getPermis()==vehicule.get().getPermisRequis()).toList() ;
        return availableConducoreForVehicule ;
    }
}

