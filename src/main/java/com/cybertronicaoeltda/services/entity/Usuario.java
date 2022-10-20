package com.cybertronicaoeltda.services.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String sub;
    @NotBlank
    private String correo;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String area;
    @NotBlank
    private String cargo;
    @Column(columnDefinition = "BIGINT", length = 20)
    private Long telefono;
    @NotBlank
    private String rol;
    @NotBlank
    private String estado;

    public Usuario() {
    }

    public Usuario(String sub,String correo, String nombre, String apellido, String area, String cargo, Long telefono, String rol, String estado) {
        this.sub = sub;
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.area = area;
        this.cargo = cargo;
        this.telefono = telefono;
        this.rol = rol;
        this.estado = estado;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
