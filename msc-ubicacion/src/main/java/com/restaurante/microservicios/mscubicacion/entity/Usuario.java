package com.restaurante.microservicios.mscubicacion.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Usuario {
    @Id
    @Column(name = "USUARIO", nullable = false, length = 30)
    private String codigo;
    @Column(name = "PERSONA", nullable = false, length = 20)
    private String persona;
    @Column(name = "CLAVE", nullable = false, length = 100)
    private String clave;
    @Column(name = "FECHA_DESDE", nullable = false)
    private Date fechaDesde;
    @Column(name = "FECHA_HASTA", nullable = true)
    private Date fechaHasta;
    @Column(name = "FECHA_CONEXION", nullable = true)
    private Date fechaConexion;
    @Column(name = "ULTIMA_CONEXION", nullable = true, length = 500)
    private String ultimaConexion;
    @Column(name = "ESTADO_REGISTRO", nullable = false)
    private short estadoRegistro;
    @Column(name = "CREACION_SESION", nullable = false, length = 30)
    private String creacionSesion;
    @Column(name = "CREACION_FECHA", nullable = false)
    private Date creacionFecha;
    @Column(name = "CONTROL_SESION", nullable = false, length = 30)
    private String controlSesion;
    @Column(name = "CONTROL_FECHA", nullable = false)
    private Date controlFecha;


}
