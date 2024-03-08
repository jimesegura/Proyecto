package com.proyecto.demo.servicios;

import com.proyecto.demo.Entidades.Partidos;
import com.proyecto.demo.Repositorios.RepositorioPartidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.demo.Entidades.Persona;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import com.proyecto.demo.Repositorios.RepositorioPersona;
@Service
public class claseServicio {

    @Autowired
    private RepositorioPersona repoPersona;
    @Autowired
    private RepositorioPartidos repoPartido;

    public int suma(int num1, int num2){
        return num1+num2;
    }
    public Persona actualizarPersona(@RequestBody Persona persona, @PathVariable Long id){
        Optional<Persona> p= repoPersona.findById(id);
        Persona personaCambio = null;
        if(p.isPresent()){
            personaCambio = p.get();
            personaCambio.setNombre(persona.getNombre());
            personaCambio.setApellido(persona.getApellido());
            personaCambio.setEmail(persona.getEmail());
            personaCambio.setEdad(persona.getEdad());
        }
        return repoPersona.save(personaCambio);
    }

    public Partidos actualizarPartido(@RequestBody Partidos partido, @PathVariable Integer id){
        Optional<Partidos> p= repoPartido.findById(id);
        Partidos partidoCambio = null;
        if(p.isPresent()){
            partidoCambio = p.get();
            partidoCambio.setEquipoLocal(partido.getEquipoLocal());
            partidoCambio.setEquipoVisitante(partido.getEquipoVisitante());
            partidoCambio.setFechaPartido(partido.getFechaPartido());
            partidoCambio.setEstadio(partido.getEstadio());
        }
        return repoPartido.save(partidoCambio);
    }


}
