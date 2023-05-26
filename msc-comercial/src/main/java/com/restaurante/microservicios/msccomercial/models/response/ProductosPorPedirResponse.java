package com.restaurante.microservicios.msccomercial.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductosPorPedirResponse {

    @JsonSetter("PRODUCTO")
    private String producto;

    @JsonProperty("desProducto")
    @JsonSetter("DESPRODUCTO")
    private String desProducto;

    @JsonProperty("precio")
    @JsonSetter("PRECIO")
    private BigDecimal precio;

    @JsonProperty("desFamilia")
    @JsonSetter("DESFAMILIA")
    private String desFamilia;

    @JsonProperty("saldo")
    @JsonSetter("SALDO")
    private BigDecimal saldo;

    @JsonProperty("precioFormateado")
    @JsonSetter("PRECIO_FORMAT")
    private String precioFormateado;

    @JsonProperty("tipoProducto")
    @JsonSetter("TIPO_PRODUCTO")
    private int tipoProducto;

}
