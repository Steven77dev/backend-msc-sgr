package com.restaurante.microservicios.msccomercial.models.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoPedidoItemResponse {
    private String codigoRspta;
    private int itemPedido;
}
