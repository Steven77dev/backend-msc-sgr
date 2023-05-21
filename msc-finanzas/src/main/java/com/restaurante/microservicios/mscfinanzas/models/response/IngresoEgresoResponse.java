package com.restaurante.microservicios.mscfinanzas.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class IngresoEgresoResponse {

    @JsonProperty(value = "nombrePersonal")
    @JsonSetter("DESPERSONAL")
    private String nombrePersonal;

    @JsonProperty("codigoPersonal")
    @JsonSetter("PERSONAL")
    private String codigoPersonal;

    @JsonProperty("fecApertura")
    @JsonSetter("FEC_APERTURA")
    private String fecApertura;

    @JsonProperty("fecCierre")
    @JsonSetter("FEC_FEC_CIERRE")
    private String fecCierre;

    @JsonProperty("ingresoTotal")
    @JsonSetter("ING_TOTAL")
    private BigDecimal ingresoTotal;

    @JsonProperty("ingresoEfectivo")
    @JsonSetter("ING_EFECTIVO")
    private BigDecimal ingresoEfectivo;

    @JsonProperty("salidaEfectivo")
    @JsonSetter("SAL_EFECTIVO")
    private BigDecimal salidaEfectivo;

    @JsonProperty("ganancia")
    @JsonSetter("GANACIA")
    private BigDecimal ganancia;

    @JsonProperty("tieneCierre")
    @JsonSetter("TIENE_CIERRE")
    private String tieneCierre;

    @JsonProperty("montoBoletas")
    @JsonSetter("BOLETA")
    private BigDecimal montoBoletas;

    @JsonProperty("montoFacturas")
    @JsonSetter("FACTURA")
    private BigDecimal montoFacturas;

    @JsonProperty("montoTarjetas")
    @JsonSetter("TARJETA")
    private BigDecimal montoTarjetas;

    @JsonProperty("montoTotalVenta")
    @JsonSetter("TOTAL_VENTA")
    private BigDecimal montoTotalVenta;

    @JsonProperty("montoComprobante")
    @JsonSetter("COMPROBANTE")
    private BigDecimal montoComprobante;

    @JsonProperty("montoDiferencia")
    @JsonSetter("DIFERENCIA")
    private BigDecimal montoDiferencia;

    @JsonProperty("montoPorBoleta")
    @JsonSetter("POR_BOLETA")
    private BigDecimal montoPorBoleta;

    @JsonProperty("montoPorFactura")
    @JsonSetter("POR_FACTURA")
    private BigDecimal montoPorFactura;

    @JsonProperty("montoPorComprobante")
    @JsonSetter("POR_COMPROBANTE")
    private BigDecimal montoPorComprobante;

    @JsonProperty("mensajeCaja")
    @JsonSetter("MENSAJE")
    private String mensaje;

    @JsonProperty("montoCierre")
    @JsonSetter("CIERRE")
    private BigDecimal montoCierre;

    @JsonProperty("horaApertura")
    @JsonSetter("HOR_APERTURA")
    private String horaApertura;

    @JsonProperty("horaCierre")
    @JsonSetter("HOR_CIERRE")
    private String horaCierre;

    @JsonProperty("observacionCierre")
    @JsonSetter("OBSERVACION")
    private String observacion;

    @JsonProperty("observacionAp")
    @JsonSetter("OBSERVACION_AP")
    private String observacionAp;

    @JsonProperty("nombreCaja")
    @JsonSetter("DESCAJA")
    private String nombreCaja;

    @JsonProperty("idCaja")
    @JsonSetter("CAJA")
    private int idCaja;
}
