package com.restaurante.microservicios.mscubicacion.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Descuento {
    private String descuento;
    private String descripcion;
    private short tipo;
    private BigDecimal monto;
    private short estadoRegistro;
    private String creacionSesion;
    private Timestamp creacionFecha;
    private String controlSesion;
    private Timestamp controlFecha;

    @Id
    @Column(name = "DESCUENTO", nullable = false, length = 4)
    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "TIPO", nullable = false)
    public short getTipo() {
        return tipo;
    }

    public void setTipo(short tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "MONTO", nullable = false, precision = 4)
    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Basic
    @Column(name = "ESTADO_REGISTRO", nullable = false)
    public short getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(short estadoRegistro) {
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
    public Timestamp getCreacionFecha() {
        return creacionFecha;
    }

    public void setCreacionFecha(Timestamp creacionFecha) {
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
    public Timestamp getControlFecha() {
        return controlFecha;
    }

    public void setControlFecha(Timestamp controlFecha) {
        this.controlFecha = controlFecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descuento descuento1 = (Descuento) o;
        return tipo == descuento1.tipo && estadoRegistro == descuento1.estadoRegistro && Objects.equals(descuento, descuento1.descuento) && Objects.equals(descripcion, descuento1.descripcion) && Objects.equals(monto, descuento1.monto) && Objects.equals(creacionSesion, descuento1.creacionSesion) && Objects.equals(creacionFecha, descuento1.creacionFecha) && Objects.equals(controlSesion, descuento1.controlSesion) && Objects.equals(controlFecha, descuento1.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descuento, descripcion, tipo, monto, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
