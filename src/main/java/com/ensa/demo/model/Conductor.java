package com.ensa.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name ;
    private String matricule ;
    @Enumerated(EnumType.STRING)
    private Permis permis ;
    @JsonIgnore
    @OneToMany(mappedBy = "conductor" , cascade=CascadeType.ALL)
    private Set<Voyage> voyageSet;

}
