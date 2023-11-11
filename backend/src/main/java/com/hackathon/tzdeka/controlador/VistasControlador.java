package com.hackathon.tzdeka.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VistasControlador {
    @GetMapping("/login")
    public String login(Model model) {
        return "auth";
    }

    @GetMapping("/campaña")
    public String campaña(Model model) {
        return "campania";
    }

    @GetMapping("/estadisticas/{id}")
    public String estadisticas(@PathVariable("id") Long id, Model model) {
        return "campania";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        return "crear";
    }
}

