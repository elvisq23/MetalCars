package com.grupo.metalcars;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPagina {

    @GetMapping("/")
    public String pagina() {
        return "pagina";  // Devuelve la vista "pagina.html"
    }
}
