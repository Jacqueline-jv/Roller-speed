package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.Model.Clase;
import com.rollerspeed.rollerspeed.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    // Crear
    @PostMapping
    public Clase crearClase(@RequestBody Clase clase) {
        return claseService.crearClase(clase);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Clase actualizarClase(@PathVariable Long id, @RequestBody Clase clase) {
        return claseService.actualizarClase(id, clase);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarClase(@PathVariable Long id) {
        claseService.eliminarClase(id);
    }

    // Listar todas
    @GetMapping
    public List<Clase> listarClases() {
        return claseService.listarClases();
    }

    // Obtener por id
    @GetMapping("/{id}")
    public Clase obtenerClasePorId(@PathVariable Long id) {
        return claseService.obtenerClasePorId(id);
    }

    // Asignar instructor (retorna la clase actualizada)
    @PutMapping("/{id}/asignar-instructor/{instructorId}")
    public Clase asignarInstructor(@PathVariable Long id, @PathVariable Long instructorId) {
        return claseService.asignarInstructor(id, instructorId);
    }

    // Listar por instructor
    @GetMapping("/instructor/{instructorId}")
    public List<Clase> listarClasesInstructor(@PathVariable Long instructorId) {
        return claseService.listarClasesPorInstructor(instructorId);
    }
}