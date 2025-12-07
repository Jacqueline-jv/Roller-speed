package com.rollerspeed.rollerspeed.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.rollerspeed.rollerspeed.Model.User;
import com.rollerspeed.rollerspeed.service.HorarioService;
import com.rollerspeed.rollerspeed.service.UserService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    private final HorarioService horarioService;
    private final UserService userService;

    public AlumnoController(HorarioService horarioService, UserService userService) {
        this.horarioService = horarioService;
        this.userService = userService;
    }

    @GetMapping("/inicio")
    public String inicioAlumno() {
        return "alumno-inicio"; 
    }
    @GetMapping("/Horario")
     public String horarioAlumno(Model model){
        model.addAttribute("horario", horarioService.MostrarHorarios());
        return "Horario";
    }
    @GetMapping("/DatosUsuario")
     public String mostrarDatosUsuario(Model model){
        List<User> user = userService.listarUsuarios();
        model.addAttribute("users", user);
        return "DatosUsuario";
     }
     @PostMapping("/DatosUsuario")
     public String actualizarUsuario(@ModelAttribute User user) {
         userService.modificarUsuario(user.getId(), user);
         return "redirect:/alumno/DatosUsuario";
     }
}
