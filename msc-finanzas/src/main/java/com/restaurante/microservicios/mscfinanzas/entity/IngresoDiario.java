package com.restaurante.microservicios.mscfinanzas.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "INGRESO_DIARIO")
@IdClass(IngresoDiarioPK.class)
@EqualsAndHashCode

@NamedStoredProcedureQuery(
        name = "CuadrarCaja",
        procedureName = "FINA.SQL_CUADRE_CAJA",
        parameters = {
                @StoredProcedureParameter(name = "LITIPSQL", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LILOCALE", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSFECEMI", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LIENTIDA", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSEMISOR", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSFECAPE", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSFECCIE", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LINROCAJ", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LINUMRES", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LSSESION", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "CerrarCaja",
        procedureName = "FINA.SQL_CIERRE_CAJA",
        parameters = {
                @StoredProcedureParameter(name = "LITIPSQL", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LILOCALE", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSFECEMI", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LIENTIDA", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSEMISOR", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSFECAPE", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSFECCIE", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSOBSERV", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LINROCAJ", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LINUMRES", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LSSESION", type = String.class, mode = ParameterMode.IN)
        }
)
public class IngresoDiario {
    @Id
    @Column(name = "SERIE_ID", nullable = false, length = 10)
    private String serieId;
    @Id
    @Column(name = "NRO_ID", nullable = false, length = 20)
    private String nroId;
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

}
