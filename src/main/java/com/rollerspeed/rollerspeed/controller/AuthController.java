package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.Model.User;
import com.rollerspeed.rollerspeed.service.UserService;
import jakarta.servlet.http.HttpSession;
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

    // LOGIN GET
    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            Model model) {
        if (error != null) {
            model.addAttribute("mensaje", "Credenciales incorrectas.");
        }
        return "login";  // ← CORREGIDO
    }

    // LOGIN POST
    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {

        User user = userService.buscarPorUsername(username);

        if (user == null) {
            model.addAttribute("mensaje", "Usuario no encontrado");
            return "login";
        }

        boolean valido = userService.validarPassword(password, user.getPassword());

        if (!valido) {
            model.addAttribute("mensaje", "Contraseña incorrecta");
            return "login";
        }

        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getUsername());
        session.setAttribute("role", user.getRole());

        switch (user.getRole().toUpperCase()) {
            case "ADMIN":
                return "redirect:/admin/inicio";
            case "INSTRUCTOR":
                return "redirect:/instructor/inicio";
            case "ALUMNO":
            default:
                return "redirect:/alumno/inicio";
        }
    }

    // REGISTER GET
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";  
    }

    // REGISTER POST
    @PostMapping("/register")
    public String registrarUsuario(@ModelAttribute User user, Model model) {

        if (userService.buscarPorUsername(user.getUsername()) != null) {
            model.addAttribute("mensaje", "El usuario ya existe");
            model.addAttribute("user", user);
            return "register";
        }

        userService.crearUsuario(user);
        return "redirect:/auth/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}





