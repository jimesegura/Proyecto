package com.proyecto.demo.Entidades;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="partidos")
public class Partidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Integer id;
    @Column(name="EquipoLocal")
    private String equipoLocal;
    @Column(name="EquipoVisitante")
    private String equipoVisitante;

    @Column(name="FechaPartido")
    private Date fechaPartido;

    @Column(name="Estadio")
    private String estadio;

    public Partidos(String equipoLocal, String equipoVisitante, Date fechaPartido, String estadio) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fechaPartido = fechaPartido;
        this.estadio = estadio;
    }

    public Partidos() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Date getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }
}
