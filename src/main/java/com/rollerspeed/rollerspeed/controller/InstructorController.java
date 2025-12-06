package com.rollerspeed.rollerspeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Arrays;
import java.util.List;

@Controller
public class InstructorController {
    
    @GetMapping("/admin/asignar-instructor")
    public String mostrarFormularioAsignacion(@PathVariable Long claseId, Model model) {
        // Obtener datos de la clase (simulados por ahora)
        model.addAttribute("clase", obtenerClasePorId(claseId));
        
        // Obtener lista de instructores (simulados por ahora)
        model.addAttribute("instructores", obtenerInstructoresDisponibles());
        
        return "asignar-instructor"; // Nombre de la plantilla Thymeleaf (sin .html)
    }
    
    @PostMapping("/admin/asignar")
    public String asignarInstructor(@RequestParam Long claseId, 
                                    @RequestParam String instructor,
                                    Model model) {
        // Lógica para asignar instructor
        System.out.println("Asignando instructor " + instructor + " a clase " + claseId);
        
        // Redirigir a una página de confirmación o listado
        return "redirect:/admin/clases";
    }
    
    // Métodos de ejemplo (reemplazar con tu lógica real)
    private Object obtenerClasePorId(Long id) {
        // Simulación de una clase
        return new Object() {
            public Long getId() { return id; }
            public String getNombre() { return "Yoga para Principiantes"; }
        };
    }
    
    private List<Object> obtenerInstructoresDisponibles() {
        // Simulación de instructores
        return Arrays.asList(
            new Object() {
                public String getUsername() { return "jperez"; }
                public String getNombreCompleto() { return "Juan Pérez"; }
            },
            new Object() {
                public String getUsername() { return "mgarcia"; }
                public String getNombreCompleto() { return "María García"; }
            }
        );
    }
}