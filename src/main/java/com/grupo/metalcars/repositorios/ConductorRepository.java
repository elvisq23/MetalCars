package com.grupo.metalcars.repositorios;

import com.grupo.metalcars.modelos.Conductor; // Asegúrate de que esta importación sea correcta a tu paquete de modelos
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// La interfaz extiende JpaRepository, pasándole la entidad Conductor y el tipo de su ID (Long)
@Repository // Indica a Spring que esta interfaz es un componente de repositorio
public interface ConductorRepository extends JpaRepository<Conductor, Long> {

    // Puedes añadir métodos de búsqueda personalizados aquí si los necesitas en el futuro,
    // por ejemplo:
    // Optional<Conductor> findByRuc(String ruc);
    // Optional<Conductor> findByUsuarioId(Long usuarioId); // Para buscar un Conductor por el ID de su Usuario
}