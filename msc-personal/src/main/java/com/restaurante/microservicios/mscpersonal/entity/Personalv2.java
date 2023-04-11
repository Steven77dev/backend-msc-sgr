package com.restaurante.microservicios.mscpersonal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PERSONAL")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Personalv2 {
    @Id
    @Column(name = "PERSONAL", nullable = false, length = 10)
    private String personal;
    @Column(name = "PERSONA")
    private String persona;

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
