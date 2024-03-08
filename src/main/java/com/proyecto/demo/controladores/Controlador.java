package com.proyecto.demo.controladores;
import com.proyecto.demo.Entidades.Entradas;
import com.proyecto.demo.Entidades.Partidos;
import com.proyecto.demo.Entidades.Persona;
import com.proyecto.demo.Repositorios.Entradasrepositorio;
import com.proyecto.demo.Repositorios.RepositorioPartidos;
import com.proyecto.demo.Repositorios.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proyecto.demo.servicios.claseServicio;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    private claseServicio servicio;
    @Autowired
    private RepositorioPersona repoPersona;
    @Autowired
    private RepositorioPartidos repoPartidos;
    @Autowired
    private Entradasrepositorio entradasRepo;

    @GetMapping("/hola")
    public String Hola() {
        return "Hola";
    }

    @GetMapping("/sumar/{num1}/{num2}")
    public int calcular(@PathVariable int num1, @PathVariable int num2){
        return servicio.suma(num1,num2);
       //return suma(num1, num2);
    }

    //PERSONAS
    @GetMapping("/traerTodos")
    public List<Persona> devolverTabla(){
        return repoPersona.findAll();
    }

    @PostMapping("/agregar")
    public Persona agregarPersona(@RequestBody Persona persona){
        return repoPersona.save(persona);
    }

    @PatchMapping("/actualizar/{id}")
    public Persona actualizarPersona(@RequestBody Persona persona, @PathVariable Long id){

        return servicio.actualizarPersona(persona,id);
    }

    @GetMapping("/buscarEdad/{edad}")
    public List<Persona> mayores18(@PathVariable int edad){
        return repoPersona.buscarPorEdad(edad);
    }

    @GetMapping("/buscarNombre/{nombre}")
    public  List<Persona> buscarNombre(@PathVariable String nombre){
        return repoPersona.buscarPorNombre(nombre);
    }



    //PARTIDOS
    @GetMapping("/traerPartidos")
    public List<Partidos> devolverPartidos(){
        return repoPartidos.findAll();
    }

    @PostMapping("/agregarPartido")
    public Partidos agregarPartido(@RequestBody Partidos partido){
        return repoPartidos.save(partido);
    }

    @PatchMapping("/actualizarPartido/{id}")
    public Partidos actualizarPersona(@RequestBody Partidos partido, @PathVariable Integer id){
        return servicio.actualizarPartido(partido,id);
    }

    @GetMapping("/buscarUltPartidos")
    public List<Partidos> buscarUltPartidos(){
        List<Partidos> p= repoPartidos.buscarUltPartidos();
        return p;
    }



    //ENTRADAS
    @GetMapping("/traerEntradas")
    public List<Entradas> traerEntradas(){
        return entradasRepo.findAll();
    }

    @GetMapping("/buscarPorPrecio/{precio}")
    public List<Entradas> buscarPorPrecio(@PathVariable double precio){
        return entradasRepo.buscarPorPrecio(precio);
    }

    @GetMapping("/buscarEntradasPorUsuario/{id}")
    public List<Entradas> buscarPorUsuario(@PathVariable Long id){
        List<Entradas> e=entradasRepo.buscarPorPersona(id);
        return e;
    }

}






