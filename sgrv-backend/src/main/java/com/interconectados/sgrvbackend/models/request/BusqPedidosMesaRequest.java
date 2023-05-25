package com.interconectados.sgrvbackend.models.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BusqPedidosMesaRequest {

    private String seriePedido;
    private String nroPedido;
    private int itemPedido;
    private String entidad;
    private String almacen;
}
