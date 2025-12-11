package com.rollerspeed.rollerspeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;

@Controller
@RequestMapping("/admin/asignaciones")
public class AsignacionController {

    @GetMapping
    public String listaAsignaciones(Model model) {
        model.addAttribute("asignaciones", "Datos simulados por ahora");
        return "lista-asignaciones";
    }

    @GetMapping("/nueva")
    public String nuevaAsignacion(Model model) {
        model.addAttribute("clases", "Clases simuladas");
        model.addAttribute("instructores", "Instructores simulados");
        model.addAttribute("fechaHoy", LocalDate.now().toString());
        model.addAttribute("titulo", "Asignar Instructor");
        model.addAttribute("tituloFormulario", "Asignar Instructor a Clase");
        return "asignar-instructor";
    }

    @PostMapping("/admin/procesar-asignacion")
    public String procesarAsignacion(
            @RequestParam Long claseId,
            @RequestParam Long instructorId,
            @RequestParam String fechaAsignacion,
            @RequestParam(required = false) String observaciones,
            Model model) {

        System.out.println("=== DATOS RECIBIDOS ===");
        System.out.println("Clase ID: " + claseId);
        System.out.println("Instructor ID: " + instructorId);
        System.out.println("Fecha: " + fechaAsignacion);
        System.out.println("Observaciones: " + observaciones);
        System.out.println("=====================");

        return "redirect:/admin/nueva-asignacion/" + claseId + "?mensaje=Instructor asignado correctamente&tipo=exito";
    }

    // Clase simulada
    private Object crearClaseEjemplo(Long id) {
        return new Object() {
            public Long getId() { return id; }
            public String getNombre() { return "Yoga Avanzado"; }
            public String getCodigo() { return "CLS-2024-00" + id; }
            public String getHorario() { return "Lunes y Miércoles, 18:00 - 19:30"; }
            public Integer getEstudiantes() { return 25; }
        };
    }

    // Lista simulada de instructores
    private List<Object> obtenerInstructoresEjemplo() {
        return Arrays.asList(
                new Object() {
                    public Long getId() { return 1L; }
                    public String getNombreCompleto() { return "Pablo Pérez Rodríguez"; }
                    public String getEspecialidad() { return "Técnica de velocidad"; }
                },
                new Object() {
                    public Long getId() { return 2L; }
                    public String getNombreCompleto() { return "María García López"; }
                    public String getEspecialidad() { return "Principiantes"; }
                },
                new Object() {
                    public Long getId() { return 3L; }
                    public String getNombreCompleto() { return "Rafael Lemus"; }
                    public String getEspecialidad() { return "Preparación física"; }
                }
        );
    }
}
