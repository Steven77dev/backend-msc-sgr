package com.restaurante.microservicios.mscfinanzas.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class EgresoDiarioDetPK implements Serializable {
    @Column(name = "SERIE_ED", nullable = false, length = 10)
    @Id
    private String serieEd;
    @Column(name = "NRO_ED", nullable = false, length = 20)
    @Id
    private String nroEd;
    @Column(name = "ITM_ED", nullable = false)
    @Id
    private int itmEd;

}
