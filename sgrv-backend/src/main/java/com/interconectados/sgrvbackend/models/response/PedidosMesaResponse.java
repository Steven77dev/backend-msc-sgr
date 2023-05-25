package com.interconectados.sgrvbackend.models.response;

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

    private int nro;
    private int itemPedido;
    private int entidad;
    private String producto;
    private String desProducto;
    private BigDecimal precio;
    private int cantidad;
    private BigDecimal subTotal;
    private int saldoRojo;
    private int tipoProducto;
    private String estaAlmacen;

}
