package com.hackathon.tzdeka.servicio;

import com.hackathon.tzdeka.dominio.GeneradorDeCodigo;
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

  public RedirectView registrarse(RegisterDTO registerDTO) {
    try {
      if (repoUsuario.existsByEmail(registerDTO.getEmail())) {
        return new RedirectView("/login?error=ya existe el email", true);
      }

      Usuario usuario = new Usuario();
      usuario.setNombre(registerDTO.getNombre());
      usuario.setApellido(registerDTO.getApellido());
      usuario.setEmail(registerDTO.getEmail());
      usuario.setContrasenia(registerDTO.getContrasenia());
      usuario.setCodigoReferido(GeneradorDeCodigo.generar());

      if (registerDTO.getCodigoReferido() != null) {
          repoUsuario.findByCodigoReferido(registerDTO.getCodigoReferido()).ifPresent(usuarioReferidor -> usuarioReferidor.agregarReferido(usuario));
      }

      repoUsuario.save(usuario);

      return new RedirectView("/crear", true);

    } catch (Exception e) {
        return new RedirectView("/login?error=" + e.getMessage(), true);
    }
  }

  public RedirectView login(LoginDTO loginDTO) {
    try {
      if (!repoUsuario.existsByEmail(loginDTO.getEmail())) {
        return new RedirectView("/login?error=El email no existe", true);
      }

      Optional<Usuario> usuarioOptional = Optional.ofNullable(repoUsuario.findByEmail(loginDTO.getEmail()));
      Usuario usuario = usuarioOptional.orElse(null);

      if (usuario == null || !usuario.getContrasenia().equals(loginDTO.getContrasenia())) {
        return new RedirectView("/login?error=La contraseña es incorrecta", true);
      }

      return new RedirectView("/crear", true);

    } catch (Exception e) {
      return new RedirectView("/login?error=" + e.getMessage(), true);
    }
  }
}
