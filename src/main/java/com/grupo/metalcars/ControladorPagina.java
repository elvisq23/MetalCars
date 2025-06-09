package com.grupo.metalcars;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Importa la clase Model para pasar datos a la vista
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Marca esta clase como un controlador de Spring
public class ControladorPagina {

    // Maneja la ruta raíz ("/") y "/inicio" para la landing page.
    // Inicia con la sección 'home' por defecto.
    @GetMapping({"/", "/inicio"})
    public String mostrarInicioLanding(Model model) {
        // Añade al modelo el nombre del fragmento HTML que debe cargarse en 'pagina.html'
        // Asumo que 'home.html' está en la carpeta 'landing_fragments'
        model.addAttribute("contenido", "home");
        return "pagina"; // Devuelve el nombre de la plantilla base de tu landing (pagina.html)
    }

    // Maneja la ruta "/nosotros" para mostrar la sección "Nosotros"
    @GetMapping("/nosotros")
    public String mostrarNosotrosLanding(Model model) {
        // Añade al modelo el nombre del fragmento HTML para "Nosotros"
        model.addAttribute("contenido", "nosotros");
        return "pagina"; // Devuelve la plantilla base de tu landing (pagina.html)
    }

    // Maneja la ruta "/servicios" para mostrar la sección "Servicios"
    @GetMapping("/servicios")
    public String mostrarServiciosLanding(Model model) {
        // Añade al modelo el nombre del fragmento HTML para "Servicios"
        model.addAttribute("contenido", "servicios");
        return "pagina"; // Devuelve la plantilla base de tu landing (pagina.html)
    }

    // Maneja la ruta "/ubicacion" para mostrar la sección "Ubícanos"
    @GetMapping("/ubicacion")
    public String mostrarUbicacionLanding(Model model) {
        // Añade al modelo el nombre del fragmento HTML para "Ubícanos"
        model.addAttribute("contenido", "ubicacion");
        return "pagina"; // Devuelve la plantilla base de tu landing (pagina.html)
    }

    // --- IMPORTANTE: Deja aquí solo las rutas de la LANDING PAGE ---
    // Si la ruta /acceso es la página de login para el sistema interno,
    // asegúrate de que la esté manejando el NavegacionController
    // para evitar conflictos. Si esta es la página de login de la landing, déjala.
   
    // Si tienes otras rutas para la landing (ej. /registro), añádelas aquí de forma similar.
    // ...
}