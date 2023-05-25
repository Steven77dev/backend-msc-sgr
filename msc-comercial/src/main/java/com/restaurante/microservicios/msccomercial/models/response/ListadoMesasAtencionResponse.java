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
public class ListadoMesasAtencionResponse {

    @JsonProperty("codMesa")
    @JsonSetter("MESA")
    private int codMesa;

    @JsonProperty("desMesa")
    @JsonSetter("DESMESA")
    private String desMesa;

    @JsonProperty("seriePedido")
    @JsonSetter("SERIE_PEDIDO")
    private String seriePedido;

    @JsonProperty("nroPedido")
    @JsonSetter("NRO_PEDIDO")
    private String nroPedido;

    @JsonProperty("codEstadoRegistro")
    @JsonSetter("ESTADO")
    private String codEstadoRegistro;

    @JsonProperty("desEstadoRegistro")
    @JsonSetter("DESESTADO")
    private String desEstadoRegistro;

    @JsonProperty("mesaPrincipal")
    @JsonSetter("MESA_PRINCIPAL")
    private String mesaPrincipal;

    @JsonProperty("puntoAtencion")
    @JsonSetter("PATENCION")
    private String puntoAtencion;

    @JsonProperty("montoTotal")
    @JsonSetter("MONTO_TOTAL")
    private BigDecimal montoTotal;

    @JsonProperty("desCliente")
    @JsonSetter("CLIENTE")
    private String desCliente;

    @JsonProperty("cantidad")
    @JsonSetter("CANTIDAD")
    private String cantidad;
}
