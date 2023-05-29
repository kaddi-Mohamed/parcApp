package com.ensa.demo.auth;

import com.ensa.demo.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name ;
    private String email ;
    private String password ;
    @Enumerated(value = EnumType.STRING)
    private Role role  ;
}
