package com.restaurante.microservicios.msccomercial.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductosPorPedirResponse implements Serializable {
    @JsonProperty("producto")
    private String producto;

    @JsonProperty("desProducto")
    private String desProducto;

    @JsonProperty("precio")
    private BigDecimal precio;

    @JsonProperty("desFamilia")
    private String desFamilia;

    @JsonProperty("saldo")
    private BigDecimal saldo;

    @JsonProperty("precioFormateado")
    private String precioFormateado;

    @JsonProperty("tipoProducto")
    private int tipoProducto;

}
