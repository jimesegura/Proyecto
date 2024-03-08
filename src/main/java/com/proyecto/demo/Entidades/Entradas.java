package com.proyecto.demo.Entidades;

import jakarta.persistence.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Table(name="entradas")
public class Entradas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EntradaId")
    private Integer id;

    @Column(name="Asiento")
    private String asiento;

    @Column(name="Precio")
    private double precio;
    @ManyToOne //indicar que muchas entradas pertenecen a un partido.
    @JoinColumn(name="PartidoId", referencedColumnName = "Id") // especifica la columna en la tabla de Entrada que se utiliza como clave foránea para la relación.
    //@Column(name="PartidoId")
    private Partidos partidoId;

    @ManyToOne
    @JoinColumn(name="UsuarioId",referencedColumnName = "Id")
    //@Column(name="UsuarioId")
    private Persona usuarioId;

    public Entradas() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Partidos getPartidoId() {
        return partidoId;
    }

    public void setPartidoId(Partidos partidoId) {
        this.partidoId = partidoId;
    }

    public Persona getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Persona usuarioId) {
        this.usuarioId = usuarioId;
    }
}
