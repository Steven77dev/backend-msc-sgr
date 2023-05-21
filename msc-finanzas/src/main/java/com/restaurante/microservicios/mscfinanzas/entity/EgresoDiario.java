package com.restaurante.microservicios.mscfinanzas.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "EGRESO_DIARIO")
@IdClass(EgresoDiarioPK.class)
@EqualsAndHashCode
public class EgresoDiario {
    @Id
    @Column(name = "SERIE_ED", nullable = false, length = 10)
    private String serieEd;
    @Id
    @Column(name = "NRO_ED", nullable = false, length = 20)
    private String nroEd;
    @Column(name = "ENTIDAD", nullable = false)
    private int entidad;
    @Column(name = "CONCEPTO", nullable = false, length = 10)
    private String concepto;
    @Column(name = "FECHA_EMISION", nullable = false)
    private Date fechaEmision;
    @Column(name = "EMISOR_PERSONAL", nullable = false, length = 10)
    private String emisorPersonal;
    @Column(name = "RECEPTOR_PERSONAL", nullable = true, length = 10)
    private String receptorPersonal;
    @Column(name = "TOTAL", nullable = false, precision = 2)
    private BigDecimal total;
    @Column(name = "DOCUMENTO", nullable = true, length = 20)
    private String documento;
    @Column(name = "OBSERVACION", nullable = true, length = 300)
    private String observacion;
    @Column(name = "PERSONAL_ANULADO", nullable = true, length = 10)
    private String personalAnulado;
    @Column(name = "MOTIVO_ANULADO", nullable = true)
    private Short motivoAnulado;
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
    @Column(name = "CAJA", nullable = true)
    private int caja;
    @Column(name = "LOCAL_ASIGNADO", nullable = true)
    private int localAsignado;
    @Column(name = "RECEPTOR_PROVEEDOR", nullable = true, length = 10)
    private String receptorProveedor;
    @Column(name = "FORMA_PAGO", nullable = true)
    private int formaPago;
    @Column(name = "BANCO", nullable = true)
    private int banco;
    @Column(name = "CUENTA", nullable = true)
    private int cuenta;
}
