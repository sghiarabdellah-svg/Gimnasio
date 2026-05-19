package com.example.gimnasio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.gimnasio.models.Entrenador;
import com.example.gimnasio.services.GimnasioService;

@Controller
@RequestMapping("/web/entrenadores")
public class EntrenadorWebController {

    @Autowired
    private GimnasioService gimnasioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("entrenadores", gimnasioService.listarEntrenadores());
        return "entrenadores/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        return "entrenadores/formulario";
    }

    @PostMapping("/nuevo")
    public String guardar(@ModelAttribute Entrenador entrenador) {
        gimnasioService.guardarEntrenador(entrenador);
        return "redirect:/web/entrenadores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("entrenador", gimnasioService.obtenerEntrenador(id).orElse(new Entrenador()));
        return "entrenadores/formulario";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Entrenador entrenador) {
        entrenador.setId(id);
        gimnasioService.guardarEntrenador(entrenador);
        return "redirect:/web/entrenadores";
    }

    @PostMapping("/borrar/{id}")
    public String borrar(@PathVariable Long id) {
        gimnasioService.eliminarEntrenador(id);
        return "redirect:/web/entrenadores";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Entrenador entrenador = gimnasioService.obtenerEntrenador(id).orElse(new Entrenador());
        model.addAttribute("entrenador", entrenador);
        return "entrenadores/detalle";
    }
}