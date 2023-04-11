package com.restaurante.microservicios.mscpersona.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="PERSONAS")
@Getter
@Setter
public class Persona {
    private static final long serialVersionUID = 1L;

    private String persona;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String direccionUbigeo;
    private Short tipoTransito;
    private String direccionRecidencia;
    private String direccionReferencia;
    private String direccionUbigeoProc;
    private Short tipoTransitoProc;
    private String direccionRecidenciaProc;
    private String direccionReferenciaProc;
    private String telefono;
    private String telefonoCelular;
    private String emailPrincipal;
    private String emailOpcional;
    private Timestamp nacimientoFecha;
    private String nacimientoUbigeo;
    private Short sexo;
    private Short estadoCivil;
    private Short pais;
    private short estadoRegistro;
    private String creacionSesion;
    private Timestamp creacionFecha;
    private String controlSesion;
    private Timestamp controlFecha;

    @Id
    @Column(name = "PERSONA", nullable = false, length = 20)
    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    @Basic
    @Column(name = "APELLIDO_PATERNO", nullable = true, length = 50)
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Basic
    @Column(name = "APELLIDO_MATERNO", nullable = true, length = 50)
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Basic
    @Column(name = "NOMBRES", nullable = true, length = 50)
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Basic
    @Column(name = "DIRECCION_UBIGEO", nullable = true, length = 6)
    public String getDireccionUbigeo() {
        return direccionUbigeo;
    }

    public void setDireccionUbigeo(String direccionUbigeo) {
        this.direccionUbigeo = direccionUbigeo;
    }

    @Basic
    @Column(name = "TIPO_TRANSITO", nullable = true)
    public Short getTipoTransito() {
        return tipoTransito;
    }

    public void setTipoTransito(Short tipoTransito) {
        this.tipoTransito = tipoTransito;
    }

    @Basic
    @Column(name = "DIRECCION_RECIDENCIA", nullable = true, length = 200)
    public String getDireccionRecidencia() {
        return direccionRecidencia;
    }

    public void setDireccionRecidencia(String direccionRecidencia) {
        this.direccionRecidencia = direccionRecidencia;
    }

    @Basic
    @Column(name = "DIRECCION_REFERENCIA", nullable = true, length = 200)
    public String getDireccionReferencia() {
        return direccionReferencia;
    }

    public void setDireccionReferencia(String direccionReferencia) {
        this.direccionReferencia = direccionReferencia;
    }

    @Basic
    @Column(name = "DIRECCION_UBIGEO_PROC", nullable = true, length = 6)
    public String getDireccionUbigeoProc() {
        return direccionUbigeoProc;
    }

    public void setDireccionUbigeoProc(String direccionUbigeoProc) {
        this.direccionUbigeoProc = direccionUbigeoProc;
    }

    @Basic
    @Column(name = "TIPO_TRANSITO_PROC", nullable = true)
    public Short getTipoTransitoProc() {
        return tipoTransitoProc;
    }

    public void setTipoTransitoProc(Short tipoTransitoProc) {
        this.tipoTransitoProc = tipoTransitoProc;
    }

    @Basic
    @Column(name = "DIRECCION_RECIDENCIA_PROC", nullable = true, length = 200)
    public String getDireccionRecidenciaProc() {
        return direccionRecidenciaProc;
    }

    public void setDireccionRecidenciaProc(String direccionRecidenciaProc) {
        this.direccionRecidenciaProc = direccionRecidenciaProc;
    }

    @Basic
    @Column(name = "DIRECCION_REFERENCIA_PROC", nullable = true, length = 200)
    public String getDireccionReferenciaProc() {
        return direccionReferenciaProc;
    }

    public void setDireccionReferenciaProc(String direccionReferenciaProc) {
        this.direccionReferenciaProc = direccionReferenciaProc;
    }

    @Basic
    @Column(name = "TELEFONO", nullable = true, length = 30)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "TELEFONO_CELULAR", nullable = true, length = 30)
    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    @Basic
    @Column(name = "EMAIL_PRINCIPAL", nullable = true, length = 100)
    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    @Basic
    @Column(name = "EMAIL_OPCIONAL", nullable = true, length = 100)
    public String getEmailOpcional() {
        return emailOpcional;
    }

    public void setEmailOpcional(String emailOpcional) {
        this.emailOpcional = emailOpcional;
    }

    @Basic
    @Column(name = "NACIMIENTO_FECHA", nullable = true)
    public Timestamp getNacimientoFecha() {
        return nacimientoFecha;
    }

    public void setNacimientoFecha(Timestamp nacimientoFecha) {
        this.nacimientoFecha = nacimientoFecha;
    }

    @Basic
    @Column(name = "NACIMIENTO_UBIGEO", nullable = true, length = 6)
    public String getNacimientoUbigeo() {
        return nacimientoUbigeo;
    }

    public void setNacimientoUbigeo(String nacimientoUbigeo) {
        this.nacimientoUbigeo = nacimientoUbigeo;
    }

    @Basic
    @Column(name = "SEXO", nullable = true)
    public Short getSexo() {
        return sexo;
    }

    public void setSexo(Short sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "ESTADO_CIVIL", nullable = true)
    public Short getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Short estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Basic
    @Column(name = "PAIS", nullable = true)
    public Short getPais() {
        return pais;
    }

    public void setPais(Short pais) {
        this.pais = pais;
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
        Persona personas = (Persona) o;
        return estadoRegistro == personas.estadoRegistro && Objects.equals(persona, personas.persona) && Objects.equals(apellidoPaterno, personas.apellidoPaterno) && Objects.equals(apellidoMaterno, personas.apellidoMaterno) && Objects.equals(nombres, personas.nombres) && Objects.equals(direccionUbigeo, personas.direccionUbigeo) && Objects.equals(tipoTransito, personas.tipoTransito) && Objects.equals(direccionRecidencia, personas.direccionRecidencia) && Objects.equals(direccionReferencia, personas.direccionReferencia) && Objects.equals(direccionUbigeoProc, personas.direccionUbigeoProc) && Objects.equals(tipoTransitoProc, personas.tipoTransitoProc) && Objects.equals(direccionRecidenciaProc, personas.direccionRecidenciaProc) && Objects.equals(direccionReferenciaProc, personas.direccionReferenciaProc) && Objects.equals(telefono, personas.telefono) && Objects.equals(telefonoCelular, personas.telefonoCelular) && Objects.equals(emailPrincipal, personas.emailPrincipal) && Objects.equals(emailOpcional, personas.emailOpcional) && Objects.equals(nacimientoFecha, personas.nacimientoFecha) && Objects.equals(nacimientoUbigeo, personas.nacimientoUbigeo) && Objects.equals(sexo, personas.sexo) && Objects.equals(estadoCivil, personas.estadoCivil) && Objects.equals(pais, personas.pais) && Objects.equals(creacionSesion, personas.creacionSesion) && Objects.equals(creacionFecha, personas.creacionFecha) && Objects.equals(controlSesion, personas.controlSesion) && Objects.equals(controlFecha, personas.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persona, apellidoPaterno, apellidoMaterno, nombres, direccionUbigeo, tipoTransito, direccionRecidencia, direccionReferencia, direccionUbigeoProc, tipoTransitoProc, direccionRecidenciaProc, direccionReferenciaProc, telefono, telefonoCelular, emailPrincipal, emailOpcional, nacimientoFecha, nacimientoUbigeo, sexo, estadoCivil, pais, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
