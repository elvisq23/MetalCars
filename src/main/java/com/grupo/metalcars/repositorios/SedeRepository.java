package com.grupo.metalcars.repositorios; // Asegúrate de que este sea el paquete correcto para tus repositorios

import com.grupo.metalcars.modelos.Sede; // Importa la clase Sede que acabamos de crear
import org.springframework.data.jpa.repository.JpaRepository; // Importa JpaRepository
import org.springframework.stereotype.Repository; // Opcional, pero buena práctica para claridad

import java.util.List; // Necesario para el método de búsqueda

@Repository
public interface SedeRepository extends JpaRepository<Sede, Integer> {
    // Agrega este método para buscar sedes por parte de su nombre
    List<Sede> findByNombreSedeContaining(String nombreSede);
}