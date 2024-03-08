package com.proyecto.demo.Repositorios;

import com.proyecto.demo.Entidades.Entradas;
import com.proyecto.demo.Entidades.Persona;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Entradasrepositorio extends JpaRepository<Entradas, Integer> {

    @Query(value = "Select * from Entradas e where e.Precio >=:precio", nativeQuery = true)
    public List<Entradas> buscarPorPrecio(@Param("precio") double precio);

    @Query(value = "SELECT * FROM Entradas e INNER JOIN Usuarios u ON e.UsuarioId = u.Id WHERE u.Id = :id", nativeQuery = true)
    public List<Entradas> buscarPorPersona(@Param("id") Long id);
}
