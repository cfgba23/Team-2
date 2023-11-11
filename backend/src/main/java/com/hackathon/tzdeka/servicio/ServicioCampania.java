package com.hackathon.tzdeka.servicio;

import com.hackathon.tzdeka.dominio.Campania;
import com.hackathon.tzdeka.dominio.dto.CampaniaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;


@Service
public class ServicioCampania {
  public ResponseEntity<?> crearCampania(CampaniaDTO campaniaDTO) {
    try{
      Campania campania = new Campania();
      campania.setNombre(campaniaDTO.getNombre());
      campania.setDescripcion(campaniaDTO.getDescripcion());
      campania.setFotos(campaniaDTO.getFotos());
      campania.setLink(campaniaDTO.getLink());
    }
    catch(Exception e){
      return ResponseEntity.badRequest().body("Error al crear la campaña");
    }
    RedirectView redirectView = new RedirectView("/estadisticas", true);
    return ResponseEntity.ok(redirectView);
  }
}
