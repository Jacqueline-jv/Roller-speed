package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.Model.User;
import com.rollerspeed.rollerspeed.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    private final UserService userService;

    public AlumnoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inicio")
    public String inicioAlumno(Model model) {
        model.addAttribute("clasesDisponibles", "Por implementar");
        return "alumno-inicio";
    }

    @PostMapping("/actualizar")
    public String actualizarPerfil(@ModelAttribute User user) {
        userService.actualizarUsuario(user);
        return "redirect:/alumno/inicio";
    }
}