package com.rollerspeed.rollerspeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @GetMapping("/inicio")
    public String inicioAlumno() {
        return "alumno-inicio"; // esta vista debe existir en templates
    }
}
