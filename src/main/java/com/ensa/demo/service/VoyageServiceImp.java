package com.ensa.demo.service;

import com.ensa.demo.Repository.ConductorRepository;
import com.ensa.demo.Repository.VehiculeRepository;
import com.ensa.demo.Repository.VoyageRepository;
import com.ensa.demo.dto.VoyageDTO;
import com.ensa.demo.exception.ElementNotFoundException;
import com.ensa.demo.exception.NotComfermityException;
import com.ensa.demo.model.Conductor;
import com.ensa.demo.model.Vehicule;
import com.ensa.demo.model.Voyage;
import jakarta.persistence.SecondaryTable;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Transactional
@Service
public class VoyageServiceImp implements VoyageService{
    @Autowired
    VoyageRepository voyageRepository ;
   @Autowired
    ConductorService conductorService ;
   @Autowired
    VehiculeService vehiculeService ;
    public List<Voyage> getAll() {
        List<Voyage> voyages = voyageRepository.findAll();
        return voyages ;
    }

    @Override
    public Voyage add(VoyageDTO voyageDTO) {
        Conductor conductor = conductorService.getById(voyageDTO.getConductorId()) ;
        Vehicule vehicule =  vehiculeService.getById(voyageDTO.getVehiculeId())  ;
        Voyage voyage = Voyage.builder()
                .dateF(voyageDTO.getDateF())
                .dateD(voyageDTO.getDateD())
                .conductor(conductor)
                .vehicule(vehicule)
                .build() ;
        return voyageRepository.save(voyage);
    }
}
