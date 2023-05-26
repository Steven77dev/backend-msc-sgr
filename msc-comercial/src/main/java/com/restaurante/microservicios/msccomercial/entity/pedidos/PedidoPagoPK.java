package com.restaurante.microservicios.msccomercial.entity.pedidos;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PedidoPagoPK implements Serializable {
    private String seriePedido;
    private String nroPedido;
    private short itmPago;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoPagoPK that = (PedidoPagoPK) o;
        return itmPago == that.itmPago && Objects.equals(seriePedido, that.seriePedido) && Objects.equals(nroPedido, that.nroPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriePedido, nroPedido, itmPago);
    }
}
