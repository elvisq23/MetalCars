package com.grupo.metalcars;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPagina {

    // --- Mapeos para páginas PÚBLICAS (usan 'pagina.html' como layout) ---
    @GetMapping("/")
    public String pagina(Model model) {
        model.addAttribute("contenido", "inicio"); // Tu landing page (bienvenida)
        return "pagina"; // Este usa tu plantilla maestra para páginas públicas (pagina.html)
    }

    @GetMapping("/nosotros")
    public String nosotros(Model model) {
        model.addAttribute("contenido", "nosotros");
        return "pagina";
    }

    @GetMapping("/servicios")
    public String servicios(Model model) {
        model.addAttribute("contenido", "servicios");
        return "pagina";
    }

    @GetMapping("/ubicacion")
    public String ubicacion(Model model) {
        model.addAttribute("contenido", "ubicacion");
        return "pagina";
    }

    @GetMapping("/acceso")
    public String acceso() {
        return "acceso"; // Esta es la página de login (pública)
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro"; // Esta es la página de registro (pública)
    }

    // --- Mapeos para páginas INTERNAS (usan '_layout.html' como layout) ---
    @GetMapping("/home") // Esta URL sirve la página principal del sistema interno
    public String home() {
        return "home"; // Devuelve home.html, que a su vez decora con _layout.html
    }

    // --- FUTUROS Mapeos para secciones internas ---
    @GetMapping("/conductores") // Ejemplo: para gestionar conductores
    public String conductores() {
        // Aquí podrías añadir lógica para cargar datos de conductores
        // y pasar un modelo si es necesario.
        return "conductores"; // Esto esperaría un archivo src/main/resources/templates/conductores.html
                              // que también decoraría con _layout.html
    }
}