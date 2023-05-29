package com.ensa.demo.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoyageDTO {
    private Long id;
    private LocalDate dateD;
    private LocalDate dateF;
    private Long vehiculeId;
    private Long conductorId;
}
