package com.restaurante.microservicios.mscpersonal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalAsignadoDTO {

    private String codigoPersonal;
    private String codigoPersona;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String desEntidad;
    private String desOficina;
    private String desCargo;
    private String desEstado;
    private int codigoOficina;
    private int codigoCargo;
    private int codigoEntidad;
    private int codigoEstado;



}
