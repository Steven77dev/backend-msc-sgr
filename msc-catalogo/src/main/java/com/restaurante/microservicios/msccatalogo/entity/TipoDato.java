package com.restaurante.microservicios.msccatalogo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "TIPO_DATO", schema = "DATO", catalog = "BDKM_BP")
public class TipoDato {
    private short tipoDato;
    private String descripcion;
    private String abreviatura;
    private short orden;
    private short objetoTipo;
    private String dtcStore;
    private String dtcParam;
    private short estadoRegistro;
    private String creacionSesion;
    private Timestamp creacionFecha;
    private String controlSesion;
    private Timestamp controlFecha;

    @Id
    @Column(name = "TIPO_DATO", nullable = false)
    public short getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(short tipoDato) {
        this.tipoDato = tipoDato;
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
    @Column(name = "ORDEN", nullable = false)
    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
    }

    @Basic
    @Column(name = "OBJETO_TIPO", nullable = false)
    public short getObjetoTipo() {
        return objetoTipo;
    }

    public void setObjetoTipo(short objetoTipo) {
        this.objetoTipo = objetoTipo;
    }

    @Basic
    @Column(name = "DTC_STORE", nullable = true, length = 50)
    public String getDtcStore() {
        return dtcStore;
    }

    public void setDtcStore(String dtcStore) {
        this.dtcStore = dtcStore;
    }

    @Basic
    @Column(name = "DTC_PARAM", nullable = true, length = 50)
    public String getDtcParam() {
        return dtcParam;
    }

    public void setDtcParam(String dtcParam) {
        this.dtcParam = dtcParam;
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
        TipoDato tipoDato1 = (TipoDato) o;
        return tipoDato == tipoDato1.tipoDato && orden == tipoDato1.orden && objetoTipo == tipoDato1.objetoTipo && estadoRegistro == tipoDato1.estadoRegistro && Objects.equals(descripcion, tipoDato1.descripcion) && Objects.equals(abreviatura, tipoDato1.abreviatura) && Objects.equals(dtcStore, tipoDato1.dtcStore) && Objects.equals(dtcParam, tipoDato1.dtcParam) && Objects.equals(creacionSesion, tipoDato1.creacionSesion) && Objects.equals(creacionFecha, tipoDato1.creacionFecha) && Objects.equals(controlSesion, tipoDato1.controlSesion) && Objects.equals(controlFecha, tipoDato1.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDato, descripcion, abreviatura, orden, objetoTipo, dtcStore, dtcParam, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
