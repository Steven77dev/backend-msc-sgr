package com.restaurante.microservicios.mscpersonal.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "entidad", catalog = "syst")
public class Entidad {
    @Id
    @Column(name = "ENTIDAD", nullable = false)
    private long entidad;
    private String descripcion;
    private String abreviatura;


}
