package com.hackathon.tzdeka.controlador;

import com.hackathon.tzdeka.dominio.dto.LoginDTO;
import com.hackathon.tzdeka.dominio.dto.RegisterDTO;
import com.hackathon.tzdeka.servicio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class UsuarioControlador {

    @Autowired
    private ServicioUsuario servicioUsuario;

    @PostMapping("/register")
    public RedirectView registrarse(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String email,
            @RequestParam String contrasenia,
            @RequestParam(required = false) String codigoReferido
    ) {

        RegisterDTO registerDTO = new RegisterDTO(nombre, apellido, email, contrasenia);
        registerDTO.setCodigoReferido(codigoReferido);
        return servicioUsuario.registrarse(registerDTO);
    }


    @PostMapping("/login")
    public RedirectView login(@RequestParam String email, @RequestParam String contrasenia) {
        LoginDTO loginDTO = new LoginDTO(email, contrasenia);
        return servicioUsuario.login(loginDTO);
    }


}
