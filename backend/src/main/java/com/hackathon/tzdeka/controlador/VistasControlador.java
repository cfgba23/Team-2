package com.hackathon.tzdeka.controlador;

import com.hackathon.tzdeka.dominio.Campania;
import com.hackathon.tzdeka.repositorio.RepoCampania;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VistasControlador {
    @Autowired
    private RepoCampania repoCampania;

    @GetMapping("/login")
    public String login(Model model) {
        return "auth";
    }

    @GetMapping("/")
    public String campania(Model model) {
        return "campania";
    }

    @GetMapping("/estadisticas/{id}")
    public String estadisticas(@PathVariable("id") Long id, Model model) {
        model.addAttribute("usuario", repoCampania.findById(id).get());
        return "estadisticas";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        return "crear";
    }

    @GetMapping("/todasLasEstadisticas")
    public String todasLasEstadisticas(Model model) {
        List<Campania> campanias = repoCampania.findAll();
        model.addAttribute("campanias", campanias);
        return "todasLasEstadisticas";
    }

    @GetMapping("/campaña/{id}")
    public String campania(@PathVariable("id") Long id, Model model) {
        model.addAttribute("link", repoCampania.findById(id).get().getLink());
        return "compartir";
    }
}

