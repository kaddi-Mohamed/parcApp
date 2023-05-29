package com.ensa.demo.Repository;

import com.ensa.demo.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule , Long> {
        @Query("SELECT v FROM Vehicule v WHERE v.id NOT IN "
                + "(SELECT DISTINCT v.vehicule.id FROM Voyage v WHERE v.dateD >= :startDate AND v.dateF <= :endDate)")
        List<Vehicule> findAvailableVehicles(LocalDate startDate, LocalDate endDate);
}
