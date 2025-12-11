package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.Model.Clase;
import com.rollerspeed.rollerspeed.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    private ClaseService claseService;

    // LISTAR CLASES ASIGNADAS A UN INSTRUCTOR
    @GetMapping("/clases/{instructorId}")
    public List<Clase> listarClasesInstructor(@PathVariable Long instructorId) {
        return claseService.listarClasesPorInstructor(instructorId);
    }

    // ASIGNAR UNA CLASE A UN INSTRUCTOR
    @PutMapping("/asignar/{claseId}/{instructorId}")
    public Clase asignarInstructor(
            @PathVariable Long claseId,
            @PathVariable Long instructorId) {

        return claseService.asignarInstructor(claseId, instructorId);
    }
}