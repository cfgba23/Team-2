package com.hackathon.tzdeka.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDTO {
    private String email;
    private String contrasenia;
}
