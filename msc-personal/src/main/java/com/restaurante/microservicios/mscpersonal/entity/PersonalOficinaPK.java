package com.restaurante.microservicios.mscpersonal.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PersonalOficinaPK implements Serializable {

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



}
