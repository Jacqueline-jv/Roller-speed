package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.Model.User;
import com.rollerspeed.rollerspeed.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ✔ Mostrar formulario de registro
    @GetMapping("/register")
    public String vistaRegistro(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // ✔ Procesar registro
    @PostMapping("/register")
    public String registrar(@ModelAttribute User user, Model model) {

        // Guardar usuario con su rol y contraseña encriptada
        userService.crearUsuario(user);

        model.addAttribute("mensaje", "Registro exitoso, inicia sesión");
        return "login";
    }

    // ✔ Mostrar formulario de login
    @GetMapping("/login")
    public String vistaLogin(Model model) {
        return "login";
    }

    // ✔ Procesar login
    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        User usuario = userService.buscarPorUsername(username);

        if (usuario == null) {
            model.addAttribute("error", "Usuario no encontrado");
            return "login";
        }

        if (!userService.validarPassword(password, usuario.getPassword())) {
            model.addAttribute("error", "Contraseña incorrecta");
            return "login";
        }

        // ✔ Redirigir según rol
        switch (usuario.getRole().toUpperCase()) {

            case "ADMIN":
                return "redirect:/admin/inicio";

            case "INSTRUCTOR":
                return "redirect:/instructor/inicio";

            case "ALUMNO":
                return "redirect:/alumno/inicio";

            default:
                return "redirect:/";
        }
    }
}


