/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.metalcars.repositorios;

import com.grupo.metalcars.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método para buscar un usuario por su correo electrónico
    Optional<Usuario> findByCorreo(String correo);

    // ¡NUEVO MÉTODO! para buscar un usuario por su DNI
    Optional<Usuario> findByDni(String dni);
}