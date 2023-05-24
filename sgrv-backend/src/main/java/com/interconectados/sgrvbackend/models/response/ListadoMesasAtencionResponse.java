package com.interconectados.sgrvbackend.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListadoMesasAtencionResponse {

    private int codMesa;
    private String desMesa;
    private String seriePedido;
    private String nroPedido;
    private String codEstadoRegistro;
    private String desEstadoRegistro;
    private String mesaPrincipal;
    private String puntoAtencion;
    private String montoTotal;
    private String desCliente;
    private String cantidad;
}
