package com.hackathon.tzdeka.repositorio;

import com.hackathon.tzdeka.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUsuario extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
    Usuario findByEmail(String email);
}
