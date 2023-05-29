package com.ensa.demo.service;

import com.ensa.demo.dto.VoyageDTO;
import com.ensa.demo.model.Voyage;

import java.util.List;

public interface VoyageService {
    public List<Voyage> getAll() ;
    public Voyage add(VoyageDTO voyageDTO) ;
}
