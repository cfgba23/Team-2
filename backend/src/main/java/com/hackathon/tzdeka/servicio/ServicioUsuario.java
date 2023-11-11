package com.hackathon.tzdeka.servicio;

import com.hackathon.tzdeka.dominio.Usuario;
import com.hackathon.tzdeka.dominio.dto.LoginDTO;
import com.hackathon.tzdeka.dominio.dto.RegisterDTO;
import com.hackathon.tzdeka.repositorio.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuario {

    @Autowired
    private RepoUsuario repoUsuario;

    public ResponseEntity<?> registrarse(RegisterDTO registerDTO) {
        try {
            if (repoUsuario.existsByEmail(registerDTO.getEmail())) {
                return ResponseEntity.badRequest().body("El email ya existe");
            }

            Usuario usuario = new Usuario();
            usuario.setNombre(registerDTO.getNombre());
            usuario.setApellido(registerDTO.getApellido());
            usuario.setEmail(registerDTO.getEmail());
            usuario.setContrasenia(registerDTO.getContrasenia());

            repoUsuario.save(usuario);

            return ResponseEntity.ok("Usuario creado con exito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
