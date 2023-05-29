package com.ensa.demo.controllers;

import com.ensa.demo.dto.VoyageDTO;
import com.ensa.demo.model.Voyage;
import com.ensa.demo.service.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voyage")
public class VoyageController {
    @Autowired
    VoyageService voyageService ;
    @PostMapping("/")
    public ResponseEntity<Voyage> addVoyage(@RequestBody VoyageDTO voyageDTO ) {

        return new ResponseEntity<>(voyageService.add(voyageDTO), HttpStatus.OK );
    }
    @GetMapping("/")
    public ResponseEntity<List<Voyage>> getAll(){
        return new ResponseEntity<>(voyageService.getAll() , HttpStatus.OK) ;
    }


}
