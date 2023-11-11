package com.hackathon.tzdeka.dominio.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;
}
