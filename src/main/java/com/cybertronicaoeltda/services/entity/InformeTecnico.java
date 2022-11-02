package com.cybertronicaoeltda.services.entity;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "informes")
public class InformeTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String cliente;
    @NotBlank
    private String responsable;     // Únicamente puede recibir [Oscar Espitia / Oscar Riveros]
    @Min(1)
    @Max(3)
    private int tipo;
    @NotBlank
    private String usuario;
    private String usuarioCargo;
    @NotBlank
    private String dependencia;
    private Date fechaRetiro;
    private Date fechaRecibe;
    // Datos no obligatorios, se añaden únicamente cuando se ha finalizado el servicio
    //      datos de equipo
    @NotBlank
    private String equipoTipo;
    private String equipoNombre;
    private String equipoMarca;
    private String equipoSN;
    private int contadorHojas;
    private String direccionIP;
    private String monitorNombre;
    private String monitorMarca;
    private String monitorSN;
    private String tecladoNombre;
    private String tecladoMarca;
    private String tecladoSN;
    private String mouseNombre;
    private String mouseMarca;
    private String mouseSN;
    //      Datos de recepción
    private String recibe;
    private String recibeCargo;
    @Column(columnDefinition="TEXT", length = 50000)
    private String firmaRecibe;
    private String servicioDetalle;
    private String observaciones;

    public InformeTecnico() {
    }

    public InformeTecnico(String cliente, int tipo, String usuario, String dependencia, Date fechaRetiro, String equipoTipo) {
        this.cliente = cliente;
        this.tipo = tipo;
        this.usuario = usuario;
        this.dependencia = dependencia;
        this.fechaRetiro = fechaRetiro;
        this.equipoTipo = equipoTipo;
    }

    public InformeTecnico(String cliente, String responsable, int tipo, String usuario, String dependencia, Date fechaRetiro, Date fechaRecibe,String equipoTipo,String equipoNombre, String equipoMarca, String equipoSN, String monitorNombre, String monitorMarca, String monitorSN, String tecladoNombre, String tecladoMarca, String tecladoSN, String mouseNombre, String mouseMarca, String mouseSN, String recibe, String firmaRecibe, String servicioDetalle, String observaciones, int contadorHojas, String direccionIP, String recibeCargo, String usuarioCargo) {
        this.cliente = cliente;
        this.responsable = responsable;
        this.tipo = tipo;
        this.usuario = usuario;
        this.dependencia = dependencia;
        this.fechaRetiro = fechaRetiro;
        this.fechaRecibe = fechaRecibe;
        this.equipoTipo = equipoTipo;
        this.equipoNombre = equipoNombre;
        this.equipoMarca = equipoMarca;
        this.equipoSN = equipoSN;
        this.monitorNombre = monitorNombre;
        this.monitorMarca = monitorMarca;
        this.monitorSN = monitorSN;
        this.tecladoNombre = tecladoNombre;
        this.tecladoMarca = tecladoMarca;
        this.tecladoSN = tecladoSN;
        this.mouseNombre = mouseNombre;
        this.mouseMarca = mouseMarca;
        this.mouseSN = mouseSN;
        this.recibe = recibe;
        this.firmaRecibe = firmaRecibe;
        this.servicioDetalle = servicioDetalle;
        this.observaciones = observaciones;
        this.usuarioCargo = usuarioCargo;
        this.recibeCargo = recibeCargo;
        this.contadorHojas = contadorHojas;
        this.direccionIP = direccionIP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getResponsable() { return responsable; }

    public void setResponsable(String responsable) { this.responsable = responsable; }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public Date getFechaRecibe() {
        return fechaRecibe;
    }

    public void setFechaRecibe(Date fechaRecibe) {
        this.fechaRecibe = fechaRecibe;
    }

    public String getEquipoTipo() {
        return equipoTipo;
    }

    public void setEquipoTipo(String equipoTipo) {
        this.equipoTipo = equipoTipo;
    }

    public String getEquipoNombre() {
        return equipoNombre;
    }

    public void setEquipoNombre(String equipoNombre) {
        this.equipoNombre = equipoNombre;
    }

    public String getEquipoMarca() {
        return equipoMarca;
    }

    public void setEquipoMarca(String equipoMarca) {
        this.equipoMarca = equipoMarca;
    }

    public String getEquipoSN() {
        return equipoSN;
    }

    public void setEquipoSN(String equipoSN) {
        this.equipoSN = equipoSN;
    }

    public String getMonitorNombre() {
        return monitorNombre;
    }

    public void setMonitorNombre(String monitorNombre) {
        this.monitorNombre = monitorNombre;
    }

    public String getMonitorMarca() {
        return monitorMarca;
    }

    public void setMonitorMarca(String monitorMarca) {
        this.monitorMarca = monitorMarca;
    }

    public String getMonitorSN() {
        return monitorSN;
    }

    public void setMonitorSN(String monitorSN) {
        this.monitorSN = monitorSN;
    }

    public String getTecladoNombre() {
        return tecladoNombre;
    }

    public void setTecladoNombre(String tecladoNombre) {
        this.tecladoNombre = tecladoNombre;
    }

    public String getTecladoMarca() {
        return tecladoMarca;
    }

    public void setTecladoMarca(String tecladoMarca) {
        this.tecladoMarca = tecladoMarca;
    }

    public String getTecladoSN() {
        return tecladoSN;
    }

    public void setTecladoSN(String tecladoSN) {
        this.tecladoSN = tecladoSN;
    }

    public String getMouseNombre() {
        return mouseNombre;
    }

    public void setMouseNombre(String mouseNombre) {
        this.mouseNombre = mouseNombre;
    }

    public String getMouseMarca() {
        return mouseMarca;
    }

    public void setMouseMarca(String mouseMarca) {
        this.mouseMarca = mouseMarca;
    }

    public String getMouseSN() {
        return mouseSN;
    }

    public void setMouseSN(String mouseSN) {
        this.mouseSN = mouseSN;
    }

    public String getRecibe() {
        return recibe;
    }

    public void setRecibe(String recibe) {
        this.recibe = recibe;
    }

    public String getFirmaRecibe() {
        return firmaRecibe;
    }

    public void setFirmaRecibe(String firmaRecibe) {
        this.firmaRecibe = firmaRecibe;
    }

    public String getServicioDetalle() {
        return servicioDetalle;
    }

    public void setServicioDetalle(String servicioDetalle) {
        this.servicioDetalle = servicioDetalle;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getUsuarioCargo() {
        return usuarioCargo;
    }

    public void setUsuarioCargo(String usuarioCargo) {
        this.usuarioCargo = usuarioCargo;
    }

    public int getContadorHojas() {
        return contadorHojas;
    }

    public void setContadorHojas(int contadorHojas) {
        this.contadorHojas = contadorHojas;
    }

    public String getDireccionIP() {
        return direccionIP;
    }

    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    public String getRecibeCargo() {
        return recibeCargo;
    }

    public void setRecibeCargo(String recibeCargo) {
        this.recibeCargo = recibeCargo;
    }
}
