package com.interconectados.sgrvbackend.models.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CrearPedidoRequest {
    private String nombreCliente;
    private String personalAtencion;
    private String fechaIngreso;
    private BigDecimal montoTotal;
    private String observacion;
    private int cantidadPersonas;
    private int local;
    private int puntoAtencion;
    private int estado;
    private String session;
    private AsignarMesaPedidoRequest asignarMesaPedido;
}
