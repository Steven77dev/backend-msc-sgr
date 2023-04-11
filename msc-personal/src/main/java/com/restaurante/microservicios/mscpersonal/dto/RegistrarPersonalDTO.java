package com.restaurante.microservicios.mscpersonal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrarPersonalDTO {

    private String codigoPersonal;
    private String codigoPersona;
    private int codigoEstado;
    private Date creacionFecha;
    private String creacionSesion;

}
