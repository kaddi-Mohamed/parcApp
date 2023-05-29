package com.ensa.demo.Repository;

import com.ensa.demo.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long> {

    @Query("SELECT c FROM Conductor c WHERE c.id NOT IN "
            + "(SELECT DISTINCT v.conductor.id FROM Voyage v WHERE v.dateD >= :startDate AND v.dateF <= :endDate)")
    List<Conductor> findAvailableConductors(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate);




}
