package com.hackathon.tzdeka.dominio.dto;


import lombok.Data;

import java.util.List;

@Data
public class CampaniaDTO {
  private Long id;
  private String nombre;
  private String descripcion;

  private List<String> fotos;
  private String link;
}
