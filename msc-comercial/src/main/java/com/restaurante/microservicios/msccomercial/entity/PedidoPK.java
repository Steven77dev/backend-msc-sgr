package com.restaurante.microservicios.msccomercial.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PedidoPK implements Serializable {
    private String seriePedido;
    private String nroPedido;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoPK pedidoPK = (PedidoPK) o;
        return Objects.equals(seriePedido, pedidoPK.seriePedido) && Objects.equals(nroPedido, pedidoPK.nroPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriePedido, nroPedido);
    }
}
