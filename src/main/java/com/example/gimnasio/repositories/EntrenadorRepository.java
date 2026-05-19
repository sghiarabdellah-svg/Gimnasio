package com.example.gimnasio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gimnasio.models.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
}