package com.hackathon.tzdeka.controlador;

import com.hackathon.tzdeka.dominio.dto.CampaniaDTO;
import com.hackathon.tzdeka.servicio.ServicioCampania;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class CampaniaControlador {
  @Autowired
  private ServicioCampania servicioCampania;

  @PostMapping("/campaña")
  public RedirectView crearCampania(
          @RequestParam String nombre,
          @RequestParam String descripcion
  ) {
    CampaniaDTO campaniaDTO = new CampaniaDTO(nombre, descripcion);
    return servicioCampania.crearCampania(campaniaDTO);
  }

}
