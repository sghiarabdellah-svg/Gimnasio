package com.example.gimnasio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gimnasio.models.Entrenador;
import com.example.gimnasio.services.GimnasioService;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorApiController {

    @Autowired
    private GimnasioService gimnasioService;

    @GetMapping
    public List<Entrenador> listar() {
        return gimnasioService.listarEntrenadores();
    }

    @GetMapping("/{id}")
    public Entrenador obtener(@PathVariable Long id) {
        return gimnasioService.obtenerEntrenador(id).orElse(null);
    }

    @PostMapping
    public Entrenador crear(@RequestBody Entrenador entrenador) {
        return gimnasioService.guardarEntrenador(entrenador);
    }

    @PutMapping("/{id}")
    public Entrenador actualizar(@PathVariable Long id,
                                 @RequestBody Entrenador entrenador) {
        entrenador.setId(id);
        return gimnasioService.guardarEntrenador(entrenador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        gimnasioService.eliminarEntrenador(id);
    }
}