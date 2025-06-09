package com.grupo.metalcars.dto; // O el paquete donde guardes tus DTOs

// Puedes añadir anotaciones de validación de Jakarta si usas Spring Boot 3+
// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;

public class RegistroConductorDTO {

    // Campos del Usuario
    // @NotBlank(message = "El nombre es obligatorio")
    private String nombres;

    // @NotBlank(message = "El apellido es obligatorio")
    private String apellidos;

    // @Email(message = "El correo debe ser una dirección válida")
    // @NotBlank(message = "El correo es obligatorio")
    private String correo;

    // @NotBlank(message = "La contraseña es obligatoria")
    // @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contrasenia;

    // @NotBlank(message = "El DNI es obligatorio")
    private String dni;

    private String telefono;

    // Campos específicos del Conductor
    private String ruc; // Este campo es el que originalmente causaba el problema

    // Constructor vacío (necesario para Spring)
    public RegistroConductorDTO() {
    }

    // Constructor con todos los campos (opcional, pero útil)
    public RegistroConductorDTO(String nombres, String apellidos, String correo, String contrasenia, String dni, String telefono, String ruc) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.dni = dni;
        this.telefono = telefono;
        this.ruc = ruc;
    }

    // Getters y Setters para todos los campos
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
}