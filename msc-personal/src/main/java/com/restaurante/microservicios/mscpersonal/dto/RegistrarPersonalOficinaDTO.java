package com.restaurante.microservicios.mscpersonal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrarPersonalOficinaDTO {

    private String codigoPersonal;
    private int codigoOficina;
    private int codigoCargo;
    private int codigoEntidad;
    private int codigoEstado;
    private Date creacionFecha;
    private String creacionSesion;

    @JsonProperty("personal")
    private RegistrarPersonalDTO registrarPersonalDTO;

}
