package com.ensa.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String matricule ;
    @Enumerated(EnumType.STRING)
    private Permis permisRequis ;
    private String marque ;
    private String model ;
    @JsonIgnore
    @OneToMany(mappedBy ="vehicule"  , cascade=CascadeType.ALL)
    private List<Voyage> voyages ;


}
