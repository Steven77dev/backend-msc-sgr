package com.restaurante.microservicios.mscubicacion.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Local implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "LOCAL")
    private int local;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "ABREVIATURA")
    private String abreviatura;

    @Column(name = "UBIGEO")
    private String ubigeo;

    @Column(name = "TELEFONO1")
    private String telefono1;

    @Column(name = "TELEFONO2")
    private String telefono2;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "CAPACIDAD")
    private int capacidad;

    @Column(name = "ESTADO_REGISTRO")
    private int estadoRegistro;

    @Column(name = "CREACION_SESION", nullable = false, length = 30)
    private String creacionSesion;
    @Column(name = "CREACION_FECHA", nullable = false)
    private Date creacionFecha;
    @Column(name = "CONTROL_SESION", nullable = false, length = 30)
    private String controlSesion;
    @Column(name = "CONTROL_FECHA", nullable = false)
    private Date controlFecha;
}