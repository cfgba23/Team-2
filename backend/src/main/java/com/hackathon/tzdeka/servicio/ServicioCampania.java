package com.hackathon.tzdeka.servicio;

import com.hackathon.tzdeka.dominio.Campania;
import com.hackathon.tzdeka.dominio.dto.CampaniaDTO;
import com.hackathon.tzdeka.repositorio.RepoCampania;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;


@Service
public class ServicioCampania {
  @Autowired
  private RepoCampania repoCampania;

  public ResponseEntity<?> crearCampania(CampaniaDTO campaniaDTO) {
    try{
        Campania campania = new Campania();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(campaniaDTO, campania);
        repoCampania.save(campania);

    }
    catch(Exception e){
      return ResponseEntity.badRequest().body("Error al crear la campaña");
    }
    RedirectView redirectView = new RedirectView("/estadisticas", true);
    return ResponseEntity.ok(redirectView);
  }
}
