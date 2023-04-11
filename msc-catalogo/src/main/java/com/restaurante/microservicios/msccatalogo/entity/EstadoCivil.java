package com.restaurante.microservicios.msccatalogo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ESTADO_CIVIL")
public class EstadoCivil {
    @Id
    @Column(name = "ESTADO_CIVIL", nullable = false)
    private long estadoCivil;
    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;
    @Column(name = "DESCRIPCIONF", nullable = true, length = 50)
    private String descripcionf;
    @Column(name = "ABREVIATURA", nullable = true, length = 5)
    private String abreviatura;
    @Column(name = "ESTADO_REGISTRO", nullable = false)
    private long estadoRegistro;
    @JsonIgnore
    @Column(name = "CREACION_SESION", nullable = false, length = 30)
    private String creacionSesion;
    @Column(name = "CREACION_FECHA", nullable = false)
    private Date creacionFecha;
    @JsonIgnore
    @Column(name = "CONTROL_SESION", length = 30)
    private String controlSesion;
    @Basic
    @Column(name = "CONTROL_FECHA")
    private Date controlFecha;
}
