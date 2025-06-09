/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.metalcars.dto; // Asegúrate de que el paquete sea 'dto'

public class AccesoRequisito {
    private String correo;
    private String contrasenia;

    public AccesoRequisito() {
    }

    public AccesoRequisito(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    // Getters
    public String getCorreo() {
        return correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    // Setters
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}