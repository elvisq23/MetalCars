package com.grupo.metalcars.api;

import com.grupo.metalcars.dto.AccesoRequisito;
import com.grupo.metalcars.dto.LoginRespuestaDTO; // <--- ¡NUEVA IMPORTACIÓN!
import com.grupo.metalcars.dto.RegistroConductorDTO;
import com.grupo.metalcars.modelos.Conductor;
import com.grupo.metalcars.modelos.Rol;
import com.grupo.metalcars.modelos.Usuario;
import com.grupo.metalcars.repositorios.ConductorRepository;
import com.grupo.metalcars.repositorios.RolRepository;
import com.grupo.metalcars.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors; // <--- ¡NUEVA IMPORTACIÓN!

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:8081") // Asegúrate que este sea el puerto de tu frontend
public class ControladorAutenticacion {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private ConductorRepository conductorRepository;

    @PostMapping("/registro")
    @Transactional
    public ResponseEntity<?> registrarConductor(@RequestBody RegistroConductorDTO registroDTO) {
        try {
            // ... (Tu código de registro de conductor existente) ...
            if (usuarioRepository.findByCorreo(registroDTO.getCorreo()).isPresent()) {
                return new ResponseEntity<>("El correo electrónico ya está registrado.", HttpStatus.BAD_REQUEST);
            }
            if (usuarioRepository.findByDni(registroDTO.getDni()).isPresent()) {
                return new ResponseEntity<>("El DNI ya está registrado.", HttpStatus.BAD_REQUEST);
            }

            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombres(registroDTO.getNombres());
            nuevoUsuario.setApellidos(registroDTO.getApellidos());
            nuevoUsuario.setCorreo(registroDTO.getCorreo());
            nuevoUsuario.setContrasenia(registroDTO.getContrasenia());
            nuevoUsuario.setDni(registroDTO.getDni());
            nuevoUsuario.setTelefono(registroDTO.getTelefono());
            nuevoUsuario.setEstado(true);

            Optional<Rol> rolConductorOpt = rolRepository.findByNombre("CONDUCTOR");
            if (!rolConductorOpt.isPresent()) {
                return new ResponseEntity<>("Error interno al registrar: El rol 'CONDUCTOR' no está configurado en la base de datos.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            Rol rolConductor = rolConductorOpt.get();
            nuevoUsuario.setRoles(Collections.singleton(rolConductor));

            Usuario usuarioGuardado = usuarioRepository.save(nuevoUsuario);

            Conductor nuevoConductor = new Conductor();
            nuevoConductor.setRuc(registroDTO.getRuc());

            nuevoConductor.setUsuario(usuarioGuardado);
            usuarioGuardado.setConductor(nuevoConductor);

            conductorRepository.save(nuevoConductor);

            return new ResponseEntity<>("Conductor registrado exitosamente!", HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error interno al registrar el conductor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> autenticarUsuario(@RequestBody AccesoRequisito accesoRequisito) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(accesoRequisito.getCorreo());

        if (usuarioOpt.isEmpty()) {
            return new ResponseEntity<>("Correo o contraseña inválidos.", HttpStatus.UNAUTHORIZED);
        }

        Usuario usuario = usuarioOpt.get();

        if (usuario.getContrasenia().equals(accesoRequisito.getContrasenia())) {
            // Mapear los roles a una lista de nombres de roles (String)
            List<String> nombresRoles = usuario.getRoles().stream()
                                            .map(Rol::getNombre)
                                            .collect(Collectors.toList());

            // Crear el objeto de respuesta DTO
            LoginRespuestaDTO respuesta = new LoginRespuestaDTO(
                usuario.getId(),
                usuario.getCorreo(),
                usuario.getNombres(),
                nombresRoles,
                "Inicio de sesión exitoso!"
            );
            return new ResponseEntity<>(respuesta, HttpStatus.OK); // <--- ¡Devuelve el DTO!
        } else {
            return new ResponseEntity<>("Correo o contraseña inválidos.", HttpStatus.UNAUTHORIZED);
        }
    }
}