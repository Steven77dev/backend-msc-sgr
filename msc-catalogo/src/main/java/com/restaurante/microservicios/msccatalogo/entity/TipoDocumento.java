package com.restaurante.microservicios.msccatalogo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "TIPO_DOCUMENTO", schema = "SYST", catalog = "BDKM_BP")
public class TipoDocumento {
    private short tipoDocumento;
    private String descripcion;
    private String abreviatura;
    private Short nroCaracteres;
    private String tdocReniec;
    private String tdocSunat;
    private short estadoRegistro;
    private String creacionSesion;
    private Timestamp creacionFecha;
    private String controlSesion;
    private Timestamp controlFecha;

    @Id
    @Column(name = "TIPO_DOCUMENTO", nullable = false)
    public short getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(short tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = false, length = 150)
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
    @Column(name = "NRO_CARACTERES", nullable = true)
    public Short getNroCaracteres() {
        return nroCaracteres;
    }

    public void setNroCaracteres(Short nroCaracteres) {
        this.nroCaracteres = nroCaracteres;
    }

    @Basic
    @Column(name = "TDOC_RENIEC", nullable = true, length = 2)
    public String getTdocReniec() {
        return tdocReniec;
    }

    public void setTdocReniec(String tdocReniec) {
        this.tdocReniec = tdocReniec;
    }

    @Basic
    @Column(name = "TDOC_SUNAT", nullable = true, length = 2)
    public String getTdocSunat() {
        return tdocSunat;
    }

    public void setTdocSunat(String tdocSunat) {
        this.tdocSunat = tdocSunat;
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
        TipoDocumento that = (TipoDocumento) o;
        return tipoDocumento == that.tipoDocumento && estadoRegistro == that.estadoRegistro && Objects.equals(descripcion, that.descripcion) && Objects.equals(abreviatura, that.abreviatura) && Objects.equals(nroCaracteres, that.nroCaracteres) && Objects.equals(tdocReniec, that.tdocReniec) && Objects.equals(tdocSunat, that.tdocSunat) && Objects.equals(creacionSesion, that.creacionSesion) && Objects.equals(creacionFecha, that.creacionFecha) && Objects.equals(controlSesion, that.controlSesion) && Objects.equals(controlFecha, that.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDocumento, descripcion, abreviatura, nroCaracteres, tdocReniec, tdocSunat, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
