package com.restaurante.microservicios.msccomercial.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PedidoPagoDetPK implements Serializable {
    private String seriePedido;
    private String nroPedido;
    private short itmPago;
    private short itmPedido;

    @Column(name = "SERIE_PEDIDO", nullable = false, length = 10)
    @Id
    public String getSeriePedido() {
        return seriePedido;
    }

    public void setSeriePedido(String seriePedido) {
        this.seriePedido = seriePedido;
    }

    @Column(name = "NRO_PEDIDO", nullable = false, length = 20)
    @Id
    public String getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(String nroPedido) {
        this.nroPedido = nroPedido;
    }

    @Column(name = "ITM_PAGO", nullable = false)
    @Id
    public short getItmPago() {
        return itmPago;
    }

    public void setItmPago(short itmPago) {
        this.itmPago = itmPago;
    }

    @Column(name = "ITM_PEDIDO", nullable = false)
    @Id
    public short getItmPedido() {
        return itmPedido;
    }

    public void setItmPedido(short itmPedido) {
        this.itmPedido = itmPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoPagoDetPK that = (PedidoPagoDetPK) o;
        return itmPago == that.itmPago && itmPedido == that.itmPedido && Objects.equals(seriePedido, that.seriePedido) && Objects.equals(nroPedido, that.nroPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriePedido, nroPedido, itmPago, itmPedido);
    }
}
