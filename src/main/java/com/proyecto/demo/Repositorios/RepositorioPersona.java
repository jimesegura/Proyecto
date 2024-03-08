package com.proyecto.demo.Repositorios;

import com.proyecto.demo.Entidades.Partidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.proyecto.demo.Entidades.Persona;

import java.util.List;

@Repository
public interface RepositorioPersona extends JpaRepository<Persona, Long> {
    @Query(value = "select * from usuarios u where u.Edad >=:edad",nativeQuery = true)
    public List<Persona> buscarPorEdad(@Param("edad") int edad);

    @Query(value="SELECT * FROM usuarios u WHERE u.Nombre = :nombre", nativeQuery=true)
    public List<Persona> buscarPorNombre(@Param("nombre") String nombre);



}
