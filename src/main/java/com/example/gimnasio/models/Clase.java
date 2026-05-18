package com.example.gimnasio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String diaSemana;
    private String horaInicio;
    private Integer duracionMin;
    private Integer plazasMax;
    private Integer plazasOcupadas;
    private String nivel;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    public Clase() {
    }

    public Clase(String nombre, String diaSemana, String horaInicio,
                 Integer duracionMin, Integer plazasMax,
                 Integer plazasOcupadas, String nivel) {
        this.nombre = nombre;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.duracionMin = duracionMin;
        this.plazasMax = plazasMax;
        this.plazasOcupadas = plazasOcupadas;
        this.nivel = nivel;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(Integer duracionMin) {
        this.duracionMin = duracionMin;
    }

    public Integer getPlazasMax() {
        return plazasMax;
    }

    public void setPlazasMax(Integer plazasMax) {
        this.plazasMax = plazasMax;
    }

    public Integer getPlazasOcupadas() {
        return plazasOcupadas;
    }

    public void setPlazasOcupadas(Integer plazasOcupadas) {
        this.plazasOcupadas = plazasOcupadas;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public int getPlazasDisponibles() {
        return plazasMax - plazasOcupadas;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
