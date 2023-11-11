package com.hackathon.tzdeka.dominio;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;
    private String codigoReferido;

    @OneToMany
    @JoinColumn(name = "referido_id")
    private List<Usuario> referidos;

    @OneToMany
    @JoinColumn(name = "campania_id")
    private List<Campania> campanias;

    public Usuario() {
        this.referidos = new ArrayList<>();
        this.campanias = new ArrayList<>();
    }

    public void agregarReferido(Usuario usuario) {
        referidos.add(usuario);
    }
}
