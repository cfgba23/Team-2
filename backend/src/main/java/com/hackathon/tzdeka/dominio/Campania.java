package com.hackathon.tzdeka.dominio;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.TituloEleitoral;

import java.util.List;

@Entity
public class Campania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @ElementCollection
    private List<String> fotos;
    private String link;
}
