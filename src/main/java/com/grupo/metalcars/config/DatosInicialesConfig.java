/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.metalcars.config;

import com.grupo.metalcars.modelos.Rol;
import com.grupo.metalcars.repositorios.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatosInicialesConfig {

    @Bean
    public CommandLineRunner inicializarRoles(RolRepository rolRepository) {
        return args -> {
            // Verifica si el rol "CONDUCTOR" ya existe. Si no, lo crea.
            if (rolRepository.findByNombre("CONDUCTOR").isEmpty()) {
                rolRepository.save(new Rol("CONDUCTOR"));
                System.out.println("Rol 'CONDUCTOR' creado.");
            }
            // Puedes añadir otros roles si los necesitas en el futuro, ej. "ADMIN", "USUARIO"
            if (rolRepository.findByNombre("ADMIN").isEmpty()) {
                rolRepository.save(new Rol("ADMIN"));
                System.out.println("Rol 'ADMIN' creado.");
            }
        };
    }
}