package com.restaurante.microservicios.mscpersonal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAS", catalog = "dato")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Persona {
    private static final long serialVersionUID = 1L;

    private String persona;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;

    @Id
    @Column(name = "PERSONA", nullable = false, length = 20)
    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    @Column(name = "APELLIDO_PATERNO", nullable = true, length = 50)
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Column(name = "APELLIDO_MATERNO", nullable = true, length = 50)
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Column(name = "NOMBRES", nullable = true, length = 50)
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


}
