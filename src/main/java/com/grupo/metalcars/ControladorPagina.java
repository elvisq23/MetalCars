package com.grupo.metalcars;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPagina {

    @GetMapping("/")
    public String pagina(Model model) { // Añade Model como parámetro
        model.addAttribute("contenido", "inicio"); // <--- ¡Añade esta línea!
        return "pagina";  // Página de inicio (cargará el fragmento 'inicio')
    }

    @GetMapping("/nosotros")
    public String nosotros(Model model) {
        model.addAttribute("contenido", "nosotros");  // Asignamos la vista "nosotros.html"
        return "pagina";
    }

    @GetMapping("/servicios")
    public String servicios(Model model) {
        model.addAttribute("contenido", "servicios");  // Asignamos la vista "servicios.html"
        return "pagina";
    }

    @GetMapping("/ubicacion")
    public String ubicacion(Model model) {
        model.addAttribute("contenido", "ubicacion");  // Asignamos la vista "ubicacion.html"
        return "pagina";
    }

    @GetMapping("/acceso")
    public String acceso() {
        return "acceso";  // Página de acceso (login)
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";  // Página de registro
    }
}
