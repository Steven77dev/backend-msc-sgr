package com.restaurante.microservicios.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalAsignadoDTO {

    private String personal;
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

    public PersonalAsignadoDTO(String personal, String persona, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.personal = personal;
        this.codigoPersona = persona;
        this.nombres = nombres;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
    }
}
