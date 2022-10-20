package com.cybertronicaoeltda.services.dto;

import javax.validation.constraints.NotBlank;

public class UsuarioDto {

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
    private String telefono;
    @NotBlank
    private String rol;
    @NotBlank
    private String estado;

    public UsuarioDto() {
    }

    public UsuarioDto(String sub, String correo, String nombre, String apellido, String area, String cargo, String telefono, String rol, String estado) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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
