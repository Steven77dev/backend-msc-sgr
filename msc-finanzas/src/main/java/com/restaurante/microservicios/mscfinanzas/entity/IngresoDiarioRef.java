package com.restaurante.microservicios.mscfinanzas.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "INGRESO_DIARIO_REF")
@IdClass(IngresoDiarioRefPK.class)
@Getter
@Setter
@EqualsAndHashCode
public class IngresoDiarioRef {
    @Id
    @Column(name = "SERIE_ID", nullable = false, length = 10)
    private String serieId;
    @Id
    @Column(name = "NRO_ID", nullable = false, length = 20)
    private String nroId;
    @Id
    @Column(name = "EXPEDIENTE", nullable = false, length = 30)
    private String expediente;
    @Column(name = "ESTADO_REGISTRO", nullable = false)
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
