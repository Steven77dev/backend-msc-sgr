package com.restaurante.microservicios.mscpersonal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CARGO")
    private long cargo;
    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;
    @Column(name = "ABREVIATURA", length = 5)
    private String abreviatura;
    @JsonIgnore
    @Column(name = "CREACION_SESION", length = 30)
    private String creacionSesion;

    @Column(name = "CREACION_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creacionFecha;
    @JsonIgnore
    @Column(name = "CONTROL_SESION",  length = 30 )
    private String controlSesion;

    @Column(name = "CONTROL_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date controlFecha;
}
