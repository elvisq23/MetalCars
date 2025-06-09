/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.metalcars; // <--- ¡Cambio en el paquete!

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Usamos @Controller para devolver nombres de vistas (HTML)
@RequestMapping("/dashboard-conductor") // Mapea esta URL
public class DashboardController {

    @GetMapping // Maneja las peticiones GET a /dashboard-conductor
    public String showConductorDashboard() {
        return "layout"; // <--- Devuelve la plantilla 'layout.html'
    }
}