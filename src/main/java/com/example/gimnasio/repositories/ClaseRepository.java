package com.example.gimnasio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gimnasio.models.Clase;

public interface ClaseRepository extends JpaRepository<Clase, Long> {

    List<Clase> findByDiaSemana(String diaSemana);

    List<Clase> findByNivel(String nivel);
}