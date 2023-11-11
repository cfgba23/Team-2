package com.hackathon.tzdeka.dominio;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.TituloEleitoral;

import java.util.List;

@Entity
@Data
public class Campania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(columnDefinition = "TEXT", length = 100000)
    private String descripcion;

    @ElementCollection
    private List<String> fotos;
    private String link;
}
