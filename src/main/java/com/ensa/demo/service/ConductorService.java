package com.ensa.demo.service;

import com.ensa.demo.model.Conductor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ConductorService {
         List<Conductor> getAll();

         Conductor getById(Long id);

         Conductor add(Conductor conductor) ;
         void  delete(Long id) ;
         Conductor updateConductor(Long id , Conductor newConductor) ;
}
