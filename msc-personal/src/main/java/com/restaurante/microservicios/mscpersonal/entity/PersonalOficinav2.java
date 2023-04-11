package com.restaurante.microservicios.mscpersonal.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PERSONAL_OFICINA")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@IdClass(PersonalOficinaPK.class)
public class PersonalOficinav2 implements Serializable {
    @Id
    @Column(name = "PERSONAL", nullable = false)
    private String codigoPersonal;
    @Id
    @Column(name = "CARGO", nullable = false)
    private long codigoCargo;
    @Id
    @Column(name = "OFICINA", nullable = false)
    private long codigoOficina;
    @Id
    @Column(name = "ENTIDAD", nullable = false)
    private long codigoEntidad;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal", insertable = false, updatable = false)
    private Personalv2 personal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entidad", insertable = false, updatable = false)
    private Entidad entidad;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oficina", insertable = false, updatable = false)
    //@Column(name = "OFICINA", nullable = false)
    private Oficina oficina;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo", insertable = false, updatable = false)
    private Cargo cargo;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_registro")
    private EstadoRegistros estado;

    @Column(name = "CREACION_SESION", nullable = false, length = 30)
    private String creacionSesion;

    @Column(name = "CREACION_FECHA", nullable = false)
    private Date creacionFecha;

    @Column(name = "CONTROL_SESION", length = 30)
    private String controlSesion;

    @Column(name = "CONTROL_FECHA")
    private Date controlFecha;


}
