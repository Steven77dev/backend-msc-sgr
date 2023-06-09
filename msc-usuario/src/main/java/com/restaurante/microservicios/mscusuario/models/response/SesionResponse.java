package com.restaurante.microservicios.mscusuario.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SesionResponse {
    @JsonProperty(value = "estado")
    @JsonSetter("ESTADO")
    private int estado;
    @JsonProperty(value ="descripcion")
    @JsonSetter(value ="DESCRIPCION")
    private String descripcion;
    @JsonProperty(value ="sesion")
    @JsonSetter(value ="SESION")
    private String sesion;

}
