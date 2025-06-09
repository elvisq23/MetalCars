package com.grupo.metalcars.dto;

import java.util.List;

public class LoginRespuestaDTO {
    private Long idUsuario;
    private String correo;
    private String nombres;
    private List<String> roles;
    private String mensaje;

    public LoginRespuestaDTO() {
    }

    public LoginRespuestaDTO(Long idUsuario, String correo, String nombres, List<String> roles, String mensaje) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.nombres = nombres;
        this.roles = roles;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}