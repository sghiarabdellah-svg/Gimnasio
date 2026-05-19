package com.example.gimnasio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gimnasio.models.Clase;
import com.example.gimnasio.services.GimnasioService;

@Controller
@RequestMapping("/web/clases")
public class ClaseWebController {

    @Autowired
    private GimnasioService gimnasioService;

    @GetMapping
    public String listar(@RequestParam(required = false) String diaSemana,
                         @RequestParam(required = false) String nivel,
                         Model model) {

        if (diaSemana != null && !diaSemana.isBlank()) {
            model.addAttribute("clases", gimnasioService.buscarPorDia(diaSemana));
        } else if (nivel != null && !nivel.isBlank()) {
            model.addAttribute("clases", gimnasioService.buscarPorNivel(nivel));
        } else {
            model.addAttribute("clases", gimnasioService.listarClases());
        }

        return "clases/lista";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("clase", new Clase());
        model.addAttribute("entrenadores", gimnasioService.listarEntrenadores());
        return "clases/formulario";
    }

    @PostMapping("/nueva")
    public String guardar(@ModelAttribute Clase clase) {
        gimnasioService.guardarClase(clase);
        return "redirect:/web/clases";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("clase", gimnasioService.obtenerClase(id).orElse(new Clase()));
        model.addAttribute("entrenadores", gimnasioService.listarEntrenadores());
        return "clases/formulario";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Clase clase) {
        gimnasioService.guardarClase(clase);
        return "redirect:/web/clases";
    }

    @PostMapping("/borrar/{id}")
    public String borrar(@PathVariable Long id) {
        gimnasioService.eliminarClase(id);
        return "redirect:/web/clases";
    }
}