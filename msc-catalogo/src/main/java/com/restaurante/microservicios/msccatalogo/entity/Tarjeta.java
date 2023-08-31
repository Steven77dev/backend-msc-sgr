package com.restaurante.microservicios.msccatalogo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(TarjetaPK.class)
@Table(name ="TARJETA" ,schema = "FINA")
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tarjeta {
    private int entidad;
    private int tarjeta;
    private String descripcion;
    private String abreviatura;
    private BigDecimal porcentaje;
    private short banco;
    private short cuenta;
    private int estadoRegistro;
    private String creacionSesion;
    private Timestamp creacionFecha;
    private String controlSesion;
    private Timestamp controlFecha;

    @Id
    @Column(name = "ENTIDAD", nullable = false)
    public int getEntidad() {
        return entidad;
    }

    public void setEntidad(int entidad) {
        this.entidad = entidad;
    }

    @Id
    @Column(name = "TARJETA", nullable = false)
    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
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
    @Column(name = "ABREVIATURA", nullable = true, length = 10)
    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Basic
    @Column(name = "PORCENTAJE", nullable = false, precision = 2)
    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Basic
    @Column(name = "BANCO", nullable = false)
    public short getBanco() {
        return banco;
    }

    public void setBanco(short banco) {
        this.banco = banco;
    }

    @Basic
    @Column(name = "CUENTA", nullable = false)
    public short getCuenta() {
        return cuenta;
    }

    public void setCuenta(short cuenta) {
        this.cuenta = cuenta;
    }

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
        Tarjeta tarjeta1 = (Tarjeta) o;
        return entidad == tarjeta1.entidad && tarjeta == tarjeta1.tarjeta && banco == tarjeta1.banco && cuenta == tarjeta1.cuenta && estadoRegistro == tarjeta1.estadoRegistro && Objects.equals(descripcion, tarjeta1.descripcion) && Objects.equals(abreviatura, tarjeta1.abreviatura) && Objects.equals(porcentaje, tarjeta1.porcentaje) && Objects.equals(creacionSesion, tarjeta1.creacionSesion) && Objects.equals(creacionFecha, tarjeta1.creacionFecha) && Objects.equals(controlSesion, tarjeta1.controlSesion) && Objects.equals(controlFecha, tarjeta1.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entidad, tarjeta, descripcion, abreviatura, porcentaje, banco, cuenta, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
