package com.grupo.metalcars.api; // Asegúrate de que este sea el paquete correcto para tus APIs

import com.grupo.metalcars.modelos.Sede; // Importa la entidad Sede
import com.grupo.metalcars.repositorios.SedeRepository; // Importa el repositorio de Sede
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081") // Permite peticiones desde tu frontend Vue.js (ajusta el puerto si es diferente)
@RestController // Indica que esta clase es un controlador REST y manejará peticiones HTTP
@RequestMapping("/api") // Define el prefijo base para todas las rutas de este controlador
public class SedeRestController {

    @Autowired // Inyecta automáticamente una instancia de SedeRepository
    SedeRepository sedeRepository;

    // --- C (Create) - POST /api/sedes ---
    @PostMapping("/sedes")
    public ResponseEntity<Sede> createSede(@RequestBody Sede sede) {
        try {
            // Guarda una nueva sede. El ID será generado automáticamente por la BD.
            // Asegúrate de que los valores para 'nombreSede', 'direccion', etc., vengan en el JSON del cuerpo de la petición.
            Sede _sede = sedeRepository.save(new Sede(
                sede.getNombreSede(),
                sede.getDireccion(),
                sede.getTelefonoContacto(),
                sede.getCapacidadMaxima(),
                // Inicializa autos_ocupados. Puedes establecer un valor por defecto (ej. 0) si no viene en la petición,
                // o si tu base de datos ya lo hace por defecto. Aquí se toma lo que venga o null si no se envía.
                sede.getAutosOcupados() != null ? sede.getAutosOcupados() : 0
            ));
            return new ResponseEntity<>(_sede, HttpStatus.CREATED); // Retorna la sede creada con estado 201 (Created)
        } catch (Exception e) {
            // Captura cualquier excepción y retorna un error 500 (Internal Server Error)
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // --- R (Read) - GET /api/sedes y GET /api/sedes/{id} ---

    // Obtener todas las sedes o filtrar por nombre_sede (parcial y opcional)
    // Ejemplo de URL: /api/sedes o /api/sedes?nombreSede=central
    @GetMapping("/sedes")
    public ResponseEntity<List<Sede>> getAllSedes(@RequestParam(required = false) String nombreSede) {
        try {
            List<Sede> sedes = new ArrayList<>();

            if (nombreSede == null || nombreSede.isEmpty()) {
                // Si el parámetro nombreSede no se proporciona o está vacío, obtiene todas las sedes
                sedeRepository.findAll().forEach(sedes::add);
            } else {
                // Si se proporciona nombreSede, busca sedes que contengan esa cadena en su nombre
                // NOTA: Para que esto funcione, DEBES añadir el método findByNombreSedeContaining
                // a tu interfaz SedeRepository (ver sección "Pasos Importantes" abajo).
                sedeRepository.findByNombreSedeContaining(nombreSede).forEach(sedes::add);
            }

            if (sedes.isEmpty()) {
                // Si la lista de sedes está vacía después de la búsqueda o sin filtros
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna estado 204 (No Content)
            }
            return new ResponseEntity<>(sedes, HttpStatus.OK); // Retorna la lista de sedes con estado 200 (OK)
        } catch (Exception e) {
            // Captura cualquier excepción y retorna un error 500
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener una sede específica por su ID
    // Ejemplo de URL: /api/sedes/1
    @GetMapping("/sedes/{id}")
    public ResponseEntity<Sede> getSedeById(@PathVariable("id") Integer id) {
        Optional<Sede> sedeData = sedeRepository.findById(id); // Busca la sede por ID

        if (sedeData.isPresent()) {
            return new ResponseEntity<>(sedeData.get(), HttpStatus.OK); // Retorna la sede encontrada con estado 200
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna estado 404 (Not Found) si no existe
        }
    }

    // --- U (Update) - PUT /api/sedes/{id} ---
    @PutMapping("/sedes/{id}")
    public ResponseEntity<Sede> updateSede(@PathVariable("id") Integer id, @RequestBody Sede sede) {
        // Intenta encontrar la sede existente por ID
        Optional<Sede> sedeData = sedeRepository.findById(id);

        if (sedeData.isPresent()) {
            Sede _sede = sedeData.get(); // Obtiene la sede existente
            // Actualiza los campos con los valores recibidos en el cuerpo de la petición
            _sede.setNombreSede(sede.getNombreSede());
            _sede.setDireccion(sede.getDireccion());
            _sede.setTelefonoContacto(sede.getTelefonoContacto());
            _sede.setCapacidadMaxima(sede.getCapacidadMaxima());
            // Para autos_ocupados, si no quieres que se actualice directamente con PUT,
            // no incluyas la siguiente línea. Si quieres que se pueda actualizar, déjala.
            _sede.setAutosOcupados(sede.getAutosOcupados()); // Considera si esto debería ser editable vía PUT

            return new ResponseEntity<>(sedeRepository.save(_sede), HttpStatus.OK); // Guarda y retorna la sede actualizada
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna estado 404 si la sede no se encontró
        }
    }

    // --- D (Delete) - DELETE /api/sedes/{id} ---
    @DeleteMapping("/sedes/{id}")
    public ResponseEntity<HttpStatus> deleteSede(@PathVariable("id") Integer id) {
        try {
            sedeRepository.deleteById(id); // Elimina la sede por ID
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna estado 204 (No Content) por eliminación exitosa
        } catch (Exception e) {
            // Captura cualquier excepción (ej. ID no encontrado) y retorna un error 500
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // --- Opcional: Para el endpoint de lógica de negocio específica como 'incrementarAutosOcupados' ---
    // Si bien la lógica de negocio idealmente va en un Servicio, si sigues el patrón del profesor de
    // no usar un servicio, puedes implementar aquí o crear otro método en el SedeRepository.
    /*
    @PutMapping("/sedes/{id}/ocuparAuto")
    public ResponseEntity<Sede> ocuparAutoEnSede(@PathVariable("id") Integer id) {
        Optional<Sede> sedeOptional = sedeRepository.findById(id);
        if (sedeOptional.isPresent()) {
            Sede sede = sedeOptional.get();
            if (sede.getAutosOcupados() < sede.getCapacidadMaxima()) {
                sede.setAutosOcupados(sede.getAutosOcupados() + 1);
                return new ResponseEntity<>(sedeRepository.save(sede), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT); // 409 Conflict si la sede está llena
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    */
}