package com.grupo.metalcars.modelos; // Asegúrate de que este sea el paquete correcto para tus modelos/entidades

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica que esta clase es una entidad JPA y se mapea a una tabla de BD
@Table(name = "sede") // Especifica el nombre de la tabla en la base de datos
public class Sede {

    @Id // Marca este campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el ID es auto-incremental en la BD
    private Integer id; // Mapea a la columna 'id'

    @Column(name = "nombre_sede", length = 50) // Mapea a 'nombre_sede', con longitud de 50
    private String nombreSede;

    @Column(name = "direccion", length = 255) // Mapea a 'direccion', con longitud de 255
    private String direccion;

    @Column(name = "telefono_contacto", length = 20) // Mapea a 'telefono_contacto', con longitud de 20
    private String telefonoContacto;

    @Column(name = "capacidad_maxima") // Mapea a 'capacidad_maxima'
    private Integer capacidadMaxima;

    @Column(name = "autos_ocupados") // Mapea a 'autos_ocupados'
    private Integer autosOcupados;

    // Constructor vacío (necesario para JPA)
    public Sede() {
    }

    // Constructor para crear nuevas sedes (sin ID, ya que es auto-incremental)
    public Sede(String nombreSede, String direccion, String telefonoContacto, Integer capacidadMaxima, Integer autosOcupados) {
        this.nombreSede = nombreSede;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
        this.capacidadMaxima = capacidadMaxima;
        this.autosOcupados = autosOcupados;
    }

    // Getters y Setters para acceder y modificar los atributos de la sede

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Integer getAutosOcupados() {
        return autosOcupados;
    }

    public void setAutosOcupados(Integer autosOcupados) {
        this.autosOcupados = autosOcupados;
    }

    @Override
    public String toString() {
        return "Sede{" +
               "id=" + id +
               ", nombreSede='" + nombreSede + '\'' +
               ", direccion='" + direccion + '\'' +
               ", telefonoContacto='" + telefonoContacto + '\'' +
               ", capacidadMaxima=" + capacidadMaxima +
               ", autosOcupados=" + autosOcupados +
               '}';
    }
}