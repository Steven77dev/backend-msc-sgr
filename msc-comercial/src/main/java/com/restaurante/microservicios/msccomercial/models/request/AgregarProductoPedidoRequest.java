package com.restaurante.microservicios.msccomercial.models.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AgregarProductoPedidoRequest {
    private String seriePedido;
    private String nroPedido;
    private int itemPedido;
    private int entidad;
    private String producto;
    private BigDecimal precio;
    private int cantidad;
    private BigDecimal subtotal;
    private int estado;
    private String session;
}
