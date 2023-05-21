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
public class IngresoDiarioRefPK implements Serializable {
    @Column(name = "SERIE_ID", nullable = false, length = 10)
    @Id
    private String serieId;

    @Column(name = "NRO_ID", nullable = false, length = 20)
    @Id
    private String nroId;

    @Column(name = "EXPEDIENTE", nullable = false, length = 30)
    @Id
    private String expediente;

}
