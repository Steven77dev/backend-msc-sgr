package com.restaurante.microservicios.mscfinanzas.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResumenIngrePersonalResponse {

    @JsonProperty(value = "serieId")
    @JsonSetter("SERIE_ID")
    private String serieId;

    @JsonProperty(value = "nroSerie")
    @JsonSetter("NRO_ID")
    private String nroSerie;

    @JsonProperty(value = "codEntidad")
    @JsonSetter("ENTIDAD")
    private int entidad;

    @JsonProperty(value = "codConcepto")
    @JsonSetter("CONCEPTO")
    private String codConcepto;

    @JsonProperty(value = "desConcepto")
    @JsonSetter("DESCONCEPTO")
    private String desConcepto;

    @JsonProperty(value = "total")
    @JsonSetter("TOTAL")
    private BigDecimal total;

    @JsonProperty(value = "hora")
    @JsonSetter("HORA")
    private String hora;

    @JsonProperty(value = "documento")
    @JsonSetter("DOCUMENTO")
    private String documento;

    @JsonProperty(value = "caja")
    @JsonSetter("CAJA")
    private int caja;
}
