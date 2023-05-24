package com.restaurante.microservicios.msccomercial.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PedidoMesaPK implements Serializable {
    private String seriePedido;
    private String nroPedido;
    private short entidad;
    private short local;
    private short mesa;

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

    @Column(name = "ENTIDAD", nullable = false)
    @Id
    public short getEntidad() {
        return entidad;
    }

    public void setEntidad(short entidad) {
        this.entidad = entidad;
    }

    @Column(name = "LOCAL", nullable = false)
    @Id
    public short getLocal() {
        return local;
    }

    public void setLocal(short local) {
        this.local = local;
    }

    @Column(name = "MESA", nullable = false)
    @Id
    public short getMesa() {
        return mesa;
    }

    public void setMesa(short mesa) {
        this.mesa = mesa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoMesaPK that = (PedidoMesaPK) o;
        return entidad == that.entidad && local == that.local && mesa == that.mesa && Objects.equals(seriePedido, that.seriePedido) && Objects.equals(nroPedido, that.nroPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriePedido, nroPedido, entidad, local, mesa);
    }
}
