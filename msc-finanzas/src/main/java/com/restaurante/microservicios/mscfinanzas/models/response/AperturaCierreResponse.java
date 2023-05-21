package com.restaurante.microservicios.mscfinanzas.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AperturaCierreResponse {

    @JsonProperty(value = "apertura")
    @JsonSetter("APERTURA")
    private int apertura;

    @JsonProperty(value = "cierra")
    @JsonSetter("CIERRA")
    private int cierra;
}
