package com.hackathon.tzdeka.controlador;

import com.hackathon.tzdeka.dominio.dto.CampaniaDTO;
import com.hackathon.tzdeka.servicio.ServicioCampania;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CampaniaControlador {
  @Autowired
  private ServicioCampania servicioCampania;

  @PostMapping("/")
  public ResponseEntity<?> crearCampania(@RequestBody CampaniaDTO campaniaDTO) {
    return servicioCampania.crearCampania(campaniaDTO);
  }

  @GetMapping("/")
  public String home(Model model) {
    return "sumate";
  }

  @GetMapping("/crear")
  public String crear(Model model) {
    return "crearCampania";
  }

}
