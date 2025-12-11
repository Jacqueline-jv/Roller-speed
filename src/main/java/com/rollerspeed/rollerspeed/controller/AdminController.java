package com.rollerspeed.rollerspeed.controller;

import com.rollerspeed.rollerspeed.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inicio")
    public String panelAdmin(Model model) {
        model.addAttribute("usuarios", userService.listarUsuarios());
        return "admin-inicio";
    }
}



