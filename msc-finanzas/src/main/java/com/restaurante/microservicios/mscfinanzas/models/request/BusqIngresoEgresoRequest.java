package com.restaurante.microservicios.mscfinanzas.models.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BusqIngresoEgresoRequest {
    private String local;
    private String desFecha;
}
