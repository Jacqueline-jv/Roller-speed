package com.rollerspeed.rollerspeed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        System.out.println("➡ Cargando página: index");
        return "index";
    }

    @GetMapping("/mision")
    public String mision() {
        System.out.println("➡ Cargando página: mision");
        return "mision";
    }

    @GetMapping("/vision")
    public String vision() {
        System.out.println("➡ Cargando página: vision");
        return "vision";
    }

    @GetMapping("/valores")
    public String valores() {
        System.out.println("➡ Cargando página: valores");
        return "valores";
    }

    @GetMapping("/servicios")
    public String servicios() {
        System.out.println("➡ Cargando página: servicios");
        return "servicios";
    }

    @GetMapping("/eventos")
    public String eventos() {
        System.out.println("➡ Cargando página: eventos");
        return "eventos";
    }
}