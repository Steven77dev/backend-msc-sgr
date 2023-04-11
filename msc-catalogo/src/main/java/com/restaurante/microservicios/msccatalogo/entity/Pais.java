package com.restaurante.microservicios.msccatalogo.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class Pais {
    private short pais;
    private String descripcion;
    private String nacionalidad;
    private String abreviatura;
    private Short estadoRegistro;
    private String creacionSesion;
    private Date creacionFecha;
    private String controlSesion;
    private Date controlFecha;

    @Id
    @Column(name = "PAIS", nullable = false)
    public short getPais() {
        return pais;
    }

    public void setPais(short pais) {
        this.pais = pais;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "NACIONALIDAD", nullable = false, length = 50)
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Basic
    @Column(name = "ABREVIATURA", nullable = true, length = 10)
    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Basic
    @Column(name = "ESTADO_REGISTRO", nullable = true)
    public Short getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(Short estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    @Basic
    @Column(name = "CREACION_SESION", nullable = false, length = 30)
    public String getCreacionSesion() {
        return creacionSesion;
    }

    public void setCreacionSesion(String creacionSesion) {
        this.creacionSesion = creacionSesion;
    }

    @Basic
    @Column(name = "CREACION_FECHA", nullable = false)
    public Date getCreacionFecha() {
        return creacionFecha;
    }

    public void setCreacionFecha(Date creacionFecha) {
        this.creacionFecha = creacionFecha;
    }

    @Basic
    @Column(name = "CONTROL_SESION", nullable = false, length = 30)
    public String getControlSesion() {
        return controlSesion;
    }

    public void setControlSesion(String controlSesion) {
        this.controlSesion = controlSesion;
    }

    @Basic
    @Column(name = "CONTROL_FECHA", nullable = false)
    public Date getControlFecha() {
        return controlFecha;
    }

    public void setControlFecha(Date controlFecha) {
        this.controlFecha = controlFecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais1 = (Pais) o;
        return pais == pais1.pais && Objects.equals(descripcion, pais1.descripcion) && Objects.equals(nacionalidad, pais1.nacionalidad) && Objects.equals(abreviatura, pais1.abreviatura) && Objects.equals(estadoRegistro, pais1.estadoRegistro) && Objects.equals(creacionSesion, pais1.creacionSesion) && Objects.equals(creacionFecha, pais1.creacionFecha) && Objects.equals(controlSesion, pais1.controlSesion) && Objects.equals(controlFecha, pais1.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pais, descripcion, nacionalidad, abreviatura, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
