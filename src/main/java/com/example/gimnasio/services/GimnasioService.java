package com.example.gimnasio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gimnasio.models.Clase;
import com.example.gimnasio.models.Entrenador;
import com.example.gimnasio.repositories.ClaseRepository;
import com.example.gimnasio.repositories.EntrenadorRepository;

@Service
public class GimnasioService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private ClaseRepository claseRepository;

    // ===== ENTRENADORES =====

    public List<Entrenador> listarEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> obtenerEntrenador(Long id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador guardarEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public void eliminarEntrenador(Long id) {
        entrenadorRepository.deleteById(id);
    }

    // ===== CLASES =====

    public List<Clase> listarClases() {
        return claseRepository.findAll();
    }

    public Optional<Clase> obtenerClase(Long id) {
        return claseRepository.findById(id);
    }

    public Clase guardarClase(Clase clase) {
        return claseRepository.save(clase);
    }

    public void eliminarClase(Long id) {
        claseRepository.deleteById(id);
    }

    public List<Clase> buscarPorDia(String diaSemana) {
        return claseRepository.findByDiaSemana(diaSemana);
    }

    public List<Clase> buscarPorNivel(String nivel) {
        return claseRepository.findByNivel(nivel);
    }
}
