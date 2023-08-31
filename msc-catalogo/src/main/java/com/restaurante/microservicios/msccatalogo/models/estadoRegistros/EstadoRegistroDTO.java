package com.restaurante.microservicios.msccatalogo.models.estadoRegistros;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoRegistroDTO {
    private String descripcion;
    private String abreviatura;
    private Short tipoEstado;
    private String creacionSesion;
}
