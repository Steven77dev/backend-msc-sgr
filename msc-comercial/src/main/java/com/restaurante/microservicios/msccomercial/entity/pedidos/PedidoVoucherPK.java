package com.restaurante.microservicios.msccomercial.entity.pedidos;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PedidoVoucherPK implements Serializable {
    private String seriePedido;
    private String nroPedido;
    private short itmVoucher;

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

    @Column(name = "ITM_VOUCHER", nullable = false)
    @Id
    public short getItmVoucher() {
        return itmVoucher;
    }

    public void setItmVoucher(short itmVoucher) {
        this.itmVoucher = itmVoucher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoVoucherPK that = (PedidoVoucherPK) o;
        return itmVoucher == that.itmVoucher && Objects.equals(seriePedido, that.seriePedido) && Objects.equals(nroPedido, that.nroPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriePedido, nroPedido, itmVoucher);
    }
}
