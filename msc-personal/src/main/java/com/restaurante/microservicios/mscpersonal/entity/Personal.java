package com.restaurante.microservicios.mscpersonal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Personal {
    @Id
    @Column(name = "PERSONAL", nullable = false, length = 10)
    private String personal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona")
    private Persona persona;

    @Column(name = "ESTADO_REGISTRO", nullable = false)
    private long estadoRegistro;
    @JsonIgnore
    @Column(name = "CREACION_SESION", nullable = false, length = 30)
    private String creacionSesion;
    @JsonIgnore
    @Column(name = "CREACION_FECHA", nullable = false)
    private Date creacionFecha = new Date();
    @JsonIgnore
    @Column(name = "CONTROL_SESION", length = 30)
    private String controlSesion;
    @JsonIgnore
    @Column(name = "CONTROL_FECHA")
    private Date controlFecha;


}
