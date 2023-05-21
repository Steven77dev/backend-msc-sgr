package com.restaurante.microservicios.mscfinanzas.models.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BusqIngresoPersonalRequest {
    private String local;
    private String desFecha;
    private String codPersonal;
    private String desFecHoraInicio;
    private String desFecHoraFin;
}
