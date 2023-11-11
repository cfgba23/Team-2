package com.hackathon.tzdeka.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class RegisterDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;
    private String codigoReferido;

    public RegisterDTO(String nombre, String apellido, String email, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
    }

}
