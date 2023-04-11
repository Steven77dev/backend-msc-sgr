package com.restaurante.microservicios.mscpersonal.service.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonaModel {

    private String persona;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
}
