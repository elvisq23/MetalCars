/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.grupo.metalcars.modelos;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(unique = true, nullable = false, length = 100)
    private String correo;

    @Column(nullable = false, length = 255)
    private String contrasenia; // Contraseña sin encriptar (por simplicidad extrema)

    @Column(unique = true, nullable = false, length = 20)
    private String dni; // Si el DNI es exclusivo del Usuario, déjalo aquí

    @Column(length = 20)
    private String telefono; // Si el teléfono es exclusivo del Usuario, déjalo aquí

    @Column(nullable = false)
    private Boolean estado; // true: activo, false: inactivo

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    // --- ¡RELACIÓN OneToOne con Conductor! ---
    // 'mappedBy' indica que la columna FK está en la entidad Conductor (campo 'usuario')
    // 'cascade = CascadeType.ALL' es CRUCIAL para guardar Conductor cuando guardas Usuario
    // 'orphanRemoval = true' es útil si quieres eliminar el Conductor al eliminar el Usuario
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Conductor conductor;
    // ------------------------------------------

    public Usuario() { }

    // Constructor sin los campos de Conductor específicos
    public Usuario(String nombres, String apellidos, String correo, String contrasenia, String dni, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.dni = dni;
        this.telefono = telefono;
        this.estado = true;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }
    public Set<Rol> getRoles() { return roles; }
    public void setRoles(Set<Rol> roles) { this.roles = roles; }

    // --- Getters y Setters para Conductor ---
    public Conductor getConductor() {
        return conductor;
    }

    // Este setter es crucial para mantener la consistencia bidireccional
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
        if (conductor != null) {
            conductor.setUsuario(this); // Asegura que el lado de Conductor también apunte a este Usuario
        }
    }
}