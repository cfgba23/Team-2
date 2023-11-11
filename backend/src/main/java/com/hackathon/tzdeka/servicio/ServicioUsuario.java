package com.hackathon.tzdeka.servicio;

import com.hackathon.tzdeka.dominio.Usuario;
import com.hackathon.tzdeka.dominio.dto.LoginDTO;
import com.hackathon.tzdeka.dominio.dto.RegisterDTO;
import com.hackathon.tzdeka.repositorio.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

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

      RedirectView redirectView = new RedirectView("/", true);
      return ResponseEntity.ok(redirectView);

    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  public ResponseEntity<?> login(LoginDTO loginDTO) {
    try {
      if (!repoUsuario.existsByEmail(loginDTO.getEmail())) {
        return ResponseEntity.badRequest().body("El email no existe");
      }

      Optional<Usuario> usuarioOptional = Optional.ofNullable(repoUsuario.findByEmail(loginDTO.getEmail()));
      Usuario usuario = usuarioOptional.orElse(null);

      if (usuario == null || !usuario.getContrasenia().equals(loginDTO.getPassword())) {
        return ResponseEntity.badRequest().body("La contraseña es incorrecta");
      }

      RedirectView redirectView = new RedirectView("/", true);
      return ResponseEntity.ok(redirectView);

    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
