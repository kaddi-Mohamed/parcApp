package com.ensa.demo.service;

import com.ensa.demo.Repository.VehiculeRepository;
import com.ensa.demo.exception.ElementNotFoundException;
import com.ensa.demo.model.Conductor;
import com.ensa.demo.model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehiculeServiceImp implements VehiculeService{
    @Autowired
    VehiculeRepository vehiculeRepository ;
    @Override
    public Vehicule add(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule) ;
    }

    @Override
    public Vehicule getById(Long id) {
        Optional<Vehicule> vehicule =  vehiculeRepository.findById(id) ;
        if(vehicule.isEmpty()) throw new ElementNotFoundException() ;
        return vehicule.get();

    }

    @Override
    public Vehicule updateVehicule(Long id, Vehicule newVehicule) {
            Optional<Vehicule> OptionalVehicule = vehiculeRepository.findById(id);
            if (OptionalVehicule.isEmpty()) throw new ElementNotFoundException();
            Vehicule  vehicule  = OptionalVehicule.get() ;
            vehicule.setMatricule(newVehicule.getMatricule());
            vehicule.setMarque(newVehicule.getMarque());
            vehicule.setModel(newVehicule.getModel());
            vehicule.setPermisRequis(newVehicule.getPermisRequis());
            vehicule.setVoyages(newVehicule.getVoyages());
            return vehiculeRepository.save(vehicule);
    }

    @Override
    public void delete(Long id) {
        Optional<Vehicule> vehicule = vehiculeRepository.findById(id);
        if (vehicule.isEmpty()) throw new ElementNotFoundException();
        vehiculeRepository.deleteById(id);
    }


}
