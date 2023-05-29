package com.ensa.demo.service;

import com.ensa.demo.Repository.ConductorRepository;
import com.ensa.demo.exception.ElementNotFoundException;
import com.ensa.demo.model.Conductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorServiceImp implements ConductorService {
    @Autowired
    ConductorRepository conductorRepository;

    public List<Conductor> getAll() {
        List<Conductor> conductors = conductorRepository.findAll();
        return conductors ;

    }

    @Override
    public Conductor getById(Long id) throws ElementNotFoundException {
        Optional<Conductor> conductor = conductorRepository.findById(id);
        if (conductor.isEmpty())
            throw new ElementNotFoundException();

        return conductor.get();
    }

    @Override
    public Conductor add(Conductor conductor) {
        Conductor savedConductor = conductorRepository.save(conductor);
        return savedConductor ;
    }

    @Override
    public void delete(Long id) {
        Optional<Conductor> conductor = conductorRepository.findById(id);
        if (conductor.isEmpty()) throw new ElementNotFoundException();
        conductorRepository.deleteById(id);
    }

    public Conductor updateConductor(Long id , Conductor newConductor) {
        Optional<Conductor> OptionalConductor = conductorRepository.findById(id);
        if (OptionalConductor.isEmpty()) throw new ElementNotFoundException();
        Conductor conductor = OptionalConductor.get() ;
        conductor.setName(newConductor.getName());
        conductor.setPermis(newConductor.getPermis());
        conductor.setMatricule(newConductor.getMatricule());
        return conductorRepository.save(conductor);
    }
}

