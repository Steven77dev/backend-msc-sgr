package com.restaurante.microservicios.mscfinanzas.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "EGRESO_DIARIO_DET")
@IdClass(EgresoDiarioDetPK.class)
@EqualsAndHashCode
public class EgresoDiarioDet {
    @Id
    @Column(name = "SERIE_ED", nullable = false, length = 10)
    private String serieEd;
    @Id
    @Column(name = "NRO_ED", nullable = false, length = 20)
    private String nroEd;
    @Id
    @Column(name = "ITM_ED", nullable = false)
    private short itmEd;
    @Column(name = "ENTIDAD", nullable = false)
    private short entidad;
    @Column(name = "PRODUCTO", nullable = false, length = 10)
    private String producto;
    @Column(name = "CANTIDAD", nullable = false, precision = 2)
    private BigDecimal cantidad;
    @Column(name = "PRECIO", nullable = true, precision = 2)
    private BigDecimal precio;
    @Column(name = "IMPORTE", nullable = true, precision = 2)
    private BigDecimal importe;
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
    @Column(name = "EXPEDIENTE", nullable = false)
    private String expediente;

}
