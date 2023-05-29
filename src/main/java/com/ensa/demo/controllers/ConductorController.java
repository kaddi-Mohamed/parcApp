package com.ensa.demo.controllers;
import com.ensa.demo.model.Conductor;
import com.ensa.demo.service.AvailabilityService;
import com.ensa.demo.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/conductors")
public class ConductorController {
 @Autowired
 ConductorService conductorService ;
 @Autowired
 AvailabilityService availabilityService;
    @GetMapping("/")
    public ResponseEntity<List<Conductor>> getAll(){
         return  new ResponseEntity<>(conductorService.getAll() , HttpStatus.OK
         ) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Conductor> getById(@PathVariable Long id){
       return new ResponseEntity<>(conductorService.getById(id) , HttpStatus.OK) ;
    }
   @PostMapping("/add")
    public ResponseEntity<Conductor> save(@RequestBody  Conductor conductor) {
         return new ResponseEntity<>(conductorService.add(conductor) , HttpStatus.OK) ;
   }

    @PutMapping("/{id}")
    public ResponseEntity<Conductor> updateConductor(@PathVariable Long id, @RequestBody Conductor newConductor) {
        Conductor conductor = conductorService.updateConductor(id, newConductor);
        return new ResponseEntity<>(conductor , HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  delete(@PathVariable Long id){
        conductorService.delete(id);
        return  new ResponseEntity<>("conductore deleted successfully",HttpStatus.OK);
    }


    //manadeger
    @GetMapping("/available")
    public ResponseEntity<List<Conductor>> getAvailableConductor(@RequestParam("start") LocalDate startDate, @RequestParam("end") LocalDate endDate ) {
        return new ResponseEntity<>(availabilityService.getAvailableConductor( startDate ,endDate) , HttpStatus.OK) ;
    }
    @GetMapping("/availableForVehicule")
    public ResponseEntity<List<Conductor>> getAvailableForVehicule(@RequestParam("vehiculeId") Long vehiculeId ,
                                                                   @RequestParam("startDate") LocalDate startDate ,
                                                                   @RequestParam("endDate") LocalDate endDate) {
        return new ResponseEntity<>(availabilityService.getAvailableDriversForVehicle(vehiculeId , startDate , endDate) , HttpStatus.OK) ;
    }


}
