package com.restaurante.microservicios.mscpersonal.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO_REGISTROS", catalog = "syst")
@Getter
@Setter
@EqualsAndHashCode
public class EstadoRegistros {
    @Id
    @Column(name = "ESTADO_REGISTRO", nullable = false)
    private long estadoRegistro;
    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;
    @Column(name = "ABREVIATURA", nullable = true, length = 5)
    private String abreviatura;


}
