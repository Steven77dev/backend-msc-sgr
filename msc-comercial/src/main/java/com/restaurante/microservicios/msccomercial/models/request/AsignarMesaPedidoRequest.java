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
public class AsignarMesaPedidoRequest {
    private String seriePedido;
    private String nroPedido;
    private int entidad;
    private int local;
    private int nroMesa;
    private int estado;
    private String session;
}
