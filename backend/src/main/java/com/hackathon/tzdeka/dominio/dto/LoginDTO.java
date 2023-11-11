package com.hackathon.tzdeka.dominio.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
}
