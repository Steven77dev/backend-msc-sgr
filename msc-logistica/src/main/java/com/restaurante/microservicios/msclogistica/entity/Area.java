package com.restaurante.microservicios.msclogistica.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "area")
@Getter
@Setter
@EqualsAndHashCode
public class Area {

    @Id
    private long area;
    @Column(name = "DESCRIPCION", nullable = false, length = 50 )
    private String descripcion;
    private String abreviatura;
    private int estadoRegistro;
    @Column(name = "CREACION_SESION")
    private String creacionSesion;
    @Column(name = "CREACION_FECHA")
    private Date creacionFecha = new Date();
    @Column(name = "CONTROL_SESION")
    private String controlSesion;
    @Column(name = "CONTROL_FECHA", insertable = false, updatable = false)
    private Date controlFecha = new Date();


}
