package com.ensa.demo.service;

import com.ensa.demo.model.Vehicule;

public interface VehiculeService {
    Vehicule add(Vehicule vehicule) ;
    Vehicule getById(Long id) ;
    Vehicule updateVehicule(Long id, Vehicule newVehicule);
    void delete(Long id) ;
}
