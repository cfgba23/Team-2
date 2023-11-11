package com.hackathon.tzdeka.servicio;

import com.hackathon.tzdeka.dominio.Campania;
import com.hackathon.tzdeka.dominio.dto.CampaniaDTO;
import com.hackathon.tzdeka.repositorio.RepoCampania;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;


@Service
public class ServicioCampania {
  @Autowired
  private RepoCampania repoCampania;

  @Value("${backendUrl}")
  private String url;

  public RedirectView crearCampania(CampaniaDTO campaniaDTO) {
      try {
          Campania campania = new Campania();
          ModelMapper modelMapper = new ModelMapper();
          modelMapper.map(campaniaDTO, campania);
          Campania campania1 = repoCampania.save(campania);
          campania.setLink(url + "/campaña/" + campania1.getId());
          repoCampania.save(campania);
          return new RedirectView("/estadisticas/" + campania1.getId(), true);
      } catch (Exception e) {
          return new RedirectView("/crear?error=" + e.getMessage(), true);
      }
  }
}
