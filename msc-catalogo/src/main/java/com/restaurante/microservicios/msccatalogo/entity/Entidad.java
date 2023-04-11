package com.restaurante.microservicios.msccatalogo.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Entity
@EqualsAndHashCode
public class Entidad {
    private long entidad;
    private String descripcion;
    private String abreviatura;
    private String titulo;
    private String subTitulo;
    private String empresa;
    //private byte[] imagenLogo1;
    //private byte[] imagenLogo2;
    private int estadoRegistro;
    private String creacionSesion;
    private Date creacionFecha;
    private String controlSesion;
    private Date controlFecha;

    @Id
    @Column(name = "ENTIDAD", nullable = false)
    public long getEntidad() {
        return entidad;
    }

    public void setEntidad(long entidad) {
        this.entidad = entidad;
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
    @Column(name = "ABREVIATURA", nullable = true, length = 5)
    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Basic
    @Column(name = "TITULO", nullable = true, length = 100)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "SUB_TITULO", nullable = true, length = 100)
    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    @Basic
    @Column(name = "EMPRESA", nullable = false, length = 10)
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /*@Basic
    @Column(name = "IMAGEN_LOGO1", nullable = true)
    public byte[] getImagenLogo1() {
        return imagenLogo1;
    }

    public void setImagenLogo1(byte[] imagenLogo1) {
        this.imagenLogo1 = imagenLogo1;
    }

    @Basic
    @Column(name = "IMAGEN_LOGO2", nullable = true)
    public byte[] getImagenLogo2() {
        return imagenLogo2;
    }

    public void setImagenLogo2(byte[] imagenLogo2) {
        this.imagenLogo2 = imagenLogo2;
    }*/

    @Basic
    @Column(name = "ESTADO_REGISTRO", nullable = false)
    public int getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(int estadoRegistro) {
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


}
