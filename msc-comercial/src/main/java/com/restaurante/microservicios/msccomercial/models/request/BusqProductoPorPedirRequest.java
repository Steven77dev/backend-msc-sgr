package com.restaurante.microservicios.msccomercial.models.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BusqProductoPorPedirRequest {

    private String almacen;
    private int entidad;
    private String familia;
    private String local;
}
