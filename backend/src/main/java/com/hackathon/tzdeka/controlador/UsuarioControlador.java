package com.hackathon.tzdeka.controlador;

import com.hackathon.tzdeka.dominio.dto.LoginDTO;
import com.hackathon.tzdeka.dominio.dto.RegisterDTO;
import com.hackathon.tzdeka.servicio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UsuarioControlador {

    @Autowired
    private ServicioUsuario servicioUsuario;

    @PostMapping("/register")
    public ResponseEntity<?> crearUsuario(@RequestBody RegisterDTO registerDTO) {
        return servicioUsuario.registrarse(registerDTO);

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        return servicioUsuario.login(loginDTO);
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "auth";
    }


}
