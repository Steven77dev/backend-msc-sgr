package com.restaurante.microservicios.msccatalogo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ESTADO_REGISTROS")
@Getter
@Setter
@EqualsAndHashCode
public class EstadoRegistros {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   // @Column(name = "ESTADO_REGISTRO", nullable = false)
    private long estadoRegistro;
    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;
    @Column(name = "ABREVIATURA", nullable = true, length = 5)
    private String abreviatura;
    @Column(name = "TIPO_ESTADO", nullable = true)
    private Short tipoEstado;
    @Basic(optional = false)
    @Column(name = "CREACION_SESION", length = 30)
    private String creacionSesion;
    @Basic
    @Column(name = "CREACION_FECHA")
    @Temporal(TemporalType.DATE)
    private Date creacionFecha;
    @Column(name = "CONTROL_SESION",  length = 30 )
    private String controlSesion;
    @Column(name = "CONTROL_FECHA", nullable = true)
    private Date controlFecha;

    @Id
    @Column(name = "ESTADO_REGISTRO", nullable = false)
    public long getEstadoRegistro() {
        return estadoRegistro;
    }

    /*@Column(name = "CREACION_FECHA", nullable = true, updatable = true)
    public Date getCreacionFecha() {
        return creacionFecha;
    }*/

}
