package com.restaurante.microservicios.msccomercial.models.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoCreadoResponse {
    private String seriePedido;
    private String nroPedido;
    private String codigoRspta;
    private String codigoPedido;
}
