package com.restaurante.microservicios.mscfinanzas.models.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CuadrarCajaRequest {
    private int local;
    private String fecEmision;
    private int entidad;
    private String emisor;
    private String fechaApertura;
    private String fechaCierre;
    private int idCaja;
    private String nroRspta=null;
    private String session;
}
