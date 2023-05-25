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
public class PedidosMesaResponse {

    @JsonProperty("nro")
    @JsonSetter("NRO")
    private int nro;

    @JsonProperty("itemPedido")
    @JsonSetter("ITM_PEDIDO")
    private int itemPedido;

    @JsonProperty("entidad")
    @JsonSetter("ENTIDAD")
    private int entidad;

    @JsonProperty("producto")
    @JsonSetter("PRODUCTO")
    private String producto;

    @JsonProperty("desProducto")
    @JsonSetter("DESPRODUCTO")
    private String desProducto;

    @JsonProperty("precio")
    @JsonSetter("PRECIO")
    private BigDecimal precio;

    @JsonProperty("cantidad")
    @JsonSetter("CANTIDAD")
    private int cantidad;

    @JsonProperty("subTotal")
    @JsonSetter("SUB_TOTAL")
    private BigDecimal subTotal;

    @JsonProperty("saldoRojo")
    @JsonSetter("SALDO_ROJO")
    private int saldoRojo;

    @JsonProperty("tipoProducto")
    @JsonSetter("TIPO_PRODUCTO")
    private int tipoProducto;

    @JsonProperty("estaAlmacen")
    @JsonSetter("ESTA_ALMACEN")
    private String estaAlmacen;

}
