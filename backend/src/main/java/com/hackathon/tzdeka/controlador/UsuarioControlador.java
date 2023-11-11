package com.hackathon.tzdeka.controlador;

import com.hackathon.tzdeka.dominio.dto.LoginDTO;
import com.hackathon.tzdeka.dominio.dto.RegisterDTO;
import com.hackathon.tzdeka.servicio.ServicioUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UsuarioControlador {

    @Autowired
    private ServicioUsuario servicioUsuario;

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody RegisterDTO registerDTO) {
        return servicioUsuario.registrarse(registerDTO);
    }
}
