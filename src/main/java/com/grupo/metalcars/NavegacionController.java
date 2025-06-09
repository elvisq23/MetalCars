/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.metalcars;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacionController {

    @GetMapping("/inicio")
    public String mostrarInicio() {
        return "inicio"; // Antes era "inicio" o "home/inicio"
    }

    @GetMapping("/acceso")
    public String mostrarAcceso() {
        return "acceso";
    }
    
    @GetMapping("/registro")
    public String registro() {
        return "registro"; // Esta es la página de registro (pública)
    }

    // --- Rutas para DUEÑO ---
    @GetMapping("/dashboard-dueno") // Nueva URL sin subcarpeta
    public String mostrarDashboardDueno() {
        return "dashboard-dueno"; // Antes era "dueno/dashboard-dueno"
    }

    @GetMapping("/sedes") // Ruta para acceder a la página de CRUD de sedes
    public String mostrarSedes() {
        return "sedes"; // Retorna el nombre de la plantilla HTML
    }
    
    @GetMapping("/reportes") // Nueva URL
    public String mostrarReportes() {
        return "reportes"; // Antes era "dueno/reportes"
    }

    @GetMapping("/colaboradores") // Nueva URL
    public String mostrarColaboradores() {
        return "colaboradores"; // Antes era "dueno/colaboradores"
    }

    @GetMapping("/conductores-dueno") // Nueva URL para evitar conflicto si conductor también tiene una
    public String mostrarConductoresDueno() {
        return "conductores-dueno"; // Antes era "dueno/conductores"
    }

    // --- Rutas para CONDUCTOR ---
    @GetMapping("/vehiculos") // Nueva URL sin subcarpeta
    public String mostrarVehiculosConductor() {
        return "vehiculos"; // Antes era "conductor/vehiculos"
    }

    @GetMapping("/serviciosSis") // Nueva URL
    public String mostrarServiciosConductor() {
        return "serviciosSis"; // Antes era "conductor/serviciosSis"
    }

    @GetMapping("/reservas") // Nueva URL
    public String mostrarReservasConductor() {
        return "reservas"; // Antes era "conductor/reservas"
    }

    // ... otros mappings si tienes
}