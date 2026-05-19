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

import com.example.gimnasio.models.Clase;
import com.example.gimnasio.services.GimnasioService;

@RestController
@RequestMapping("/api/clases")
public class ClaseApiController {

    @Autowired
    private GimnasioService gimnasioService;

    @GetMapping
    public List<Clase> listar() {
        return gimnasioService.listarClases();
    }

    @GetMapping("/{id}")
    public Clase obtener(@PathVariable Long id) {
        return gimnasioService.obtenerClase(id).orElse(null);
    }

    @PostMapping
    public Clase crear(@RequestBody Clase clase) {
        return gimnasioService.guardarClase(clase);
    }

    @PutMapping("/{id}")
    public Clase actualizar(@PathVariable Long id, @RequestBody Clase clase) {
        return gimnasioService.guardarClase(clase);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        gimnasioService.eliminarClase(id);
    }
}