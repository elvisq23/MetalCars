package com.grupo.metalcars;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorInicio {

    @GetMapping("/")
    public String inicio() {
        // Devuelve la vista "inicio.html"
        return "inicio";  // Spring Boot buscará automáticamente src/main/resources/templates/inicio.html
    }
}
