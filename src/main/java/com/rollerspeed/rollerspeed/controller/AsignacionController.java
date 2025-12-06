package com.rollerspeed.rollerspeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class AsignacionController {
    
    @GetMapping("/admin/nueva-asignacion/{id}")
    public String mostrarFormulario(@PathVariable("id") Long claseId, Model model) {
        System.out.println("=== CARGANDO FORMULARIO PARA CLASE: " + claseId + " ===");
        
        // Agregar datos de ejemplo para la clase
        model.addAttribute("clase", crearClaseEjemplo(claseId));
        
        // Agregar lista de instructores de ejemplo
        model.addAttribute("instructores", obtenerInstructoresEjemplo());
        
        // Agregar fecha actual
        model.addAttribute("fechaHoy", LocalDate.now().toString());
        
        // Títulos
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
    
    // Método actualizado - incluye username
    private Object crearClaseEjemplo(Long id) {
        return new Object() {
            public Long getId() { return id; }
            public String getNombre() { return "Yoga Avanzado"; }
            public String getCodigo() { return "CLS-2024-00" + id; }
            public String getHorario() { return "Lunes y Miércoles, 18:00 - 19:30"; }
            public Integer getEstudiantes() { return 25; }
        };
    }
    
    // Método actualizado - incluye username
    private List<Object> obtenerInstructoresEjemplo() {
        return Arrays.asList(
            new Object() {
                public Long getId() { return 1L; }
                public String getNombreCompleto() { return "pablo Pérez Rodríguez"; }
                public String getEspecialidad() { return "Tecnica de velocidad"; }
            },
            new Object() {
                public Long getId() { return 2L; }
                public String getNombreCompleto() { return "María García López"; }
                public String getEspecialidad() { return "Principiantes"; }
            },
            new Object() {
                public Long getId() { return 3L; }
                public String getNombreCompleto() { return "rafael lemus"; }
                public String getEspecialidad() { return "preparación fisica"; }
            }
        );
    }
}