package com.proyecto.demo.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.proyecto.demo.Entidades.Partidos;

import java.util.List;

@Repository
public interface RepositorioPartidos extends JpaRepository<Partidos, Integer>{
    @Query(value="SELECT * FROM Partidos ORDER BY FechaPartido DESC LIMIT 5", nativeQuery = true)
    public List<Partidos> buscarUltPartidos();
}
