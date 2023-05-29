package com.ensa.demo.controllers;
import com.ensa.demo.model.Conductor;
import com.ensa.demo.model.Vehicule;
import com.ensa.demo.service.AvailabilityService;
import com.ensa.demo.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/vehicule")
public class VehiculeController {
 @Autowired
 AvailabilityService availabilityService;
 @Autowired
    VehiculeService vehiculeService ;
    @GetMapping("/available")
    public ResponseEntity<List<Vehicule>> getAvailableVehicule(@RequestParam("start") LocalDate startDate, @RequestParam("end") LocalDate endDate) {
        return new ResponseEntity<>(availabilityService.getAvailableVehicule(startDate , endDate) , HttpStatus.OK)  ;
    }
    @PostMapping("/")
    public ResponseEntity<Vehicule> saveVehicule(@RequestBody Vehicule vehicule){
        return new ResponseEntity<>(vehiculeService.add(vehicule), HttpStatus.OK) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable Long id ){
        return new ResponseEntity<>(vehiculeService.getById(id) , HttpStatus.OK) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable Long id, @RequestBody Vehicule newVehicule) {
        Vehicule vehicule = vehiculeService.updateVehicule(id, newVehicule);
        return new ResponseEntity<>(vehicule , HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  delete(@PathVariable Long id){
        vehiculeService.delete(id);
        return  new ResponseEntity<>("vehicule deleted successfully",HttpStatus.OK);
    }


}
