/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.metalcars.modelos;

import jakarta.persistence.*; // Usamos jakarta.persistence para Spring Boot 3+

@Entity
@Table(name = "conductores") // Mapea a tu tabla "conductores"
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación OneToOne con Usuario
    // La clave foránea 'id_usuario' está en esta tabla 'conductores'.
    // Esto hace a 'Conductor' el lado "propietario" de la relación,
    // es decir, 'conductores' contendrá la columna 'usuario_id' (o 'id_usuario').
    @OneToOne(fetch = FetchType.LAZY) // Cargar el usuario asociado solo cuando se necesita
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", unique = true, nullable = false)
    private Usuario usuario;

    @Column(name = "ruc", length = 15) // Asegúrate que el nombre de la columna coincida con tu DDL
    private String ruc;

    // --- Otros campos específicos del conductor (ej. Licencia, etc.) ---
    // Si tenías DNI y Telefono en Usuario, y son específicos del conductor,
    // podrías moverlos aquí en el futuro para una mejor cohesión.
    // Pero por ahora, los dejamos en Usuario como los tienes.
    // Si necesitas numeroLicencia, categoriaLicencia aquí, ¡añádelos!
    // private String numeroLicencia;
    // private String categoriaLicencia;
    // private Boolean disponible;
    // --------------------------------------------------------------------

    public Conductor() {}

    // Constructor si quieres crear un Conductor directamente con un Usuario y RUC
    public Conductor(Usuario usuario, String ruc) {
        this.usuario = usuario;
        this.ruc = ruc;
        // Si añades más campos, inclúyelos aquí
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    
    // --- Getters y Setters para otros campos si los añades ---
    // public String getNumeroLicencia() { return numeroLicencia; }
    // public void setNumeroLicencia(String numeroLicencia) { this.numeroLicencia = numeroLicencia; }
    // ... y así sucesivamente
}