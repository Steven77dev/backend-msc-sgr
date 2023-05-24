package com.interconectados.sgrvbackend.models.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BusqMesasRequest {

    private int local;
    private int entidad;
    private String fecha;
    private String estado;
}
